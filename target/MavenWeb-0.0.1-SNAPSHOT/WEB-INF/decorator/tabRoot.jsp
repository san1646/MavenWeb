
<html>
<head>
<title><sitemesh:write property='title' />PLM</title>
<sitemesh:write property='head' />
<!--  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" href="jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.css"	rel="stylesheet" />
  <script src="jquery-ui-1.10.3.custom/js/jquery-1.9.1.js"></script>
	<script src="jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js"></script> -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
</head>

<body>
	<div style="color: black">
		<div id="header" style="text-align: right;">
			<ul>
				<li style="list-style: none;"><a href='home'>Home</a> | <a
					href="javascript:closeWindow();">Logout</a></li>
			</ul>
		</div>
		<h1 class="demoHeaders" style="text-align: center;">${app_name}</h1>
	</div>

	<!-- <div id="tabs" class="ui-menu-icon">
		<ul style="list-style: none;">
			<li><a href="project">General</a></li>
			<li><a href="employee">Team Members</a></li>
			<li><a href="schedule">Schedule</a></li>
			<li><a href="reqt">Requirement</a></li>
			<li><a href="technology">Technology</a></li>
			<li><a href="services">Services</a></li>
			<li><a href="department">Department</a></li>
			<li><a href="#">Cost</a></li>
		</ul>
	</div> -->
	
	<!-- Tabs
<h2 class="demoHeaders">Tabs</h2>
<div id="tabs">
	<ul>
		<li><a href="project">General</a></li>
		<li><a href="#employee">Team Members</a></li>
		<li><a href="#tabs-3">Third</a></li>
	</ul>
	<div id="project"><a href="project"> </a> </div>
	<div id="employee"><a href="employee">.</a></div>
	<div id="tabs-3">.</div>
</div> -->

	<sitemesh:write property='body' />

	<div id="footer" class="container">
		<p>PLM System ${year} ${version}</p>
	</div>
</body>

</html>


