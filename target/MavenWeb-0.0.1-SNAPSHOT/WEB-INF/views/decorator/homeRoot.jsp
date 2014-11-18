<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html>
<head>
<title>PLM - <sitemesh:write property='title' /></title>
<sitemesh:write property='head' />

<!-- <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" /> -->
<!-- http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css
	http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css -->

<!-- <script src="http://code.jquery.com/jquery-1.9.1.js"></script> -->


<!-- <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->
<script>
	$(function() {

		$("#accordion").accordion();

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

<style>
/* **************** GRIDS ***************** */
.line:after{content: ".";display: block;height: 0;clear: both;visibility: hidden;}
.lastUnit:after{content: " . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ";visibility:hidden; clear:both;height:0 !important;display:block;line-height:0;}
.line{*zoom:1;}
.unit{float:left;}
.size1of1{float:none;}
/*This is the size of Content frame (the main frame in home screen). 
Changed: 70 to 75*/
.size1of2{width:75%;} 
.size1of3{width:33.33333%;}
.size2of3{width:66.66666%;}
.size1of4{width:15%;}
.size3of4{width:75%;}
.size1of5{width:20%;}
.size2of5{width:40%;}
.size3of5{width:60%;}
.size4of5{width:80%;}
.lastUnit {display: table-cell; *display:block;*zoom:1;float:none;_position:relative; _left:-3px; _margin-right: -3px;width:auto;}
</style>
</head>

<body>


<div class="line">
	<div class="unit size1of4">
		<p>Create a Project</p>
		<p>Find Project</p>
		<p>Add Customer</p>
	</div>
	
	<div class="unit size1of2 lastUnit">
		<div style="color: black">
				<div id="header" style="text-align: right;">
					<ul>
						<li style="list-style: none; font-size: medium;"><a
							href='home'>Home</a> | <a style="font-size: medium;" 
							href="<c:url value="j_spring_security_logout" />" > Logout</a></li>
							<li style="list-style: none; font-size: medium;">${username}</li>
					</ul>
				</div>
				<h1 style="text-align: center; font-size: xx-large;">${app_name}</h1>

				<sitemesh:write property='body' />

			</div>
	</div>
	
	<div class="unit size1of4">
		<p>Tasks</p>
	</div>
</div>



	<div
		style="text-align: center; margin: 0 auto; font-size: medium;">
		<p>PLM System ${year} ${version}</p>
		<p>
			<a href='home'><img src="<c:url value="/resources/toolbar_home.png"/>" alt="Home"/></a> | <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
		</p>
	</div>
</body>

</html>
