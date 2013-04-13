<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book My Movie Administrator Login Page</title>
<link href="resources/styles/css/bootstrap.css" rel="stylesheet">
<link href="resources/styles/css/font-awesome.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Croissant+One|Rufina|Rum+Raisin|Grand+Hotel|Keania+One'
	rel='stylesheet' type='text/css'>

</head>


<body>
	<div class="container-fluid"
		style="background-image: url(resources/images/greyback.png); width: 1300px; height: 768px">
		<div class="row-fluid">
			<div class="span6 offset3">
				<br />
				<div class="well pagination-centered">
					<h1 style="font-family: 'Keania One', cursive">Welcome,
						Administrator</h1>
					<br /> <img src="resources/images/Banner.jpg" height="400"
						width="500" class="img-rounded"></img> <br /> <br /> <br /> <br />
					<div class="badge badge-info">
						<s:form action="adminLogin" method="post">
							<br />
							<div class="input-prepend">
								<span class="add-on"><i class="icon-user"
									style="color: black;"></i></span>
								<s:textfield name="username" id="myinput1" theme="simple"
									placeholder="Please enter username" />
							</div>
							<br />
							<div class="input-prepend">
								<span class="add-on"><i class="icon-key"
									style="color: black;"></i></span>
								<s:password name="password" id="myinput2" theme="simple"
									placeholder="Please enter password" />
							</div>
							<br />
							<s:submit name="commandButton" id="mysubmit" value="LOGIN"
								cssClass="btn btn-inverse" theme="simple" />
							<br />
						</s:form>
					</div>
					<br /> <br />
					<s:if test="hasActionErrors()">
						<s:iterator value="actionErrors">
							<span class="label label-important"> <br /> <s:property />
								<br />
							<br />
							</span>
						</s:iterator>
					</s:if>
				</div>
			</div>

		</div>


	</div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/styles/js/bootstrap.js"></script>
</html>