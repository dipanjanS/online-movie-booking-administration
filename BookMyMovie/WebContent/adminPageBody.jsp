<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>
	$(function() {
		$("#accordion").accordion({
			collapsible : true,
			heightStyle: "content"
		});
	});
	
	$(document).ready(function(){
	    $("#panel").hide().fadeIn("slow");
	  });
</script>

</head>

<body>
	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);">
		<br /> <br /> <br />
		<header class="jumbotron subhead" id="overview">
			<div class="row-fluid">
				<div class="span3">
					<img src="resources/images/booklogo.jpg" class="img-polaroid" />
				</div>
				<div class="span9">
					<h1 align="center">Welcome back to the Admin Panel</h1>
					<hr size="4" color="#009987">
					<br />
					<div class="alert alert-success">This is the control panel
						for controlling and administering all the entities used in the
						Book My Show website. In this website you can perform different
						operations on the database right from the control panel here
						itself. Besides this you can also check how many users are
						currently registered to the website, tickets booked, transactions
						and various other information needed to control the website. The
						navigation bar above has different menu options for managing the
						database tables. For more information see the tabs below to get a
						more detailed view of the admin control panel and its operations.</div>
				</div>
			</div>
			<br /> <br />
			<div class="subnav">
				<ul class="nav nav-pills">
					<li><a href="<s:url action="viewSeatmap"/>">View Complete Seatmap</a></li>
					<li><a href="allTransactions">View Transactions</a></li>
				</ul>
			</div>
			<br />
			<div id="accordion">
				<h3>VIEW DATABASE OPERATIONS</h3>
				<div>
					Control the entire database
					<hr size="4" color="#999999">
					<ol>
						<li>Manage Cities
							<ul>
								<li>Add new cities</li>
								<li>Modify existing cities</li>
								<li>Delete existing cities</li>
							</ul>
						</li>
						<li>Manage Cinema Theatres
							<ul>
								<li>Add new cinema theatres</li>
								<li>Modify existing cinema theatres</li>
								<li>Delete existing cinema theatres</li>
							</ul>
						</li>
						<li>Manage Cinema
							<ul>
								<li>Add new screens</li>
								<li>Modify existing screens</li>
								<li>Delete existing screens</li>
							</ul>
						</li>
						<li>Manage Movies
							<ul>
								<li>Add new Movies</li>
								<li>Modify existing Movies</li>
								<li>Delete existing Movies</li>
							</ul>
						</li>
						<li>Manage Schedules
							<ul>
								<li>Add new schedules</li>
								<li>Modify existing schedules</li>
								<li>Delete existing schedules</li>
							</ul>
						</li>
					</ol>
				</div>
				<h3>VIEW OTHER OPERATIONS</h3>
				<div>
					Other Operations include
					<hr size="4" color="#999999">
					<ol>
						<li>Manage User Profiles
							<ul>
								<li>View All Users</li>
								<li>Modify User Information</li>
								<li>Ban a user</li>
							</ul>
						</li>
						<br />
						<li>Manage all Transactions
							<ul>
								<li>Modify existing transactions</li>
								<li>Cancel transactions</li>
							</ul>
						</li>
						<br />
						<li>Manage all Bookings
							<ul>
								<li>Modify existing bookings</li>
								<li>Cancel a booking</li>
							</ul>
						</li>
					</ol>
				</div>
				<h3>VIEW SEAT BOOKING PLAN</h3>
				<div>
					<img src="resources/images/seatbookingplanV2.png" />
				</div>
				<h3>VIEW THE DATABASE SCHEMA</h3>
				<div>
					<img src="resources/images/dbschema.png" />
				</div>
			</div>
		</header>
		<br />
		<br />
	</div>

</body>
</html>