package com.nuevaconsulting.embrow

class Office {

	String name
	String address
	String city
	String country

    static constraints = {
		name nullable: false, blank: false
		address nullable: false, blank: false
		city nullable: false, blank: false
		country nullable: false, blank: false
    }
}
