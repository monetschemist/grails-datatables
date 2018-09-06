package com.nuevaconsulting.embrow

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import java.text.DecimalFormat

class EmployeeController {

	EmployeeService employeeService

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond employeeService.list(params), model:[employeeCount: employeeService.count()]
	}

	// responsible for displaying the browser page, which then does
	// AJAX calls to browserLister()

	def browser(Integer max) {
		println "employee browser: params $params"
		respond 'unused response'
	}

	def browserLister() {
		
		// Applies filters and sorting to return a list of desired employees

		println "employee browserLister params $params"
		println()
		def jqdtParams = [:]
		params.each { key, value ->
			def keyFields = key.replace(']','').split(/\[/)
			def table = jqdtParams
			for (int f = 0; f < keyFields.size() - 1; f++) {
				def keyField = keyFields[f]
				if (!table.containsKey(keyField))
					table[keyField] = [:]
				table = table[keyField]
			}
			table[keyFields[-1]] = value
		}
		println "employee dataTableParams $jqdtParams"
		println()
		def columnMap = jqdtParams.columns.collectEntries { k, v ->
			def whereTerm = null
			switch (v.data) {
			case 'extension':
			case 'hired':
			case 'salary':
				if (v.search.value ==~ /\d+(,\d+)*/)
					whereTerm = v.search.value.split(',').collect { it as Integer }
				break
			default:
				if (v.search.value ==~ /[A-Za-z0-9 ]+/)
					whereTerm = "%${v.search.value}%" as String
				break
			}
			[(v.data): [where: whereTerm]]
		}
		println "employee columnMap $columnMap"
		println()
		def allColumnList = columnMap.keySet() as List
		println "employee allColumnList $allColumnList"
		def orderList = jqdtParams.order.collect { k, v -> [allColumnList[v.column as Integer], v.dir] }
		println "employee orderList $orderList"
		def filterer = {
			createAlias 'position',        'p'
			createAlias 'office',          'o'

			if (columnMap.surname.where)    ilike  'surname',     columnMap.surname.where
			if (columnMap.givenNames.where) ilike  'givenNames',  columnMap.givenNames.where
			if (columnMap.position.where)   ilike  'p.name',      columnMap.position.where
			if (columnMap.office.where)     ilike  'o.name',      columnMap.office.where
			if (columnMap.extension.where)  inList 'extension',   columnMap.extension.where
			if (columnMap.salary.where)     inList 'salary',      columnMap.salary.where
			if (columnMap.hired.where) {
				if (columnMap.hired.where.size() > 1) {
					or {
						columnMap.hired.where.each {
							between 'hired', Date.parse('yyyy/MM/dd',"${it}/01/01" as String),
								Date.parse('yyyy/MM/dd',"${it}/12/31" as String)
						}
					}
				} else {
					between 'hired', Date.parse('yyyy/MM/dd',"${columnMap.hired.where[0]}/01/01" as String),
						Date.parse('yyyy/MM/dd',"${columnMap.hired.where[0]}/12/31" as String)
				}
			}
		}
		def recordsTotal = Employee.count()
		println "employee recordsTotal $recordsTotal"
		def c = Employee.createCriteria()
		def recordsFiltered = c.count {
			filterer.delegate = delegate
			filterer()
		}
		println "employee recordsFiltered $recordsFiltered"
		def orderer = Employee.withCriteria {
			filterer.delegate = delegate
			filterer()
			orderList.each { oi ->
				switch (oi[0]) {
				case 'surname':    order 'surname',    oi[1]; break
				case 'givenNames': order 'givenNames', oi[1]; break
				case 'position':   order 'p.name',     oi[1]; break
				case 'office':     order 'o.name',     oi[1]; break
				case 'extension':  order 'extension',  oi[1]; break
				case 'hired':      order 'hired',      oi[1]; break
				case 'salary':     order 'salary',     oi[1]; break
				}
			}
			maxResults (jqdtParams.length as Integer)
			firstResult (jqdtParams.start as Integer)
		}
		def dollarFormatter = new DecimalFormat('$##,###.##')
		def employees = orderer.collect { employee ->
		 	['surname': "<a href='${createLink(controller: 'employee', action: 'show', id: employee.id)}'>${employee.surname}</a>",
		 		'givenNames': employee.givenNames,
		 		'position': "<a href='${createLink(controller: 'position', action: 'show', id: employee.position?.id)}'>${employee.position?.name}</a>",
		 		'office': "<a href='${createLink(controller: 'office', action: 'show', id: employee.office?.id)}'>${employee.office?.name}</a>",
		 		'extension': employee.extension,
		 		'hired': employee.hired.format('yyyy/MM/dd'),
		 		'salary': dollarFormatter.format(employee.salary)]
		}
		def result = [draw: jqdtParams.draw, recordsTotal: recordsTotal, recordsFiltered: recordsFiltered, data: employees]
		render(result as JSON)
	}

	def show(Long id) {
		respond employeeService.get(id)
	}

	def create() {
		respond new Employee(params)
	}

	def save(Employee employee) {
		if (employee == null) {
			notFound()
			return
		}

		try {
			employeeService.save(employee)
		} catch (ValidationException e) {
			respond employee.errors, view:'create'
			return
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'employee.label', default: 'Employee'), employee.id])
				redirect employee
			}
			'*' { respond employee, [status: CREATED] }
		}
	}

	def edit(Long id) {
		respond employeeService.get(id)
	}

	def update(Employee employee) {
		if (employee == null) {
			notFound()
			return
		}

		try {
			employeeService.save(employee)
		} catch (ValidationException e) {
			respond employee.errors, view:'edit'
			return
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'employee.label', default: 'Employee'), employee.id])
				redirect employee
			}
			'*'{ respond employee, [status: OK] }
		}
	}

	def delete(Long id) {
		if (id == null) {
			notFound()
			return
		}

		employeeService.delete(id)

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'employee.label', default: 'Employee'), id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), params.id])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
