<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

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

	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);">
		<br /> <br /> <br /> <br /> <br />
		<div class="row-fluid">
			<h1 align="center">You can view, modify & delete existing
				schedules</h1>
			<hr size="4" color="#009987">
		</div>
		<br>

		<div class="row-fluid">
			<br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Schedule
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Show
							Date</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Show
							time</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							ID</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							ID</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Name</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							Number</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Name</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>General
							Class Seat Price</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Silver
							Class Seat Price</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Gold
							Class Seat Price</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Modify
							row</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Delete
							row</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="scheduleList">
						<tr>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="scheduleID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="showDate" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="showtime" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="movieID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenNum" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="movieName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="genClass" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="silverClass" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="goldClass" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-primary btn-block"
								href="modifySchedule.action?scheduleID=<s:property value="scheduleID" />">Modify</a></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-danger btn-block"
								href="deleteSchedule.action?scheduleID=<s:property value="scheduleID"/>">Delete</a></td>

						</tr>
					</s:iterator>
				</tbody>
			</table>
			<br/><br/><br/><br/><br/>
		</div>
	</div>
</body>

</html>