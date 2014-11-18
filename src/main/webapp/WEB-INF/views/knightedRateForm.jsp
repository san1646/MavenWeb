<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Technology</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="src/main/webapp/jquery.cookies.2.2.0.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js">
	
	<!-- Custom Scripts: Sanket Bharaswadkar -->
	<%-- <script type="text/javascript" src="${context}/scripts/jquery191-ajax-technology.js.js"></script> --%>
	<script type="text/javascript" src="<c:url value="/scripts/jquery191-ajax-technology.js" /> "></script>
	
	
	<!--  Editable Grid JS -->
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid_renderers.js" /> "></script>	
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid_editors.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid_validators.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid_utils.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/scripts/editablejs/editablegrid_charts.js" /> "></script>
	<link rel="stylesheet" href="/scripts/editablejs/editablegrid.css" type="text/css" media="screen" />
	<!-- Editable Grid JS end -->
	
<style>
			body { font-family:'lucida grande', tahoma, verdana, arial, sans-serif; font-size:11px; }
			h1 { font-size: 15px; }
			a { color: #548dc4; text-decoration: none; }
			a:hover { text-decoration: underline; }
			table.testgrid { border-collapse: collapse; border: 1px solid #CCB; width: 800px; }
			table.testgrid td, table.testgrid th { padding: 5px; border: 1px solid #E0E0E0; }
			table.testgrid th { background: #E5E5E5; text-align: left; }
			input.invalid { background: red; color: #FDFDFD; }
</style>
<script>
			window.onload = function() {
              editableGrid = new EditableGrid("DemoGridAttach");  

				// we build and load the metadata in Javascript
				editableGrid.load({ metadata: [
					{ name: "TaskNumber", datatype: "string", editable: false },
					{ name: "TaskName", datatype: "string", editable: true },
					{ name: "Description", datatype: "string", editable: true },
					{ name: "Rate", datatype: "double", editable: true }
				]});

				// then we attach to the HTML table and render it --ohh really? :O
				editableGrid.attachToHTMLTable('knightedComplete');
				editableGrid.renderGrid();
			} 
		</script>




</head>
<body>
<form:form modelAttribute="knightedRateWrapper" action="knightedrate" method="post">
<div>
	<table id="knightedComplete" class="testgrid">
		<thead>
			<tr>
				<th>TaskNumber</th>
				<th>TaskName</th>
				<th>Description</th>
				<th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${knightedRateWrapper.knightedWbsRate}" var="knightedComplete"
				varStatus="status" >
				<tr id="R${status.count}">
					<td style="color: gray;">${knightedComplete.taskNumber}</td>
					<td> <%-- <input name="knightedRateWrapper.knightedWbsRate[${status.count}].taskName"/> --%> ${knightedComplete.taskName}</td>
					<td>${knightedComplete.description}</td>
					<td>${knightedComplete.rate}</td>
				</tr>
			</c:forEach>
			<tr></tr>
		</tbody>
	</table>
	</div>
	
	<input type="submit" value="Save"/>
</form:form>




</body>
</html>
