<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='./resources/ratingscript/jquery.js' type="text/javascript"></script>
<script src='./resources/ratingscript/jquery.MetaData.js'
	type="text/javascript"></script>
<script src='./resources/ratingscript/jquery.rating.js'
	type="text/javascript"></script>
<link href='./resources/ratingscript/jquery.rating.css' type="text/css"
	rel="stylesheet" />

<script>
	$(document).ready(function() {
		$("#panel").hide().fadeIn("slow");
	});
</script>
</head>

<body>
	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);">
		<br /> <br /> <br /> <br /> <br />
		<div class="span12 offset2">
			<h1 align="center">You can add new Cinema Theatres here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Add new
				cinema theatre?</h2>
			<s:form action="addCinemas" method="post">
				<table class="table table-bordered table-hover">
					<tbody>
						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								Name:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="cinemaName" label="CINEMA NAME: " size="60"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								Address:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textarea
									name="address" label="CINEMA ADDRESS: " theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>City
								ID:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="cityID" label="CITY ID: " size="20" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>


						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								Theatre Rating:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>
								<input name="rating" type="radio" class="star" value="1" /> <input
								name="rating" type="radio" class="star" value="2" /> <input
								name="rating" type="radio" class="star" value="3" /> <input
								name="rating" type="radio" class="star" value="4" /> <input
								name="rating" type="radio" class="star" value="5" />
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Number
								of Screens:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="numOfScreens" label="NUM OF SCREENS: " size="20"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Seating
								Capacity:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="capacity" label="SEATING CAPACITY: " size="20"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>
					</tbody>
				</table>
				<br />
				<s:submit name="commandButton" value="ADD CINEMA THEATRE"
					align="center" cssClass="btn btn-large btn-inverse" />
			</s:form>
		</div>
	</div>
</body>
</html>