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
			<h1 align="center">You can view, modify & delete existing movies</h1>
			<hr size="4" color="#009987">
		</div>
		<br>

		<div class="row-fluid">
			<br />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							ID</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Name</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Storyline</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Poster</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Rating</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Trailer</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Category</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
							Cast</th>

						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Modify
							row</th>
						<th
							style='text-align: center; vertical-align: middle; font-size: 18px'>Delete
							row</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="movies">
						<tr>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="movieID" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="movieName" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="storyLine" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><img
								src="./posters/<s:property value="imageURL" />"
								class="img-polaroid" height="300px" width="250px" alt="image text" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:iterator
									var="rate" begin="1" end="%{rating}">
									<img src='./resources/images/displaystar.jpg' />
								</s:iterator></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><iframe
									title="YouTube Video Player" width="250" height="200"
									src="<s:property value="trailer" />" seamless> </iframe></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="category" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:property
									value="cast" /></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-primary btn-block"
								href="modifyMovie.action?movieID=<s:property value="movieID" />">Modify</a></td>

							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><a
								class="btn btn-danger btn-block"
								href="deleteMovie.action?movieID=<s:property value="movieID"/>">Delete</a></td>
						</tr>

					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

</body>

</html>