<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Project</title>
<link rel="stylesheet"
	href="${jquerystyle}" />
	<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

</head>
<body>
	<div id="header" style="text-align:right;">
		<ul>
			<li style="list-style: none;"><a href="<c:url value="/home" />">Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
	<h1 class="titleClass" style="text-align: center;">${app_name}</h1>

	
	<div id="tabs" class="ui-tabs" >
	<p>
		<form:form id="knightedWBS"  method="post"  commandName="projectResult" action="findprojectresult">
		<div>
			<label>Project Id</label><form:input path="projectId" />
			<label>Customer Id</label><form:input path="customerId" />
		</div>
		<input type="submit" value="Edit"/>
		</form:form>
	</p>
		
	
	</div>
	<div id="footer" class="container">
		<p>
			PLM System ${year} ${version} 
		</p>
	</div>
</body>
</html>
