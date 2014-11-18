<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<link rel="icon" type="image/x-icon" href="/favicon.ico" />
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>"	type="text/css" /> --%>
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
	body{
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
<body style="text-align: center;">
	<%-- <div id="header" style="text-align:right;">
		<ul>
			<li style="list-style: none;"><a href="<c:url value="/" />">Home</a>
				| <a href="javascript:closeWindow();">Logout</a></li>
		</ul>
	</div>
	<h1 class="titleClass" style="text-align: center;">${app_name}</h1> --%>
	
		
		<div id="page" class="container" style="margin-left: auto; margin-right: auto; width: 50%; text-align: center;">
			<form id="f" action="<c:url value='j_spring_security_check' />"
				method="post">

				<table >
					<tr><td> <p style="color: red;">${message} </p> </td></tr>
					<tr><td>
						<div id="box1" style="text-align: center">
							<h2 class="title" style="text-align: center;">Login page</h2>
							<div style="clear: both;">&nbsp;</div>
						</div>
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">Username:</td>
						<td style="text-align: center;"><input type='text' name='j_username' value='' /></td>
					</tr>
					<tr>
						<td style="text-align: center;">Password:</td>
						<td style="text-align: center;"><input type='password' name='j_password' /></td>
					</tr>
					<tr>
						<td colspan='2' style="text-align: center;"><input name="submit" type="submit"
							value="Submit" /></td>
					</tr>
					<tr>
						<td colspan='2' style="text-align: center;"><input name="reset" type="reset" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="page" class="container" style="margin-left: auto; margin-right: auto; width: 50%; text-align: center; border: 0;">
			<c:if test="${not empty error}">
				<div class="errorblock" style="color: red;">
					Your login attempt was not successful, please try again.<br /> 
					<%-- Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  --%>
				</div>
			</c:if>
		</div>
	

	<%-- <div id="footer" class="container">
		<p>PLM System ${year} ${version}</p>
	</div> --%>
</body>

</html>
