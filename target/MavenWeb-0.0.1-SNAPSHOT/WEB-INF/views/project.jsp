<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
<title>Project</title>

<!-- Custom Scripts: Sanket Bharaswadkar -->
	<script type="text/javascript" src="<c:url value="/scripts/jquery191-ajax-technology.js" /> "></script>
	
 <style>
 .AddEmpStyle{width: 400px;}
 #employees:hover { background: #33CCFF } 
 </style> 
</head>
<body>
	<div id="page" class="container" style="overflow: auto;">
	<h3 style="text-align:left;">${projectPageTitle}</h3>
				<div>
				<!-- 		<input type="radio" name="typeOfProject" id="blankProject"
						value="blank" /> <label for="blankProject">Blank Project</label>
					<br /> <input type="radio" name="typeOfProject" id="copyProject"
						value="copy" /> <label for="copyProject">Copy Project</label> <br />
					<input type="submit" value="Create" /> -->
				</div>
	<form:form method="get" action="#" commandName="defaultProject">
			
				<table>
					<tr>
						<td><label id="projectId">Project: </label> </td> 
						<td> ${defaultProject.projectNumber}</td>
						<td><label id="customerName">Customer:</label></td>
						<%-- <td> <form:input path="city" /> Walmart</td> --%>
						<td> <p style="font-style: italic;">${customerName}</p> </td>
						<!-- <td ><label id="customerType" >Customer Type</label></td> -->
						<%-- <td><form:input path="customerType" /></td>	 --%>
					</tr>
					
					<tr>
					<%-- <td><label>Status: </label></td>
					<td><form:select path="projectStatus">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="1" label="Unassigned" />
							
							 <form:option value="1" label="Unassigned" />
							<form:option value="2" label="Pricing" />
							<form:option value="3" label="Discovery" />
							<form:option value="4" label="Delivered" />
							<form:option value="5" label="Unknown" />
							<form:options items="${customerTypesMap}" />
						</form:select></td> --%>

				</tr>
					<tr>
					<td><label>Customer Type </label></td>
					<td><form:select path="*">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="1" label="End User" />
							<form:option value="2" label="Integrator" />
							<form:option value="3" label="Both" />
							<%-- <form:options items="${customerTypesMap}" /> --%>
						</form:select></td>

				</tr>
					<tr>
						<td><label id="pocEmployeeId">POC Employee Id</label></td>
						<%-- <td><form:input path="pocEmployeeId" /></td> --%>

						<td><label id="employeeId">Add Employees (drop down)</label></td>
						<%-- <td><form:input path="employeeId" /></td> --%>
					</tr>
					<tr>
						<td><label id="locationId">Add Locations (drop down)</label></td>
						<%-- <td><form:input path="locationId" /></td> --%>

						<td><label id="designId">Add designs (drop down)</label></td>
						<%-- <td><form:input path="designId" /></td> --%>
					</tr>
					<tr>
						<td><label id="requirementId">Select requirement</label></td>
						<%-- <td><form:input path="requirementId" /></td> --%>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Next" /></td>
					</tr>
				</table>
			</form:form>

		<div><label>Employees currently associated: <br/></label>
			<c:if test="${employeeList == null}"> <span style="color: red"> No employees </span></c:if>
			<c:if test="${employeeList != null}">
			<c:forEach var="employee" items="${employeeList}" varStatus="status">${status.count}. ${employee.lastName} <br/></c:forEach>
			</c:if>
		</div>

		<label for="employees">Add Employee/s</label>
		<form action="addEmployee" method="post" id="addEmployeeForm">
		<div>
		<input id="employees" class="AddEmpStyle"  title="Start typing the first or last name..."/>
		<button id="employees" type="submit">Add</button>
		</div>
			</form>
			
		<label>Update Status</label>
		<form:form commandName="projectStatus" id="projectStatusUpdateForm"
			method="post" action="updateStatus">
			<form:select path="projectStatusId">
				<form:option value="1" label="Unassigned" />
				<form:option value="2" label="Pricing" />
				<form:option value="3" label="Discovery" />
				<form:option value="4" label="Delivered" />
				<form:option value="5" label="Unknown" />
			</form:select>
			<button type="submit">Save</button>
		</form:form>
		<div id="info" class="info" />
<div id="error" class="error" />
	</div>
	<%-- Shifted to Sitemesh :D 
	
	<div id="footer" class="container">
		<p>
			PLM System ${year} ${version} 
		</p>
	</div> --%>
</body>
</html>
