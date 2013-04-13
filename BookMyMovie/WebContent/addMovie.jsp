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
			<h1 align="center">You can add new Movies here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Add new
				movie?</h2>
			<s:form action="addMovies" method="post">
				<table class="table table-bordered table-hover">
					<tbody>
						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Name:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="movieName" label="MOVIE NAME: " size="60" theme="simple"
									cssClass="input-block-level" rel="tooltip" data-placement="top" title="Tooltip on top"/></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Storyline:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textarea
									name="storyLine" label="STORYLINE: " theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Image
								URL:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="imageURL" label="IMAGE URL: " size="60" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Rating:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>
								<input name="rating" type="radio" class="star" value="1" /> <input
								name="rating" type="radio" class="star" value="2" /> <input
								name="rating" type="radio" class="star" value="3" /> <input
								name="rating" type="radio" class="star" value="4" /> <input
								name="rating" type="radio" class="star" value="5" /> <input
								name="rating" type="radio" class="star" value="6" /> <input
								name="rating" type="radio" class="star" value="7" /> <input
								name="rating" type="radio" class="star" value="8" /> <input
								name="rating" type="radio" class="star" value="9" /> <input
								name="rating" type="radio" class="star" value="10" />
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Trailer URL:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="trailer" label="MOVIE TRAILER: " size="60" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Category:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="category" label="MOVIE CATEGORY: " size="60"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie Cast:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textarea
									name="cast" label="MOVIE CAST: " theme="simple"
									cssClass="input-block-level" /></td>
						</tr>
					</tbody>
				</table>
				<br />
				<s:submit name="commandButton" value="ADD MOVIE" align="center"
					cssClass="btn btn-large btn-inverse" />
			</s:form>
		</div>
	</div>

</body>

</html>