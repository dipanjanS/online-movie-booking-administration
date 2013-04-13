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
		style="background-image: url(resources/images/linedpaper.png); width: 1320px;">
		<br /> <br /> <br /> <br /> <br />
		<div class="row-fluid">
			<h1 align="center">You can view, modify & delete existing cinema
				theatres</h1>
			<hr size="4" color="#009987">
		</div>
		<br>

		<div class="row-fluid">
			<br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Name</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Address</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>City
							ID</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Rating</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Number
							of Screens</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Theatre
							Capacity</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Modify
							row</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Delete
							row</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="cinemaTheatres">
						<tr>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="address" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cityID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:iterator
									var="rate" begin="1" end="%{rating}">
									<img src='./resources/images/displaystar.jpg' />
								</s:iterator></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="numOfScreens" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="capacity" /></td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-primary btn-block"
								href="modifyCinema.action?cinemaID=<s:property value="cinemaID" />">Modify</a></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-danger btn-block"
								href="deleteCinema.action?cinemaID=<s:property value="cinemaID"/>">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>