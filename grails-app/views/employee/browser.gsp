<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/scroller/1.4.4/css/scroller.dataTables.min.css">
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/scroller/1.4.4/js/dataTables.scroller.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
 		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js "></script>
	</head>
	<body>
        <a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="employee-browser" class="content" role="main">
			<h1>Employee Browser</h1>
			<table id="employee_dt" class="display compact" style="width:99%;">
				<thead><tr><th>Surname</th><th>Given name(s)</th><th>Position</th><th>Office</th><th>Extension</th><th>Hired</th><th>Salary</tr></thead>
				<tfoot><tr><th>Surname</th><th>Given name(s)</th><th>Position</th><th>Office</th><th>Extension</th><th>Hired</th><th>Salary</tr></tfoot>
			</table>
		</div>
		<g:javascript>
			$('#employee_dt tfoot th').each( function() {
				var title = $(this).text();
				if (title == 'Extension' || title == 'Hired')
					$(this).html('<input type="text" size="5" placeholder="' + title + '?" />');
				else
					$(this).html('<input type="text" size="15" placeholder="' + title + '?" />');
			});
			var table = $('#employee_dt').DataTable( {
				"scrollY": 500,
				"deferRender": true,
				"scroller": true,
				"dom": "Brtip",
				"buttons": [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
				"processing": true,
				"serverSide": true,
				"ajax": {
					"url": "${createLink(controller: 'employee', action: 'browserLister')}",
					"type": "POST",
				},
				"columns": [
					{ "data": "surname" },
					{ "data": "givenNames" },
					{ "data": "position" },
					{ "data": "office" },
					{ "data": "extension" },
					{ "data": "hired" },
					{ "data": "salary" }
				]
			});
			table.columns().every(function() {
				var that = this;
				$('input', this.footer()).on('keyup change', function(e) {
					if (that.search() != this.value && 8 < e.keyCode && e.keyCode < 32)
						that.search(this.value).draw();
				});
			});
		</g:javascript>
	</body>
</html>
