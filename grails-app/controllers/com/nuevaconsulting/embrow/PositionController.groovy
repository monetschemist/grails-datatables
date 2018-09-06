package com.nuevaconsulting.embrow

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PositionController {

    PositionService positionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond positionService.list(params), model:[positionCount: positionService.count()]
    }

    def show(Long id) {
        respond positionService.get(id)
    }

    def create() {
        respond new Position(params)
    }

    def save(Position position) {
        if (position == null) {
            notFound()
            return
        }

        try {
            positionService.save(position)
        } catch (ValidationException e) {
            respond position.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'position.label', default: 'Position'), position.id])
                redirect position
            }
            '*' { respond position, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond positionService.get(id)
    }

    def update(Position position) {
        if (position == null) {
            notFound()
            return
        }

        try {
            positionService.save(position)
        } catch (ValidationException e) {
            respond position.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'position.label', default: 'Position'), position.id])
                redirect position
            }
            '*'{ respond position, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        positionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'position.label', default: 'Position'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'position.label', default: 'Position'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
