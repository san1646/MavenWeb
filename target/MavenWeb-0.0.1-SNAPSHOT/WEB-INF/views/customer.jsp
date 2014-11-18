<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet'/>" type="text/css" /> --%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<!-- http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css
	http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<style>
.toggler {
	width: 1000px;
	height: 300px;
}

#button {
	padding: .5em 1em;
	text-decoration: none;
}

#effect {
	width: 1100px;
	height: 300px;
	position: relative;
}

#effect h3 {
	margin: 0;
	padding: 0.4em;
	text-align: center;
}

#effect2 {
	width: 1100px;
	height: 300px;
	position: relative;
}

#effect2 h3 {
	margin: 0;
	padding: 0.4em;
	text-align: center;
}
</style>

<script>
	$(function() {
		// run the currently selected effect
		function runEffect() {
			// get effect type from
			var selectedEffect = 'clip';
			// most effect types need no options passed by default
			var options = {};
			// run the effect
			$("#effect").toggle(selectedEffect, options, 500);
		}
		;

		// set effect from select menu value
		$("#button").click(function() {
			runEffect();
			return false;
		});

		/* $( "#effect" ).hide(); */
	});
</script>

</head>
<body>
	<form method="post" action="#">
		<div>
			<label id="customerId">Customer Id: </label> <input id="customerId"
				value="1000" readonly="readonly" /> <label id="customerId">Customer
				Name: </label> <input id="customerId" value="Walmart" readonly="readonly" />
		</div>

		<h3>Choose an address:</h3>
		<select name="sel">
			<option value="1">Frederick, MD</option>
			<option value="2">St. Louis, MO</option>
			<option value="3">Allen, TX</option>
			<option value="4">Phoenix, AZ</option>
		</select>
		<!-- <input type="submit" value="Submit"/> -->
	</form>

	<p>Or add a new address:</p>
	<div class="toggler">
		<div id="effect2" class="ui-widget-content ui-corner-all">
			<h3 class="ui-widget-header ui-corner-all">Bill to Address</h3>
			<%-- <form method="get" action="<c:url value="/home" />"> --%>
			<form method="get" action="#">
				<table>
					<tr>
						<td><label> </label>Start date</td>
						<td><input id="state" /></td>

						<td><label> </label>End Date</td>
						<td><input id="state" /></td>

					</tr>
					<tr>
						<td><label>*Street Address</label></td>
						<td><input id="addressLine1" /></td>

						<td><label>Apt / Suite / Other</label></td>
						<td><input id="addressLine2" /></td>
					</tr>
					<tr>
						<td><label>*City</label></td>
						<td><input id="city" /></td>

						<td><label> </label>*State</td>
						<td><input id="state" size="20" style="width: 150px;" /></td>

						<td><label> </label>*Country</td>
						<td><input id="state" /></td>

					</tr>
					<tr>
						<td><label> </label>*Zip code</td>
						<td><input id="state" size="5" style="width: 50px;" /></td>
						<td><label> </label>Zip + 4</td>
						<td><input id="state" size="4" style="width: 50px;" /></td>
					</tr>
					<tr>
						<td><label> </label>Primary Number</td>
						<td><input id="countryCode" size="5" style="width: 50px;" />
							- <input id="areaCode" size="5" style="width: 50px;" /> - <input
							id="number" size="10" style="width: 110px;" /></td>
					</tr>
					<tr>
						<td><label> </label>Secondary Number</td>
						<td><input id="secCountryCode" size="5" style="width: 50px;" />
							- <input id="secAreaCode" size="5" style="width: 50px;" /> - <input
							id="secNumber" size="10" style="width: 110px;" /></td>
					</tr>

					<tr>
						<!-- <td colspan="2"><input type="submit" value="Save" /></td> -->
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div>
		<form action="#">
			<table>
				<tbody>
					<tr>
						<td><a href="#" id="button"
							class="ui-state-default ui-corner-all">Same As Bill To</a> <input
							id="chkbx" type="checkbox" checked="checked" value=""
							class="ui-state-default ui-corner-all" /> <label for="chkbx"></label></td>
					</tr>
					<!-- <tr>
				<td><input type="checkbox" name="id" value="SameAsBillTo">
						Same As Bill To </input></td>
			</tr>	 -->
				</tbody>
			</table>
		</form>
	</div>

	<div class="toggler">
		<div id="effect" class="ui-widget-content ui-corner-all">
			<h3 class="ui-widget-header ui-corner-all">Ship to Address</h3>
			<div>
				<%-- <form method="get" action="<c:url value="/home" />"> --%>
				<form method="get" action="#">
					<table>
						<tr>
							<td><label> </label>Start date</td>
							<td><input id="state" /></td>

							<td><label> </label>End Date</td>
							<td><input id="state" /></td>

						</tr>
						<tr>
							<td><label>*Street Address</label></td>
							<td><input id="addressLine1" /></td>

							<td><label>Apt / Suite / Other</label></td>
							<td><input id="addressLine2" /></td>
						</tr>
						<tr>
							<td><label>*City</label></td>
							<td><input id="city" /></td>

							<td><label> </label>*State</td>
							<td><input id="state" size="20" style="width: 150px;" /></td>

							<td><label> </label>*Country</td>
							<td><input id="state" /></td>

						</tr>
						<tr>
							<td><label> </label>*Zip code</td>
							<td><input id="state" size="5" style="width: 50px;" /></td>
							<td><label> </label>Zip + 4</td>
							<td><input id="state" size="4" style="width: 50px;" /></td>
						</tr>
						<tr>
							<td><label> </label>Primary Number</td>
							<td><input id="countryCode" size="5" style="width: 50px;" />
								- <input id="areaCode" size="5" style="width: 50px;" /> - <input
								id="number" size="10" style="width: 110px;" /></td>
						</tr>
						<tr>
							<td><label> </label>Secondary Number</td>
							<td><input id="secCountryCode" size="5" style="width: 50px;" />
								- <input id="secAreaCode" size="5" style="width: 50px;" /> - <input
								id="secNumber" size="10" style="width: 110px;" /></td>
						</tr>

						<tr>
							<!-- <td colspan="2"><input type="submit" value="Save" /></td> -->
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>