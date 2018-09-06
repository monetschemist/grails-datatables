package com.nuevaconsulting.embrow

class Employee {

	String surname
	String givenNames
	Position position
	Office office
	int extension
	Date hired
	int salary
    static constraints = {
		surname nullable: false, blank: false
		givenNames nullable: false, blank: false
		position nullable: false
		office nullable: false
		extension nullable: false
		hired nullable: false
		salary nullable: false
    }
}
