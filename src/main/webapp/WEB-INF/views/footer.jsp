<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head><link rel="stylesheet" href="<spring:theme code='stylesheet'/>"
	type="text/css" /></head>
<body>
	<div id="footer" class="container">
		<p>PLM System ${year} ${version}</p>
	</div>
</body>

</html>
