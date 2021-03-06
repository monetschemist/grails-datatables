package com.nuevaconsulting

import com.nuevaconsulting.embrow.*

class BootStrap {

    def init = { servletContext ->

		new Office(name: 'Edinburgh', address: '20 Dick Place', city: 'Edinburgh', country: 'UK').save()
		new Office(name: 'London', address: '303 West Poultry Avenue', city: 'London', country: 'UK').save()
		new Office(name: 'New York', address: '641 Lefferts Avenue', city: 'Brooklyn', country: 'USA').save()
		new Office(name: 'San Francisco', address: '3299 20th Street', city: 'San Francisco', country: 'USA').save()
		new Office(name: 'Sidney', address: '9870 2nd Street', city: 'Sidney', country: 'Canada').save()
		new Office(name: 'Singapore', address: '20 Sinaran Drive', city: 'Singapore', country: 'Singapore').save()
		new Office(name: 'Tokyo', address: '4a Chome-18 Nihonbashihonch? ', city: 'Tokyo', country: 'Japan').save()

		new Position(name: 'Accountant', starting: 146430).save()
		new Position(name: 'Chief Executive Officer (CEO)', starting: 840000).save()
		new Position(name: 'Chief Financial Officer (CFO)', starting: 580000).save()
		new Position(name: 'Chief Marketing Officer (CMO)', starting: 472500).save()
		new Position(name: 'Chief Operating Officer (COO)', starting: 850000).save()
		new Position(name: 'Customer Support', starting: 112000).save()
		new Position(name: 'Data Coordinator', starting: 110860).save()
		new Position(name: 'Developer', starting: 86500).save()
		new Position(name: 'Development Lead', starting: 276000).save()
		new Position(name: 'Director', starting: 452025).save()
		new Position(name: 'Financial Controller', starting: 316750).save()
		new Position(name: 'Integration Specialist', starting: 76320).save()
		new Position(name: 'Javascript Developer', starting: 128100).save()
		new Position(name: 'Junior Javascript Developer', starting: 60520).save()
		new Position(name: 'Junior Technical Author', starting: 60200).save()
		new Position(name: 'Marketing Designer', starting: 68540).save()
		new Position(name: 'Office Manager', starting: 63392).save()
		new Position(name: 'Personnel Lead', starting: 217500).save()
		new Position(name: 'Post-Sales support', starting: 324050).save()
		new Position(name: 'Pre-Sales Support', starting: 74515).save()
		new Position(name: 'Regional Director', starting: 183000).save()
		new Position(name: 'Regional Marketing', starting: 114100).save()
		new Position(name: 'Sales Assistant', starting: 59920).save()
		new Position(name: 'Secretary', starting: 98865).save()
		new Position(name: 'Senior Javascript Developer', starting: 433060).save()
		new Position(name: 'Senior Marketing Designer', starting: 313500).save()
		new Position(name: 'Software Engineer', starting: 103600).save()
		new Position(name: 'Support Engineer', starting: 78750).save()
		new Position(name: 'Support Lead', starting: 273600).save()
		new Position(name: 'System Architect', starting: 256640).save()
		new Position(name: 'Systems Administrator', starting: 93150).save()
		new Position(name: 'Team Leader', starting: 235500).save()
		new Position(name: 'Technical Author', starting: 145000).save()

		new Employee(surname: 'Nixon', givenNames: 'Tiger', position: Position.findByName('System Architect'), office: Office.findByName('Edinburgh'), extension: 5421, hired: Date.parse('yyyy/MM/dd', '2011/04/25'), salary: 320800).save()
		new Employee(surname: 'Winters', givenNames: 'Garrett', position: Position.findByName('Accountant'), office: Office.findByName('Tokyo'), extension: 8422, hired: Date.parse('yyyy/MM/dd', '2011/07/25'), salary: 170750).save()
		new Employee(surname: 'Cox', givenNames: 'Ashton', position: Position.findByName('Junior Technical Author'), office: Office.findByName('San Francisco'), extension: 1562, hired: Date.parse('yyyy/MM/dd', '2009/01/12'), salary: 86000).save()
		new Employee(surname: 'Kelly', givenNames: 'Cedric', position: Position.findByName('Senior Javascript Developer'), office: Office.findByName('Edinburgh'), extension: 6224, hired: Date.parse('yyyy/MM/dd', '2012/03/29'), salary: 433060).save()
		new Employee(surname: 'Satou', givenNames: 'Airi', position: Position.findByName('Accountant'), office: Office.findByName('Tokyo'), extension: 5407, hired: Date.parse('yyyy/MM/dd', '2008/11/28'), salary: 162700).save()
		new Employee(surname: 'Williamson', givenNames: 'Brielle', position: Position.findByName('Integration Specialist'), office: Office.findByName('New York'), extension: 4804, hired: Date.parse('yyyy/MM/dd', '2012/12/02'), salary: 372000).save()
		new Employee(surname: 'Chandler', givenNames: 'Herrod', position: Position.findByName('Sales Assistant'), office: Office.findByName('San Francisco'), extension: 9608, hired: Date.parse('yyyy/MM/dd', '2012/08/06'), salary: 137500).save()
		new Employee(surname: 'Davidson', givenNames: 'Rhona', position: Position.findByName('Integration Specialist'), office: Office.findByName('Tokyo'), extension: 6200, hired: Date.parse('yyyy/MM/dd', '2010/10/14'), salary: 327900).save()
		new Employee(surname: 'Hurst', givenNames: 'Colleen', position: Position.findByName('Javascript Developer'), office: Office.findByName('San Francisco'), extension: 2360, hired: Date.parse('yyyy/MM/dd', '2009/09/15'), salary: 205500).save()
		new Employee(surname: 'Frost', givenNames: 'Sonya', position: Position.findByName('Software Engineer'), office: Office.findByName('Edinburgh'), extension: 1667, hired: Date.parse('yyyy/MM/dd', '2008/12/13'), salary: 103600).save()
		new Employee(surname: 'Gaines', givenNames: 'Jena', position: Position.findByName('Office Manager'), office: Office.findByName('London'), extension: 3814, hired: Date.parse('yyyy/MM/dd', '2008/12/19'), salary: 90560).save()
		new Employee(surname: 'Flynn', givenNames: 'Quinn', position: Position.findByName('Support Lead'), office: Office.findByName('Edinburgh'), extension: 9497, hired: Date.parse('yyyy/MM/dd', '2013/03/03'), salary: 342000).save()
		new Employee(surname: 'Marshall', givenNames: 'Charde', position: Position.findByName('Regional Director'), office: Office.findByName('San Francisco'), extension: 6741, hired: Date.parse('yyyy/MM/dd', '2008/10/16'), salary: 470600).save()
		new Employee(surname: 'Kennedy', givenNames: 'Haley', position: Position.findByName('Senior Marketing Designer'), office: Office.findByName('London'), extension: 3597, hired: Date.parse('yyyy/MM/dd', '2012/12/18'), salary: 313500).save()
		new Employee(surname: 'Fitzpatrick', givenNames: 'Tatyana', position: Position.findByName('Regional Director'), office: Office.findByName('London'), extension: 1965, hired: Date.parse('yyyy/MM/dd', '2010/03/17'), salary: 385750).save()
		new Employee(surname: 'Silva', givenNames: 'Michael', position: Position.findByName('Marketing Designer'), office: Office.findByName('London'), extension: 1581, hired: Date.parse('yyyy/MM/dd', '2012/11/27'), salary: 198500).save()
		new Employee(surname: 'Byrd', givenNames: 'Paul', position: Position.findByName('Chief Financial Officer (CFO)'), office: Office.findByName('New York'), extension: 3059, hired: Date.parse('yyyy/MM/dd', '2010/06/09'), salary: 725000).save()
		new Employee(surname: 'Little', givenNames: 'Gloria', position: Position.findByName('Systems Administrator'), office: Office.findByName('New York'), extension: 1721, hired: Date.parse('yyyy/MM/dd', '2009/04/10'), salary: 237500).save()
		new Employee(surname: 'Greer', givenNames: 'Bradley', position: Position.findByName('Software Engineer'), office: Office.findByName('London'), extension: 2558, hired: Date.parse('yyyy/MM/dd', '2012/10/13'), salary: 132000).save()
		new Employee(surname: 'Rios', givenNames: 'Dai', position: Position.findByName('Personnel Lead'), office: Office.findByName('Edinburgh'), extension: 2290, hired: Date.parse('yyyy/MM/dd', '2012/09/26'), salary: 217500).save()
		new Employee(surname: 'Caldwell', givenNames: 'Jenette', position: Position.findByName('Development Lead'), office: Office.findByName('New York'), extension: 1937, hired: Date.parse('yyyy/MM/dd', '2011/09/03'), salary: 345000).save()
		new Employee(surname: 'Berry', givenNames: 'Yuri', position: Position.findByName('Chief Marketing Officer (CMO)'), office: Office.findByName('New York'), extension: 6154, hired: Date.parse('yyyy/MM/dd', '2009/06/25'), salary: 675000).save()
		new Employee(surname: 'Vance', givenNames: 'Caesar', position: Position.findByName('Pre-Sales Support'), office: Office.findByName('New York'), extension: 8330, hired: Date.parse('yyyy/MM/dd', '2011/12/12'), salary: 106450).save()
		new Employee(surname: 'Wilder', givenNames: 'Doris', position: Position.findByName('Sales Assistant'), office: Office.findByName('Sidney'), extension: 3023, hired: Date.parse('yyyy/MM/dd', '2010/09/20'), salary: 85600).save()
		new Employee(surname: 'Ramos', givenNames: 'Angelica', position: Position.findByName('Chief Executive Officer (CEO)'), office: Office.findByName('London'), extension: 5797, hired: Date.parse('yyyy/MM/dd', '2009/10/09'), salary: 1200000).save()
		new Employee(surname: 'Joyce', givenNames: 'Gavin', position: Position.findByName('Developer'), office: Office.findByName('Edinburgh'), extension: 8822, hired: Date.parse('yyyy/MM/dd', '2010/12/22'), salary: 92575).save()
		new Employee(surname: 'Chang', givenNames: 'Jennifer', position: Position.findByName('Regional Director'), office: Office.findByName('Singapore'), extension: 9239, hired: Date.parse('yyyy/MM/dd', '2010/11/14'), salary: 357650).save()
		new Employee(surname: 'Wagner', givenNames: 'Brenden', position: Position.findByName('Software Engineer'), office: Office.findByName('San Francisco'), extension: 1314, hired: Date.parse('yyyy/MM/dd', '2011/06/07'), salary: 206850).save()
		new Employee(surname: 'Green', givenNames: 'Fiona', position: Position.findByName('Chief Operating Officer (COO)'), office: Office.findByName('San Francisco'), extension: 2947, hired: Date.parse('yyyy/MM/dd', '2010/03/11'), salary: 850000).save()
		new Employee(surname: 'Itou', givenNames: 'Shou', position: Position.findByName('Regional Marketing'), office: Office.findByName('Tokyo'), extension: 8899, hired: Date.parse('yyyy/MM/dd', '2011/08/14'), salary: 163000).save()
		new Employee(surname: 'House', givenNames: 'Michelle', position: Position.findByName('Integration Specialist'), office: Office.findByName('Sidney'), extension: 2769, hired: Date.parse('yyyy/MM/dd', '2011/06/02'), salary: 95400).save()
		new Employee(surname: 'Burks', givenNames: 'Suki', position: Position.findByName('Developer'), office: Office.findByName('London'), extension: 6832, hired: Date.parse('yyyy/MM/dd', '2009/10/22'), salary: 114500).save()
		new Employee(surname: 'Bartlett', givenNames: 'Prescott', position: Position.findByName('Technical Author'), office: Office.findByName('London'), extension: 3606, hired: Date.parse('yyyy/MM/dd', '2011/05/07'), salary: 145000).save()
		new Employee(surname: 'Cortez', givenNames: 'Gavin', position: Position.findByName('Team Leader'), office: Office.findByName('San Francisco'), extension: 2860, hired: Date.parse('yyyy/MM/dd', '2008/10/26'), salary: 235500).save()
		new Employee(surname: 'Mccray', givenNames: 'Martena', position: Position.findByName('Post-Sales support'), office: Office.findByName('Edinburgh'), extension: 8240, hired: Date.parse('yyyy/MM/dd', '2011/03/09'), salary: 324050).save()
		new Employee(surname: 'Butler', givenNames: 'Unity', position: Position.findByName('Marketing Designer'), office: Office.findByName('San Francisco'), extension: 5384, hired: Date.parse('yyyy/MM/dd', '2009/12/09'), salary: 85675).save()
		new Employee(surname: 'Hatfield', givenNames: 'Howard', position: Position.findByName('Office Manager'), office: Office.findByName('San Francisco'), extension: 7031, hired: Date.parse('yyyy/MM/dd', '2008/12/16'), salary: 164500).save()
		new Employee(surname: 'Fuentes', givenNames: 'Hope', position: Position.findByName('Secretary'), office: Office.findByName('San Francisco'), extension: 6318, hired: Date.parse('yyyy/MM/dd', '2010/02/12'), salary: 109850).save()
		new Employee(surname: 'Harrell', givenNames: 'Vivian', position: Position.findByName('Financial Controller'), office: Office.findByName('San Francisco'), extension: 9422, hired: Date.parse('yyyy/MM/dd', '2009/02/14'), salary: 452500).save()
		new Employee(surname: 'Mooney', givenNames: 'Timothy', position: Position.findByName('Office Manager'), office: Office.findByName('London'), extension: 7580, hired: Date.parse('yyyy/MM/dd', '2008/12/11'), salary: 136200).save()
		new Employee(surname: 'Bradshaw', givenNames: 'Jackson', position: Position.findByName('Director'), office: Office.findByName('New York'), extension: 1042, hired: Date.parse('yyyy/MM/dd', '2008/09/26'), salary: 645750).save()
		new Employee(surname: 'Liang', givenNames: 'Olivia', position: Position.findByName('Support Engineer'), office: Office.findByName('Singapore'), extension: 2120, hired: Date.parse('yyyy/MM/dd', '2011/02/03'), salary: 234500).save()
		new Employee(surname: 'Nash', givenNames: 'Bruno', position: Position.findByName('Software Engineer'), office: Office.findByName('London'), extension: 6222, hired: Date.parse('yyyy/MM/dd', '2011/05/03'), salary: 163500).save()
		new Employee(surname: 'Yamamoto', givenNames: 'Sakura', position: Position.findByName('Support Engineer'), office: Office.findByName('Tokyo'), extension: 9383, hired: Date.parse('yyyy/MM/dd', '2009/08/19'), salary: 139575).save()
		new Employee(surname: 'Walton', givenNames: 'Thor', position: Position.findByName('Developer'), office: Office.findByName('New York'), extension: 8327, hired: Date.parse('yyyy/MM/dd', '2013/08/11'), salary: 98540).save()
		new Employee(surname: 'Camacho', givenNames: 'Finn', position: Position.findByName('Support Engineer'), office: Office.findByName('San Francisco'), extension: 2927, hired: Date.parse('yyyy/MM/dd', '2009/07/07'), salary: 87500).save()
		new Employee(surname: 'Baldwin', givenNames: 'Serge', position: Position.findByName('Data Coordinator'), office: Office.findByName('Singapore'), extension: 8352, hired: Date.parse('yyyy/MM/dd', '2012/04/09'), salary: 138575).save()
		new Employee(surname: 'Frank', givenNames: 'Zenaida', position: Position.findByName('Software Engineer'), office: Office.findByName('New York'), extension: 7439, hired: Date.parse('yyyy/MM/dd', '2010/01/04'), salary: 125250).save()
		new Employee(surname: 'Serrano', givenNames: 'Zorita', position: Position.findByName('Software Engineer'), office: Office.findByName('San Francisco'), extension: 4389, hired: Date.parse('yyyy/MM/dd', '2012/06/01'), salary: 115000).save()
		new Employee(surname: 'Acosta', givenNames: 'Jennifer', position: Position.findByName('Junior Javascript Developer'), office: Office.findByName('Edinburgh'), extension: 3431, hired: Date.parse('yyyy/MM/dd', '2013/02/01'), salary: 75650).save()
		new Employee(surname: 'Stevens', givenNames: 'Cara', position: Position.findByName('Sales Assistant'), office: Office.findByName('New York'), extension: 3990, hired: Date.parse('yyyy/MM/dd', '2011/12/06'), salary: 145600).save()
		new Employee(surname: 'Butler', givenNames: 'Hermione', position: Position.findByName('Regional Director'), office: Office.findByName('London'), extension: 1016, hired: Date.parse('yyyy/MM/dd', '2011/03/21'), salary: 356250).save()
		new Employee(surname: 'Greer', givenNames: 'Lael', position: Position.findByName('Systems Administrator'), office: Office.findByName('London'), extension: 6733, hired: Date.parse('yyyy/MM/dd', '2009/02/27'), salary: 103500).save()
		new Employee(surname: 'Alexander', givenNames: 'Jonas', position: Position.findByName('Developer'), office: Office.findByName('San Francisco'), extension: 8196, hired: Date.parse('yyyy/MM/dd', '2010/07/14'), salary: 86500).save()
		new Employee(surname: 'Decker', givenNames: 'Shad', position: Position.findByName('Regional Director'), office: Office.findByName('Edinburgh'), extension: 6373, hired: Date.parse('yyyy/MM/dd', '2008/11/13'), salary: 183000).save()
		new Employee(surname: 'Bruce', givenNames: 'Michael', position: Position.findByName('Javascript Developer'), office: Office.findByName('Singapore'), extension: 5384, hired: Date.parse('yyyy/MM/dd', '2011/06/27'), salary: 183000).save()
		new Employee(surname: 'Snider', givenNames: 'Donna', position: Position.findByName('Customer Support'), office: Office.findByName('New York'), extension: 4226, hired: Date.parse('yyyy/MM/dd', '2011/01/25'), salary: 112000).save()

    }
    def destroy = {
    }
}
