<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>

<title>Project</title>

<!-- <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>	 -->


<!-- Custom Scripts: Sanket Bharaswadkar -->
	<%-- <script type="text/javascript" src="${context}/scripts/jquery191-ajax-technology.js.js"></script> --%>
	<link rel="stylesheet" href="<c:url value="/scripts/table-css/table-css.css" /> " />

</head>
<body>
	<div id="page" class="CSSTableGenerator" style="overflow: auto;">
		<table id="cost"  width="100%">
			<tbody>
			<tr>
					<td>No.</td>
					<td>Task Number</td>
					<td>Cost</td>
				</tr>
				
				<c:forEach items="${mapCost}" var="mapCost" varStatus="status">
					<tr>
						<td>${status.count}. </td>
						<td>${mapCost.key}</td>
						<td>${mapCost.value}</td>
					</tr>
				</c:forEach>
				<tr>
					<td> </td>
					<td style="font-size: large; color: gray;">Total</td>
					<td style="font-size: large; color: gray;">$ ${total}</td>
			</tr>
			</tbody>
		</table>
	</div>
</body>
</html>