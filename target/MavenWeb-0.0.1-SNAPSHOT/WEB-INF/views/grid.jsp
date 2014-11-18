<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
 <!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
	
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/sunny/jquery-ui.css" />
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	
	
<title>Grid</title>

<!-- JS for Flexigrid -->
<script type="text/javascript">
$(document).ready(function(){
     
	 $('#flexme2').dataTable(); 
});
</script>


</head>
<body>
			
			<h3>Events</h3>
			<div>
				<p>Events</p>
				<p>Events 2</p>
								
				<table id="flexme2" class="flexme">
                <thead>
                        <tr>
                                <th>Col 1</th>
                                <th>Col 2</th>
                                <th>Col 3 is a long header name</th>
                                <th>Col 4</th>
                        </tr>
                </thead>
                <tbody>
                        <tr>
                                <td>This is data 1 with overflowing content</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                        <tr>
                                <td>This is data 1</td>
                                <td>This is data 2</td>
                                <td>This is data 3</td>
                                <td>This is data 4</td>
                        </tr>
                </tbody>
        </table>
			</div>
	
		<p>PLM System ${year} ${version}</p>
</body>

</html>
