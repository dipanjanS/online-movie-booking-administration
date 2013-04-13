<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="./resources/mobiscroll/mobiscroll-2.3.custom.min.css"
	rel="stylesheet" type="text/css" />
<link href="./resources/mobiscroll/mobiscroll.ios-2.3.css"
	rel="stylesheet" type="text/css" />
<script src="./resources/mobiscroll/mobiscroll-2.3.custom.min.js"
	type="text/javascript"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});

	$(function() {
		$('#timepicker').scroller({
			preset : 'time',
			theme : 'ios',
			display : 'bubble',
			animate : 'pop',
			timeFormat : 'HH:ii:ss',
			mode : 'scroller',
			timeWheels : 'hhiissA'

		});
	});
</script>

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
			<h1 align="center">You can modify selected schedule here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Modify
				Schedule?</h2>
			<s:form action="updateSchedule" method="post">
				<table class="table table-bordered table-hover">

					<tbody>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Schedule
								ID:</td>
							<td><s:property value="scheduleID" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Show
								Date:</td>
							<td>
								<div class="input-prepend">
									<span class="add-on"><i class="icon-calendar"
										style="color: black;"></i></span> <input type="text" id="datepicker"
										name="showDate" readonly="readonly" class="input-xxlarge"
										value="${showDate}" />
								</div>
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Show
								Time:</td>
							<td>
								<div class="input-prepend">
									<span class="add-on"><i class="icon-time"
										style="color: black;"></i></span> <input type="text" id="timepicker"
										name="showtime" readonly="readonly" class="input-xxlarge"
										value="${showtime}" />
								</div>
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
								ID:</td>
							<td><s:textfield name="screenID" label="SCREEN ID: "
									size="20" theme="simple" placeholder="screenID"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								ID:</td>
							<td><s:textfield name="movieID" label="MOVIE ID: " size="20"
									theme="simple" placeholder="movieID"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>General
								Class Seat Price:</td>
							<td><s:textfield name="genClass"
									label="GENERAL CLASS PRICE: " size="20" theme="simple"
									placeholder="genClass" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Silver
								Class Seat Price:</td>
							<td><s:textfield name="silverClass"
									label="SILVER CLASS PRICE: " size="20" theme="simple"
									placeholder="silverClass" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Gold
								Class Seat Price:</td>
							<td><s:textfield name="goldClass" label="GOLD CLASS PRICE: "
									size="20" theme="simple" placeholder="goldClass"
									cssClass="input-block-level" /></td>
						</tr>
					</tbody>
				</table>
				<br />

				<s:hidden name="scheduleID" value="%{scheduleID}"></s:hidden>
				<s:submit name="commandButton" value="MODIFY SCHEDULE"
					align="center" cssClass="btn btn-large btn-inverse" />
			</s:form>
		</div>
	</div>

</body>

</html>