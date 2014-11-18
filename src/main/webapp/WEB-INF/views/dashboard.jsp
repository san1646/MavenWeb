<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
 
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
	
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>	
<title>Home</title>
	
<style>
  #accordion-resizer {
    padding: 10px;
    width: 1000px; /*Changed from 1k to 1.5k to 1k */
    height: 600px;
  }
  /*This setting prevents panes from overflowing, adds a nice scrollbar, and makes home screen pretty!*/
  #accordion .ui-accordion-content {
    max-height: 500px;
    overflow-y: auto;
}
  </style>
  
  <script>
  $(function() {
    $( "#accordion" ).accordion({
      heightStyle: "content",
      autoHeight: false
    });
  });
  $(function() {
    $( "#accordion-resizer" ).resizable({
      minHeight: 140,
      minWidth: 200,
      resize: function() {
        $( "#accordion" ).accordion( "refresh" );
      }
    });
  });
  </script>

<!-- JS for DataTable -->
<script type="text/javascript">
$(document).ready( function () {
	$('#flexme').dataTable( {
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"sDom": '<"H"Tfr>t<"F"ip>',
		"oTableTools": {
			"aButtons": [
				"copy", "csv", "xls", "pdf",
				{
					"sExtends":    "collection",
					"sButtonText": "Save",
					"aButtons":    [ "csv", "xls", "pdf" ]
				}
			]
		},
		"aoColumns": [
		              { sWidth: '10%' },
		              { sWidth: '10%' },
		              { sWidth: '10%' },
		              { sWidth: '10%' },
		              { sWidth: '60%' }]
	} );
} );
</script>

</head>

<body>
	<div id="accordion-resizer" class="ui-accordion-content">
		<div id="accordionxx" style="font-size: medium;">
			<h3>Dashboard</h3>
			<div>
				<p>
				<form:form method="post" modelAttribute="projects" >
				<table id="flexme" width="100%">
				<thead>
                        <tr>
                                <th>   </th>
                                <th>Project Id</th>
                                <th>Customer Id</th>
                                <th> Status</th>
                                <th></th>
                                
                        </tr>
                </thead>
                <tbody>
					<c:forEach items="${projects}" var="project" varStatus="status">
						<tr>
							<td align="center">${status.count}.</td>
							<td> ${project.projectId} <%-- <input name="projects[${status.index}].projectId"
								value="${project.projectId}" /> --%> </td>
								<td> ${project.customerId} </td>
								<td>  
								</td>
							<td> Edit</a> <br /></td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
				</form:form>
				</p>
			</div>
		</div>
	</div>

       
	
</body>

</html>
