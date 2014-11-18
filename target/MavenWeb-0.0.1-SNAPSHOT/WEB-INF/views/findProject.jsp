<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Project</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
</head>
<body>
	<div id="header" style="text-align:right;">
		<ul>
			<li style="list-style: none;"><a href="<c:url value="/home" />">Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
	<h1 class="titleClass" style="text-align: center;">${app_name}</h1>

	<div id="page" class="container" style="overflow: auto;">
			<h2>Search Project</h2>
			<div>&nbsp;</div>
	
	<div id="page" class="container" >
	<form:form method="post"  commandName="project">
		<div>
			<label>Project Id:</label><form:input path="projectId" />
			<label>Customer Id:</label><form:input path="customerId" />
		</div>
		<input type="submit" value="Search"/>
	</form:form>
	
	</div>
	</div>
	<div id="footer" class="container">
		<p>
			PLM System ${year} ${version} 
		</p>
	</div>
</body>
</html>
