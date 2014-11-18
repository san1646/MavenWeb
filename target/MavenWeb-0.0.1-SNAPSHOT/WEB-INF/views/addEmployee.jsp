<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Employee</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {

		$("#accordion").accordion();

		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#autocomplete").autocomplete({
			source : availableTags
		});

		$("#button").button();
		$("#radioset").buttonset();

		$("#tabs").tabs();

		$("#dialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Ok",
				click : function() {
					$(this).dialog("close");
				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		// Link to open the dialog
		$("#dialog-link").click(function(event) {
			$("#dialog").dialog("open");
			event.preventDefault();
		});

		$("#datepicker").datepicker({
			inline : true
		});

		$("#slider").slider({
			range : true,
			values : [ 17, 67 ]
		});

		$("#progressbar").progressbar({
			value : 20
		});

		// Hover states on the static widgets
		$("#dialog-link, #icons li").hover(function() {
			$(this).addClass("ui-state-hover");
		}, function() {
			$(this).removeClass("ui-state-hover");
		});
	});
</script>
<style>
body {
	font: 62.5% "Trebuchet MS", sans-serif;
	margin: 50px;
}

.demoHeaders {
	margin-top: 2em;
}

#dialog-link {
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

#dialog-link span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

#icons {
	margin: 0;
	padding: 0;
}

#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

#icons span.ui-icon {
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}
</style>
</head>
<body>
	<div id="page" class="container" style="overflow: auto;">
		<h3 style="text-align: left;">Add Employee</h3>
		<form method="get" action="<c:url value="/reqt" />">
			<table>
				<tr>
					<td><label id="employeeId">Employee Id</label></td>
					<td><input id="employeeId" value="1000" readonly="readonly" /></td>
				</tr>
				<tr>
					<td><label id="empTitle">Title</label></td>
					<td><input id="empTitle" value="" /></td>

					<td><label id="empName"></label>Name</td>
					<td><input id="" value="" /></td>

					<td><label id="level"></label>Level</td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="empAddressLine1">Address Line 1</label></td>
					<td><input id="" value="" /></td>

					<td><label id="empAddressLine2">Address Line 2</label></td>
					<td><input id="" value="" /></td>

					<td><label id="city">City</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="state">State</label></td>
					<td><input id="" value="" /></td>

					<td><label id="zipcode">Zipcode</label></td>
					<td><input id="" value="" /></td>

					<td><label id="zipplus4">Zip plus(4)</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="province">Province</label></td>
					<td><input id="" value="" /></td>

					<td><label id="country">Country</label></td>
					<td><input id="" value="" /></td>

					<td><label id="postalcode">Postal code</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="dateOfBirth">Date Of Birth</label></td>
					<td><input id="" value="" /></td>

					<td><label id="empStartDate">Start Date</label></td>
					<td><input id="" value="" /></td>

					<td><label id="empEndDate">End Date</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="sme">SME</label></td>
					<td><input id="" value="" /></td>

					<td><label id="email">Email</label></td>
					<td><input id="" value="" /></td>

					<td><label id="workPhone">Work Phone</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><label id="mobilePhone">Mobile Phone</label></td>
					<td><input id="" value="" /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Next" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
