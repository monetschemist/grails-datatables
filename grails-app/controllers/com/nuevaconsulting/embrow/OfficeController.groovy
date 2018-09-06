package com.nuevaconsulting.embrow

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OfficeController {

    OfficeService officeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond officeService.list(params), model:[officeCount: officeService.count()]
    }

    def show(Long id) {
        respond officeService.get(id)
    }

    def create() {
        respond new Office(params)
    }

    def save(Office office) {
        if (office == null) {
            notFound()
            return
        }

        try {
            officeService.save(office)
        } catch (ValidationException e) {
            respond office.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'office.label', default: 'Office'), office.id])
                redirect office
            }
            '*' { respond office, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond officeService.get(id)
    }

    def update(Office office) {
        if (office == null) {
            notFound()
            return
        }

        try {
            officeService.save(office)
        } catch (ValidationException e) {
            respond office.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'office.label', default: 'Office'), office.id])
                redirect office
            }
            '*'{ respond office, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        officeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'office.label', default: 'Office'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'office.label', default: 'Office'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
