<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>"	type="text/css" /> --%>
</head>
<body>

	<%-- Shifted to Sitemesh :D
	<div id="header" style="text-align: right;">
		<ul>
			<li style="list-style: none;"><a href="<c:url value="/home" />">Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
	<h1 class="titleClass" style="text-align: center;">${app_name}</h1>
	<div id="menu-wrapper">
		<div id="menu">
			<ul class="tabs">
				<li><a href="<c:url value="/project" />">Project</a></li>
				<li><a href="<c:url value="/technology" />">Technology</a></li>
				<li><a href="<c:url value="/employee" />">Employee</a></li>
				<li><a href="<c:url value="/reqt" />">Requirement</a></li>
				<li><a href="<c:url value="/schedule" />">Schedule</a></li>
				<li class="current_page_item"><a
					href="<c:url value="/services" />">Services</a></li>
					<li><a href="<c:url value="/department" />">Department</a></li>
				<li><a href="<c:url value="#" />">Cost</a></li>
			</ul>
		</div>
	</div> --%>

	<div id="page" class="container" style="overflow: auto;" >
			<h2 class="title">Services</h2>
			<div style="clear: both;">&nbsp;</div>
			<%-- <form:form action="/services" method="GET"  commandName="services" modelAttribute="services">
				<table>
					<tbody>
						<tr>
							<td>
								<ul>
									<form:checkboxes element="li" path="services"
										items="${intelligratedService}" />
								</ul>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form> --%>

			<form action="<c:url value="/department"/>">
				<div>
					<ul class="style1">
					<li style="none"> <input type="checkbox" name="projectManagement" value="projectManagement" >Project Management</input>   
					<input type="checkbox" name="mechanical" value="mechanical" >Mechanical</input>
					<input type="checkbox" name="electrical" value="electrical" >Electrical</input>
					<input type="checkbox" name="controls" value="controls" >Controls</input></li>
					<li>
					<input type="checkbox" name="installation" value="installation" >Installation</input>
					<input type="checkbox" name="customerService" value="customerService" >Customer Service</input>
					<input type="checkbox" name="software" value="software" >Software</input></li>
					
					<li ><input type="submit" value="Next"/></li>  </ul>
						 
				</div>
			</form>
	</div>
	<%-- Shifted to Sitemesh :D
	<jsp:include page="footer.jsp" /> --%>
</body>

</html>
