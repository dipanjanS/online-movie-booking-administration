<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script> 
$(document).ready(function(){
    $("#panel").hide().fadeIn("slow");
  });

</script>

</head>

<body>
	
	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png); width: 1320px; height: 768px">
		<br />
	<br /><br/>
	<br /><br/>
		<div class="span12 offset2">
			<h1 align="center">You can add new cities here</h1>
			<hr size="4" color="#009987">
		</div>
		
		<div class="span12 offset2">
		<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Add new
				city?</h2>
			<s:form action="addCities" method="post">
				<table class="table table-bordered table-hover">
					<tbody>
						<tr class="success">
							<td style='text-align:center;vertical-align:middle;font-size: 18px' >City Name:</td>
							<td style='text-align:center;vertical-align:middle;font-size: 18px'><s:textfield name="cityName" label="CITY NAME: "
									size="60" theme="simple" cssClass="input-block-level"/></td>
						</tr>
					</tbody>
				</table>
				<br />
				<s:submit name="commandButton" value="ADD CITY" align="center" cssClass="btn btn-large btn-inverse"/>
			</s:form>
		</div>

	</div>
</body>
</html>