package com.nuevaconsulting.embrow

import grails.gorm.services.Service

@Service(Position)
interface PositionService {

    Position get(Serializable id)

    List<Position> list(Map args)

    Long count()

    void delete(Serializable id)

    Position save(Position position)

}