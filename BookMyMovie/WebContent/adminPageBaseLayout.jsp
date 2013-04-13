<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet"
	href="resources/jQuery/css/smoothness/jquery-ui-1.9.2.custom.css" />
<script src="resources/jQuery/js/jquery-1.8.3.js"></script>
<script src="resources/jQuery/js/jquery-ui-1.9.2.custom.js"></script>
<script src="resources/styles/js/bootstrap.js"></script>
<link href="resources/styles/css/bootstrapcosmo.css" rel="stylesheet">
<link href="resources/styles/css/font-awesome.css" rel="stylesheet">
</head>

<body>

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />

</body>
</html>