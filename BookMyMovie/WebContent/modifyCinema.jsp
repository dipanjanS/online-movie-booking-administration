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
			<h1 align="center">You can modify selected cinema theatre here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Modify
				Cinema Theatre?</h2>
			<s:form action="updateCinema" method="post">

				<table class="table table-bordered table-hover">
					<tbody>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								ID:</td>
							<td><s:property value="cinemaID" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								Name:</td>
							<td><s:textfield name="cinemaName" label="CINEMA NAME: "
									size="40" placeholder="cinemaName" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
								Address:</td>
							<td><s:textarea name="address" label="CINEMA ADDRESS: "
									placeholder="address" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>City
								ID:</td>
							<td><s:textfield name="cityID" label="CITY ID: " size="20"
									placeholder="cityID" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>


						<s:set name="rate" value="%{rating}" />
						<s:if test="%{#rate==1}">
							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
									Theatre Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="2" /> <input name="rating" type="radio"
									class="star" value="3" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /></td>
							</tr>

						</s:if>
						<s:elseif test="%{#rate==2}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
									Theatre Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="3" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==3}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
									Theatre Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==4}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
									Theatre Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="5" /></td>
							</tr>

						</s:elseif>
						<s:else>


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
									Theatre Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5"
									checked="checked" /></td>
							</tr>

						</s:else>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Number
								of Screens:</td>
							<td><s:textfield name="numOfScreens"
									label="NUM OF SCREENS: " size="20" placeholder="numOfScreens"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Seating
								Capacity:</td>
							<td><s:textfield name="capacity" label="SEATING CAPACITY: "
									size="20" placeholder="capacity" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>
					</tbody>
				</table>
				<br />
				<s:hidden name="cinemaID" value="%{cinemaID}"></s:hidden>

				<s:submit name="commandButton" value="MODIFY CINEMA" align="center"
					cssClass="btn btn-large btn-inverse" />
			</s:form>
		</div>
	</div>
</body>
</html>