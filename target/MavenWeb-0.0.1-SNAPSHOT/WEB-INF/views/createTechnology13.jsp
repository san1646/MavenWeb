<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" isELIgnored="false"%>
<html>
<%-- <head>

<title>Technology</title>
<!-- <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" /> -->
<!-- <script src="http://code.jquery.com/jquery-1.9.1.js"></script> -->
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> --> 
<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script> -->
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
	<div id="page" class="container" style="overflow: auto;">
		<h3 style="text-align: left;">Add Technology</h3>
		<form method="get" action="<c:url value="/employee" />">

			<table>
				<tr>
					<td><label id="addTechnologyId">Add Technology(drop
							down)</label></td>
					<td><input id="addTechnologyId" /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td><p>Create a new technology:</p></td>
				</tr>
				<tr>
					<td><label id="technologyId">Technology Id:</label></td>
					<td><input id="technologyId" value="1000" readonly="readonly" /></td>


					<td><label id="description">Description:</label></td>
					<td><input id="description" /></td>
				</tr>
				<tr>
					<td><label id="addEmployeeId">Add Employee(drop down)</label></td>
					<td><input id="addEmployeeId" /></td>
					<td><label id="addLocationId">Add Location(drop down)</label></td>
					<td><input id="addLocationId" /></td>
				</tr>

				<tr>
					<td><label id="addDepartmentId">Add Department(drop
							down)</label></td>
					<td><input id="addDepartmentId" /></td>
				</tr>
				<tr>
					<td><label id="addEmployeeId">Add Employee(drop down)</label></td>
					<td><input id="addEmployeeId" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Next" /></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- This div contains Knighted WBS -->

	<!--  ************************************************************************ -->
<div class="accordion" style="font-size: medium;"> <!-- style="width: 800px; align: center; -->
		<h3>Service</h3>
		<div class="accordion">
				<p>User Project</p>
				<div>
				<p>User Project 2</p>
				<p> <a href="<c:url value="/savedata" />">SaveData</a> </p>
				</div>
				
				
		</div>
		<h3>Tasks</h3>
		<div>		
			<p>App Serv Inst Config</p>			
			<p>SW Install Config</p>
		</div>
		<h3>Sub-tasks</h3>
		<div>		
			<p>QA</p>			
			<p>UAT</p>
		</div>
	</div>	
</body> --%>

<head>
<title>Technology</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="src/main/webapp/jquery.cookies.2.2.0.js"></script>
	
	<!-- Custom Scripts: Sanket Bharaswadkar -->
	<%-- <script type="text/javascript" src="${context}/scripts/jquery191-ajax-technology.js.js"></script> --%>
	<script type="text/javascript" src="<c:url value="/scripts/jquery191-ajax-technology.js" /> "></script>
	
<script type="text/javascript">
	$(function() {
		var cookieName = 'stickyAccordion';

		$("#accordion,#accordion2,#accordion3,#accordion4,#accordion5")
				.accordion({
					collapsible : true,
					icons : {
						/* ui-icons are for plus and minus signs for the collapsibles;
						Currently, only the plus sign is working; 
						Could not diagnose for the minus sign*/
						'header' : 'ui-icon-plus',
						'headerSelected' : 'ui-icon-minus'
					},
					/* hieghtStyle resizes the accordion box accroding to content;
					 	    Variable content size will not have scroll bars*/
					heightStyle : "content",
					active : false
				/* active: ( $.cookies.get( cookieName ) || false),
				change: function( e, ui )
				{
					$.cookies.set( cookieName, $( this ).find( 'h3' ).index ( ui.newHeader[0] ) );
				} */
				});

	});
</script>

<script type="text/javascript">
	/*changeFunc loads the KnightedDiv only when the knighted technology is selected from the dropdown;
	 * It is hidden earlier and not display: none; It is because display has issues with 
	 the box size after it is made visible through the JavaScript;
	 */
	function changeFunc() {
		//document.getElementById('knightedDiv').style.display= 'none';
		var selectBox = document.getElementById("technology12");
		var selecValue = selectBox.options[selectBox.selectedIndex].value;
		if (selectBox.selectedIndex === 1) {
			document.getElementById('knightedDiv').style.visibility = 'visible';
		} else {
			document.getElementById('knightedDiv').style.visibility = 'hidden';
		}
	}
</script>


<script type="text/javascript">
var str = $("#knightedWBS").serialize();
	 function crunchifyAjax() {
		$.ajax({
			type:"post",
			data: str,
			url : '/technology',
			async: false,
			dataType: "json",
			success: function(){
			       alert("success");
			    }
		});
	} 
</script>


<script type="text/javascript">
	var intervalId = 0;
	intervalId = setInterval(crunchifyAjax, 5000);
</script>

</head>
<body>
	<%-- <div>
		<form:form id="knightedWBS" modelAttribute="knightedWBSTechnologyForm"  method="post" >
		<h2>Knighted WBS</h2>
			<table>
             <tbody>
			<c:forEach items="${knightedWBSTechnologyForm.knightedWBSTechnologies}" var="knightedWBSTechnology" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td> <label>Task Number:</label> <input name="knightedWBSTechnologies[${status.index}].taskNumber" value="${knightedWBSTechnologies.taskNumber}"/></td>
            <td> <label>Hours:</label> <input name="knightedWBSTechnologies[${status.index}].hours" value="${knightedWBSTechnologies.hours}"/></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    
			<input type="submit" id="formSubmit" value="submit wbs"/>
		</form:form>
	</div> --%>
	<div>
		<p>Select a technology:</p>
		<select id="technology12" onchange="changeFunc();">
			<option value="selectOption" selected="selected">---Select---</option>
			<option value="Knighted">Knighted</option>
			<option value="Mechanical">Mechanical</option>
		</select>
	</div>

	<%-- <div id="knightedDiv" style="visibility: hidden;">
		<form:form id="knightedWBS" method="post"  modelAttribute="knightedWBSTechnologyForm">
			<h2>Knighted WBS</h2>
			<div class="demo">
				<div id="accordion">
					<h3>
						<a href="#">60 Service-WMS
						</a><span style="float: right;">Total: 
									
									<c:forEach
										items="${knightedWBSTechnologyForm.knightedWBSTechnologies}"
										var="knightedWBSTechnology" varStatus="status">
											<label>Hours:</label> <input
												name="knightedWBSTechnologies[${status.index}].hours"
												value="${knightedWBSTechnologies.hours}" />
									</c:forEach>
									
						</span>
					</h3>
					<div>
						<div>
							<p>
								<span style="font: caption;">Task <span
									style="float: right;">Hours</span></span>
							</p>
							<p>
								60.1 Executive Management <span style="float: right;"> </span>
							</p>
							<p>
								60.2 Project Management <span style="float: right;"> </span>
							</p>
							<p>
								60.8 DB Server Inst Config <span style="float: right;"> </span>
							</p>
						</div>

					</div>
				</div>
			</div>
			<div>
				<input type="submit" />
			</div>
		</form:form>
	</div> --%>


	<!-- complete -->
	<div id="knightedDiv" style="visibility: hidden;">
		<h2>Knighted WBS</h2>
		<div class="demo">

			<form:form id="knightedWBS" method="post"  modelAttribute="knightedWBSTechnologyForm">
			<div id="accordion">
				
				<h3>
					<a href="#"> 60 Service-WMS</a><span style="float: right;">Total
									<c:forEach
										items="${knightedWBSTechnologyForm.knightedWBSTechnologies}"
										var="knightedWBSTechnology" varStatus="status">
											<label>Hours1:</label> <input
												name="knightedWBSTechnologies[${status.index}].hours"
												value="${knightedWBSTechnologies.hours}" />
									</c:forEach>
					</span>
				</h3>
				<div>
					<div>
						<p >
							<span style="font: caption;">Task <span
								style="float: right;">Hours</span></span>
						</p>
						<p>
							60.1 Executive Management <span style="float: right;"> 
							<c:forEach
										items="${knightedWBSTechnologyForm.knightedWBSTechnologies}"
										var="knightedWBSTechnology" varStatus="status">
											<label>Hours1:</label> <input
												name="knightedWBSTechnologies[${status.index}].hours"
												value="${knightedWBSTechnologies.hours}" />
									</c:forEach>
									</span>
						</p>
						<p>
							60.2 Project Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.3 Proc Flow and Bus An <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.4 Appl Gap Analysis <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.5 Server Install Confi <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>

						<div id="accordion3">
							<h3>
								<a href="#">60.6 Interface Integration</a><span
									style="float: right;">Total:<input type="text"
									size="5px" />
								</span>
							</h3>
							<div>
								<div>
									<p>
										<span style="font: caption;">Task <span
											style="float: right;">Hours</span></span> <br /> 60.6.1 Interface
										Map Def <span style="float: right;"> <input type="text"
											size="5px" /></span>
									</p>
									<div id="accordion4">
										<h3>
											<a href="#">60.6.2 Dev (New Interface)</a><span
												style="float: right;">Total:<input type="text"
												size="5px" />
											</span>
										</h3>
										<div>
											<div>
												<p>
													<span style="font: caption;">Task <span
														style="float: right;">Hours</span></span>
												</p>
												<p>
													60.6.2.1 Analysis <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.2 Development <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.3 Unit test<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<!-- Sub-level -->
												<div id="accordion5">
													<h3>
														<a href="#">60.6.2.4 QA</a><span style="float: right;">Total:<input
															type="text" size="5px" />
														</span>
													</h3>
													<div>
														<div>
															<p>
																<span style="font: caption;">Task <span
																	style="float: right;">Hours</span></span>
															</p>
															<p>
																60.6.2.4.1 QA Test <span style="float: right;"> <input
																	type="text" size="5px" /></span>
															</p>
															<p>
																60.6.2.4.2 Documentation <span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
															<p>
																60.6.2.4.3 Re-testing<span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
														</div>
													</div>
												</div>
												<p>
													60.6.2.5 Deployment<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.6 Re-work<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End: accordion3 60.6-->
						<div id="accordion3">
							<h3>
								<a href="#">60.7 Devel (Application)</a><span 
									style="float: right;">Total:<input type="text"
									size="5px" />
								</span>
							</h3>
							<div>
								<div>
									<p>
										<span style="font: caption;">Task <span
											style="float: right;">Hours</span></span> <br /> 60.7.1 Analysis<span
											style="float: right;"> <input type="text" size="5px" /></span>
									</p>
									<p>
										60.7.2 Specification<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>

									<p>
										60.7.3 Design<span style="float: right;" > <input
											type="text" size="5px" /></span>
									</p>
									<p>
										60.7.4 Develop<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>
									<p>
										60.7.5 Unit test<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>
									<p>
										60.7.6 Document<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>

									<div id="accordion4">
										<h3>
											<a href="#">60.7.7 QA</a><span style="float: right;">Total:<input
												type="text" size="5px" />
											</span>
										</h3>
										<div>
											<div>
												<p>
													<span style="font: caption;">Task <span
														style="float: right;">Hours</span></span>
												</p>
												<p>
													60.7.7.1 QA Testing<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.7.7.2 Documentation <span style="float: right;">
														<input type="text" size="5px" />
													</span>
												</p>
												<p>
													60.7.7.3 Re-testing<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
											</div>
										</div>
									</div>

									<p>
										60.7.8 Deployment<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>
									<p>
										60.7.9 Re-work<span style="float: right;"> <input
											type="text" size="5px" /></span>
									</p>

								</div>
							</div>
						</div>
						<p>
							60.8 DB Server Inst Config <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.9 Int Server Inst Config <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.CONV Converted <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
					</div>

				</div>
				<h3>
					<a href="#">61 Service-WCS</a><span style="float: right;">Total:<input
						type="text" size="5px" />
					</span>
				</h3>
				<div>
					<div>
						<p>
							<span style="font: caption;">Task <span
								style="float: right;">Hours</span></span>
						</p>
						<p>
							60.1 Executive Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.2 Project Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.3 Proc Flow and Bus An <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.4 Appl Gap Analysis <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.5 Server Install Confi <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>

						<div id="accordion3">
							<h3>
								<a href="#">60.6 Interface Integration</a><span
									style="float: right;">Total:<input type="text"
									size="5px" />
								</span>
							</h3>
							<div>
								<div>
									<p>
										<span style="font: caption;">Task <span
											style="float: right;">Hours</span></span> </span> <br /> 60.6.1 Interface
										Map Def <span style="float: right;"> <input type="text"
											size="5px" /></span>
									</p>
									<div id="accordion4">
										<h3>
											<a href="#">60.6.2 Dev (New Interface)</a><span
												style="float: right;">Total:<input type="text"
												size="5px" />
											</span>
										</h3>
										<div>
											<div>
												<p>
													<span style="font: caption;">Task <span
														style="float: right;">Hours</span></span>
												</p>
												<p>
													60.6.2.1 Analysis <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.2 Development <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.3 Unit test<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>

												<!-- Sub-level -->
												<div id="accordion5">
													<h3>
														<a href="#">60.6.2.4 QA</a><span style="float: right;">Total:<input
															type="text" size="5px" />
														</span>
													</h3>

													<div>
														<div>
															<p>
																<span style="font: caption;">Task <span
																	style="float: right;">Hours</span></span>
															</p>
															<p>
																60.6.2.4.1 QA Test <span style="float: right;"> <input
																	type="text" size="5px" /></span>
															</p>
															<p>
																60.6.2.4.2 Documentation <span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
															<p>
																60.6.2.4.3 Re-testing<span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
														</div>
													</div>


												</div>

												<p>
													60.6.2.5 Deployment<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.6 Re-work<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
											</div>
										</div>

									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
				<h3>
					<a href="#">62 Services-LMS</a><span style="float: right;">Total:<input
						type="text" size="5px" />
					</span>
				</h3>
				<div>
					<div>
						<p>
							<span style="font: caption;">Task <span
								style="float: right;">Hours</span></span>
						</p>
						<p>
							60.1 Executive Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.2 Project Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.3 Proc Flow and Bus An <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.4 Appl Gap Analysis <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.5 Server Install Confi <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>

						<div id="accordion3">
							<h3>
								<a href="#">60.6 Interface Integration</a><span
									style="float: right;">Total:<input type="text"
									size="5px" />
								</span>
							</h3>
							<div>
								<div>
									<p>
										<span style="font: caption;">Task <span
											style="float: right;">Hours</span></span> </span> <br /> 60.6.1 Interface
										Map Def <span style="float: right;"> <input type="text"
											size="5px" /></span>
									</p>
									<div id="accordion4">
										<h3>
											<a href="#">60.6.2 Dev (New Interface)</a><span
												style="float: right;">Total:<input type="text"
												size="5px" />
											</span>
										</h3>
										<div>
											<div>
												<p>
													<span style="font: caption;">Task <span
														style="float: right;">Hours</span></span>
												</p>
												<p>
													60.6.2.1 Analysis <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.2 Development <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.3 Unit test<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>

												<!-- Sub-level -->
												<div id="accordion5">
													<h3>
														<a href="#">60.6.2.4 QA</a><span style="float: right;">Total:<input
															type="text" size="5px" />
														</span>
													</h3>

													<div>
														<div>
															<p>
																<span style="font: caption;">Task <span
																	style="float: right;">Hours</span></span>
															</p>
															<p>
																60.6.2.4.1 QA Test <span style="float: right;"> <input
																	type="text" size="5px" /></span>
															</p>
															<p>
																60.6.2.4.2 Documentation <span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
															<p>
																60.6.2.4.3 Re-testing<span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
														</div>
													</div>


												</div>

												<p>
													60.6.2.5 Deployment<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.6 Re-work<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
											</div>
										</div>

									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
				<h3>
					<a href="#">63 Services-BI</a><span style="float: right;">Total:<input
						type="text" size="5px" />
					</span>
				</h3>
				<div>
					<div>
						<p>
							<span style="font: caption;">Task <span
								style="float: right;">Hours</span></span>
						</p>
						<p>
							60.1 Executive Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.2 Project Management <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.3 Proc Flow and Bus An <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.4 Appl Gap Analysis <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>
						<p>
							60.5 Server Install Confi <span style="float: right;"> <input
								type="text" size="5px" /></span>
						</p>

						<div id="accordion3">
							<h3>
								<a href="#">60.6 Interface Integration</a><span
									style="float: right;">Total:<input type="text"
									size="5px" />
								</span>
							</h3>
							<div>
								<div>
									<p>
										<span style="font: caption;">Task <span
											style="float: right;">Hours</span></span> </span> <br /> 60.6.1 Interface
										Map Def <span style="float: right;"> <input type="text"
											size="5px" /></span>
									</p>
									<div id="accordion4">
										<h3>
											<a href="#">60.6.2 Dev (New Interface)</a><span
												style="float: right;">Total:<input type="text"
												size="5px" />
											</span>
										</h3>
										<div>
											<div>
												<p>
													<span style="font: caption;">Task <span
														style="float: right;">Hours</span></span>
												</p>
												<p>
													60.6.2.1 Analysis <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.2 Development <span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.3 Unit test<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>

												<!-- Sub-level -->
												<div id="accordion5">
													<h3>
														<a href="#">60.6.2.4 QA</a><span style="float: right;">Total:<input
															type="text" size="5px" />
														</span>
													</h3>

													<div>
														<div>
															<p>
																<span style="font: caption;">Task <span
																	style="float: right;">Hours</span></span>
															</p>
															<p>
																60.6.2.4.1 QA Test <span style="float: right;"> <input
																	type="text" size="5px" /></span>
															</p>
															<p>
																60.6.2.4.2 Documentation <span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
															<p>
																60.6.2.4.3 Re-testing<span style="float: right;">
																	<input type="text" size="5px" />
																</span>
															</p>
														</div>
													</div>


												</div>

												<p>
													60.6.2.5 Deployment<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
												<p>
													60.6.2.6 Re-work<span style="float: right;"> <input
														type="text" size="5px" /></span>
												</p>
											</div>
										</div>

									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
			<input type="submit" value="Save"/>
			</form:form>
		</div>
	</div>




</body>
</html>
