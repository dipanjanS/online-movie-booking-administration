<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
	$(document).ready(function() {
		$("#panel").hide().fadeIn("slow");
	});
</script>
</head>
<body>
	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);"
		align="center">
		<br /> <br /> <br /> <br /> <br /> <br />
		<div class="row-fluid">
			<h1 align="center">View All Transactions</h1>
			<hr size="4" color="#009987">
		</div>
		<br>
		<div class="row-fluid">
			<br />
			<table class="table table-bordered">
				<thead>
					<tr>
						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Transaction#</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Booking
							ID</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Customer
							ID</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>User
							Name</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Movie</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Show
							Date</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Show
							Time</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Seats
							Count</th>

						<th
							style='text-align: left; vertical-align: middle; font-size: 18px; height: 30px'>Amount
							Paid</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="transaction">
						<tr>
							<td style='text-align: left; vertical-align: middle; font-size: 18px'><s:property value="transactionNum" /></td>
							<td style='text-align: left; vertical-align: middle; font-size: 18px'><s:property value="bookingId" /></td>
							<td style='text-align: left; vertical-align: middle; font-size: 18px'><s:property value="custID" /></td>
							<td style='text-align: left; vertical-align: middle; font-size: 18px'><s:property value="userName" /></td>
							<td
								style='text-align: left; vertical-align: middle; font-size: 18px'><s:property
									value="movieName" /></td>
							<td
								style='text-align: left; vertical-align: middle; font-size: 18px'><s:property
									value="showDate" /></td>
							<td
								style='text-align: left; vertical-align: middle; font-size: 18px'><s:property
									value="showTime" /></td>
							<td
								style='text-align: left; vertical-align: middle; font-size: 18px'><s:property
									value="totalSeats" /></td>
							<td
								style='text-align: left; vertical-align: middle; font-size: 18px'><s:property
									value="amount" /></td>

						</tr>
					</s:iterator>
				<tbody>
			</table>
		</div>

		<br /> <br /> <br />
	</div>
</body>

</html>