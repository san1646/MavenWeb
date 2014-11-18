<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html >
	<head>
		<title>Requirement</title>
		<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>" type="text/css"/> --%>
	</head>
	<body>
	
	<%-- Shifted to Sitemesh :D 
	<div id="header" style="text-align:right;">
		<ul>
			<li  style="list-style: none;"><a href="<c:url value="/home" />" >Home</a> |
			<a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
		<h1 class="titleClass" style="text-align: center;">${app_name}</h1>
	<div>	<br /></div> 
		<div id="menu-wrapper">
		<div id="menu">
			<ul class="tabs">
				<li><a href="<c:url value="/project" />">Project</a></li>
				<li><a href="<c:url value="/technology" />">Technology</a></li>
				<li><a href="<c:url value="/employee" />">Employee</a></li>
				<li class="current_page_item"><a href="<c:url value="/reqt" />">Requirement</a></li>
				<li><a href="<c:url value="/schedule" />">Schedule</a></li>
				<li><a href="<c:url value="/services" />">Services</a></li>
				<li><a href="<c:url value="/department" />">Department</a></li>
				<li><a href="<c:url value="#" />">Cost</a></li>
			</ul>
		</div>
	</div>
 --%>	
<div id="page" class="container" style="overflow: auto;">
<h3 style="text-align:left;">Add Specifications</h3>
	<form method="get" action="<c:url value="/schedule" />">

		<table>
			<tr>
				<td><label id="specificationId">Specification Id:</label></td>
				<td><input id="specificationId" value="1000" readonly="readonly" /></td>
				
				
			</tr>
			<tr><td><br/></td></tr>
			<tr><td><label><a>Control Specifications</a></label>  </td></tr>
			<tr>
				<td><label id="OperatorStationControl">Operator Station Control</label></td>
				<td><input id="OperatorStationControl" spellcheck="true" /></td>
				
				<td><label id="motorElectricitySupply">Motor Electricity Supply</label></td>
				<td><input id="motorElectricitySupply" spellcheck="true"/></td>
				
				<td><label id="controlElectricitySupply">Control Electricity Supply:</label></td>
				<td><input id="controlElectricitySupply" spellcheck="true" /></td>
			</tr>
			
			
			<tr>
				<td><label id="uLLabel">U L Label</label></td>
				<td><input id="uLLabel" spellcheck="true"  /></td>
				
				<td><label id="controlType">Control Type</label></td>
				<td><input id="controlType" spellcheck="true"  /></td>
				
				<td><label id="enclosureType">Enclosure Type</label></td>
				<td><input id="enclosureType" spellcheck="true"  /></td>
			</tr>
			
			<tr>
				<td><label id="plc">PLC</label></td>
				<td><input id="plc" spellcheck="true"  /></td>
				
				<td><label id="architecture">Architecture</label></td>
				<td><input id="architecture" spellcheck="true"  /></td>
				
				<td><label id="communicationToHost">Communication To Host</label></td>
				<td><input id="communicationToHost" spellcheck="true"  /></td>
			</tr>
			<tr>	
				<td><label id="operatorStationControl">Operator Station Control</label></td>
				<td><input id="operatorStationControl" spellcheck="true"  /></td>
				
				<td><label id="controlSpecComments">Control Specification Comments:</label></td>
				<td><input id="controlSpecComments" spellcheck="true"  /></td>
			</tr>
			
			<tr><td><br/></td></tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form>
	</div>

<%-- Shifted to Sitemesh :D 
<div id="footer" class="container">
	<p>PLM System ${year} ${version} </p>
</div> --%>
</body>

</html>
