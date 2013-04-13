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
			<h1 align="center">You can modify selected movie here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Modify
				Movie?</h2>
			<s:form action="updateMovie" method="post">
				<table class="table table-bordered table-hover">

					<tbody>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								ID:</td>
							<td><s:property value="movieID" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Name:</td>
							<td><s:textfield name="movieName" label="MOVIE NAME: "
									size="60" placeholder="movieName" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Storyline:</td>
							<td><s:textarea name="storyLine" label="STORYLINE: "
									placeholder="storyLine" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Image
								URL:</td>
							<td><s:textfield name="imageURL" label="IMAGE URL: "
									size="60" placeholder="imageURL" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>


						<s:set name="rate" value="%{rating}" />
						<s:if test="%{#rate==1}">
							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>

									<input name="rating" type="radio" class="star" value="1"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="2" /> <input name="rating" type="radio"
									class="star" value="3" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /> <input name="rating" type="radio"
									class="star" value="6" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" />
								</td>
							</tr>

						</s:if>
						<s:elseif test="%{#rate==2}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="3" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /> <input name="rating" type="radio"
									class="star" value="6" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==3}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="4" /> <input name="rating" type="radio"
									class="star" value="5" /> <input name="rating" type="radio"
									class="star" value="6" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==4}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="5" /> <input name="rating" type="radio"
									class="star" value="6" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==5}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="6" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==6}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5" /> <input
									name="rating" type="radio" class="star" value="6"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="7" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==7}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5" /> <input
									name="rating" type="radio" class="star" value="6" /> <input
									name="rating" type="radio" class="star" value="7"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="8" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==8}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5" /> <input
									name="rating" type="radio" class="star" value="6" /> <input
									name="rating" type="radio" class="star" value="7" /> <input
									name="rating" type="radio" class="star" value="8"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="9" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:elseif test="%{#rate==9}">


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5" /> <input
									name="rating" type="radio" class="star" value="6" /> <input
									name="rating" type="radio" class="star" value="7" /> <input
									name="rating" type="radio" class="star" value="8" /> <input
									name="rating" type="radio" class="star" value="9"
									checked="checked" /> <input name="rating" type="radio"
									class="star" value="10" /></td>
							</tr>

						</s:elseif>
						<s:else>


							<tr class="success">
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
									Rating:</td>
								<td
									style='text-align: center; vertical-align: middle; font-size: 18px'><input
									name="rating" type="radio" class="star" value="1" /> <input
									name="rating" type="radio" class="star" value="2" /> <input
									name="rating" type="radio" class="star" value="3" /> <input
									name="rating" type="radio" class="star" value="4" /> <input
									name="rating" type="radio" class="star" value="5" /><input
									name="rating" type="radio" class="star" value="6" /> <input
									name="rating" type="radio" class="star" value="7" /> <input
									name="rating" type="radio" class="star" value="8" /> <input
									name="rating" type="radio" class="star" value="9" /> <input
									name="rating" type="radio" class="star" value="10"
									checked="checked" /></td>
							</tr>

						</s:else>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Trailer URL:</td>
							<td><s:textfield name="trailer" label="MOVIE TRAILER: "
									size="20" placeholder="trailer" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Category:</td>
							<td><s:textfield name="category" label="MOVIE CATEGORY: "
									size="60" placeholder="category" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								Category:</td>
							<td><s:textarea name="cast" label="MOVIE CAST: "
									placeholder="cast" theme="simple" cssClass="input-block-level" /></td>
						</tr>
					</tbody>
				</table>
				<br />

				<s:hidden name="movieID" value="%{movieID}"></s:hidden>
				<s:submit name="commandButton" value="MODIFY MOVIE" align="center"
					cssClass="btn btn-large btn-inverse" />
			</s:form>
		</div>
	</div>
</body>

</html>