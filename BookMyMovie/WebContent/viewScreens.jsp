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
				screens</h1>
			<hr size="4" color="#009987">
		</div>
		<br>

		<div class="row-fluid">
			<br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Cinema
							Theatre Name</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
							Number</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>General
							Class Capacity</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Silver
							Class Capacity</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Gold
							Class Capacity</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Total
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

					<s:iterator value="screens">
						<tr>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cinemaName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="screenNum" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="genCapacity" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="silverCapacity" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="goldCapacity" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="totalCapacity" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-primary btn-block"
								href="modifyScreen.action?screenID=<s:property value="screenID"/>">Modify</a></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-danger btn-block"
								href="deleteScreen.action?screenID=<s:property value="screenID"/>">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>