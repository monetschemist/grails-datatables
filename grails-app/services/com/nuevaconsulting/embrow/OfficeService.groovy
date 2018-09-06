package com.nuevaconsulting.embrow

import grails.gorm.services.Service

@Service(Office)
interface OfficeService {

    Office get(Serializable id)

    List<Office> list(Map args)

    Long count()

    void delete(Serializable id)

    Office save(Office office)

}