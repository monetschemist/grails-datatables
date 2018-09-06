package com.nuevaconsulting.embrow

class Position {

	String name
	int starting

    static constraints = {
		name nullable: false, blank: false
		starting nullable: false
    }
}
