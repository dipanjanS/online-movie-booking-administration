<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		$("#panel").hide().fadeIn("slow");
	});
</script>
</head>

<body>

	<h2>This is page for modifying screen information</h2>

	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);">
		<br /> <br /> <br /> <br /> <br />
		<div class="span12 offset2">
			<h1 align="center">You can modify selected cinema screen here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Modify
				Cinema Screen?</h2>
			<s:form action="updateScreen" method="post">
				<table class="table table-bordered table-hover">
					<tbody>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
								ID:</td>
							<td><s:property value="screenID" /></td>
						</tr>


						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								ID:</td>
							<td><s:textfield name="cinemaID" label="CINEMA ID: "
									size="20" placeholder="cinemaID" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
								Number:</td>
							<td><s:textfield name="screenNum" label="SCREEN NUMBER: " size="20"
							placeholder="screenNum" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>


						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>General Class
								capacity:</td>
							<td><s:textfield name="genCapacity" label="GENERAL CLASS CAPACITY: "
							size="20" placeholder="genCapacity" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>
						
						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Silver Class
								capacity:</td>
							<td><s:textfield name="silverCapacity" label="SILVER CLASS CAPACITY: "
							size="20" placeholder="silverCapacity" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>
						
						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Gold Class
								capacity:</td>
							<td><s:textfield name="goldCapacity" label="GOLD CLASS CAPACITY: "
							size="20" placeholder="goldCapacity" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>
						
						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Total
								capacity:</td>
							<td><s:textfield name="totalCapacity" label="TOTAL CAPACITY: "
							size="20" placeholder="totalCapacity" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						</tbody>
						</table>
						<br/>
						<s:hidden name="screenID" value="%{screenID}"></s:hidden>
						<s:submit name="commandButton" value="MODIFY SCREEN"
							align="center" cssClass="btn btn-large btn-inverse"/>
			</s:form>
			</div>
			</div>
</body>

</html>