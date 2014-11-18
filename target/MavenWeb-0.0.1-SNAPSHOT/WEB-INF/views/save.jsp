<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>"	type="text/css" /> --%>
</head>
<body>
	<%-- <div id="header" style="text-align:right;">
		<ul>
			<li style="list-style: none;"><a href="<c:url value="/home" />">Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>

	<h1 class="titleClass" style="text-align: center;">${app_name}</h1>
 --%>
	<div id="menu-wrapper">
		<div id="menu">
			<ul>
				<li><h3>The data has been saved successfully!</h3></li>
				<li style="list-style: none;"><a href="<c:url value="/home" />">Home</a></li>
			</ul>
		</div>
	</div>
<div id="footer" class="container">
	<p>PLM System ${year} ${version}  </p>
</div>
</body>
</html>
