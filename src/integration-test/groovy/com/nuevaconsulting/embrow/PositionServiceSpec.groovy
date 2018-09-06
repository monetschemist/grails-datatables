package com.nuevaconsulting.embrow

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PositionServiceSpec extends Specification {

    PositionService positionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Position(...).save(flush: true, failOnError: true)
        //new Position(...).save(flush: true, failOnError: true)
        //Position position = new Position(...).save(flush: true, failOnError: true)
        //new Position(...).save(flush: true, failOnError: true)
        //new Position(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //position.id
    }

    void "test get"() {
        setupData()

        expect:
        positionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Position> positionList = positionService.list(max: 2, offset: 2)

        then:
        positionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        positionService.count() == 5
    }

    void "test delete"() {
        Long positionId = setupData()

        expect:
        positionService.count() == 5

        when:
        positionService.delete(positionId)
        sessionFactory.currentSession.flush()

        then:
        positionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Position position = new Position()
        positionService.save(position)

        then:
        position.id != null
    }
}
