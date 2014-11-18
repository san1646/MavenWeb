<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Error</title>
	
 

</head>

<body>
<div id="header" style="text-align: right;">
					<ul>
						<li style="list-style: none; font-size: medium;"><a
							href='home'>Home</a> | <a style="font-size: medium;"
							href="javascript:closeWindow();">Logout</a></li>
							<li style="list-style: none; font-size: medium;">${username}</li>
					</ul>
				</div>
				
	<div>
		<p>Oops! Something went wrong. Our monkey's are working hard to get it right. 
Please be patient.</p>
	</div>
       
	<div style="font-size: medium;">
		<ul class="entry">
			<li style="list-style: none;"><a
				href="<c:url value="/createProject" />" style="font-family: Tahoma;">Create
					a Project</a> | <a href="<c:url value="/findproject" />"
				style="font-family: Tahoma;">Find Project</a></li>
		</ul>
		<ul class="entry">
			<li style="list-style: none;"><a style="font-family: Tahoma;"
				href="<c:url value="/customer" />">Add Customer</a> | <a
				href="<c:url value="/knightedrate" />" style="font-family: Tahoma;">Knighted
					Rate</a></li>
		</ul>
	</div>
	<%-- <div id="footer" class="container">
		<p>PLM System ${year} ${version}</p>
	</div> --%>
</body>

</html>
