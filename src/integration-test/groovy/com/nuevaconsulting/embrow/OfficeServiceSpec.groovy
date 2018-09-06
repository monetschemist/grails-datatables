package com.nuevaconsulting.embrow

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OfficeServiceSpec extends Specification {

    OfficeService officeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Office(...).save(flush: true, failOnError: true)
        //new Office(...).save(flush: true, failOnError: true)
        //Office office = new Office(...).save(flush: true, failOnError: true)
        //new Office(...).save(flush: true, failOnError: true)
        //new Office(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //office.id
    }

    void "test get"() {
        setupData()

        expect:
        officeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Office> officeList = officeService.list(max: 2, offset: 2)

        then:
        officeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        officeService.count() == 5
    }

    void "test delete"() {
        Long officeId = setupData()

        expect:
        officeService.count() == 5

        when:
        officeService.delete(officeId)
        sessionFactory.currentSession.flush()

        then:
        officeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Office office = new Office()
        officeService.save(office)

        then:
        office.id != null
    }
}
