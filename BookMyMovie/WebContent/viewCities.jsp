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
		style="background-image: url(resources/images/linedpaper.png); width: 1320px; height: 768px">
		<br /> <br /> <br /> <br /> <br />
		<div class="span12 offset2">
			<h1 align="center">You can view, modify & delete
				existing cities</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>City
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>City
							Name</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Modify
							row</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Delete
							row</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="cities">
						<tr">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cityID" /></td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cityName" /></td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a class="btn btn-primary btn-block"
								 href="modifyCity.action?cityID=<s:property value="cityID" />">Modify</a></td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a class="btn btn-danger btn-block"
								 href="deleteCity.action?cityID=<s:property value="cityID"/>">Delete</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>