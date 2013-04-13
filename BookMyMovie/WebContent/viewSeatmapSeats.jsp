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
			<h1 align="center">You can view seats of all screens here</h1>
			<hr size="4" color="#009987">
		</div>
		<br>

		<div class="row-fluid">
			<br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Seatmap
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							ID</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Name</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							Number</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Seat
							Class</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Seat
							Number</th>

					</tr>
				</thead>

				<tbody>

					<s:iterator value="seats">
						<tr>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="seatMapID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenID" /></td>


							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenNum" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="seatClass" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="seatNum" /></td>

						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

</body>

</html>