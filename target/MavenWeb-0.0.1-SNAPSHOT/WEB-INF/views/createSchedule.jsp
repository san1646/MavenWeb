<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html>
<head>
<title>Requirement</title>
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>" type="text/css"/> --%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<!-- http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css
	http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$( "#accordion" ).accordion();
		
		var availableTags = [
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
		];
		$( "#autocomplete" ).autocomplete({
			source: availableTags
		});
		
		$( "#button" ).button();
		$( "#radioset" ).buttonset();
		
		$( "#tabs" ).tabs();
		
		$( "#dialog" ).dialog({
			autoOpen: false,
			width: 400,
			buttons: [
				{
					text: "Ok",
					click: function() {
						$( this ).dialog( "close" );
					}
				},
				{
					text: "Cancel",
					click: function() {
						$( this ).dialog( "close" );
					}
				}
			]
		});

		// Link to open the dialog
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).dialog( "open" );
			event.preventDefault();
		});
		
		$( "#datepicker" ).datepicker({
			inline: true
		});
		
		$( "#slider" ).slider({
			range: true,
			values: [ 17, 67 ]
		});
		
		$( "#progressbar" ).progressbar({
			value: 20
		});

		// Hover states on the static widgets
		$( "#dialog-link, #icons li" ).hover(
			function() {
				$( this ).addClass( "ui-state-hover" );
			},
			function() {
				$( this ).removeClass( "ui-state-hover" );
			}
		);
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
				<li><a href="<c:url value="/reqt" />">Requirement</a></li>
				<li class="current_page_item"><a href="<c:url value="/home" />">Schedule</a></li>
				<li><a href="<c:url value="/services" />">Services</a></li>
				<li><a href="<c:url value="/department" />">Department</a></li>
				<li><a href="<c:url value="#" />">Cost</a></li>
			</ul>
		</div>
	</div> --%>

	<div>
		<h3 style="text-align: left;">Schedule the project</h3>
		<form method="get" action="<c:url value="/services" />">

			<table>
				<tr>
					<td><label id="datepicker">Start Date label</label></td>
					<td><input id="datepicker" type="text"/></td>
					<td>
					<div id="datepicker"></div>  
					</td>


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

	<%-- Shifted to Sitemesh :D
	<div id="footer" class="container">
	<p>PLM System ${year} ${version} </p>
</div> --%>
</body>

</html>
