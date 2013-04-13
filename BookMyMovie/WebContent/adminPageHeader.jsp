<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

	<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-text pull-left"><img src="resources/images/logosmall.gif"/></div>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="<s:url action="homePage"/>"><i class="icon-home"></i> Home</a></li>
              <li><a href="<s:url action="aboutPage"/>">About</a></li>
         
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cities<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="<s:url action="addCityPanel"/>">Add New City</a></li>
                  <li><a href="<s:url action="viewCities"/>">View & Modify Cities</a></li>
                </ul>
              </li>
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cinema Theatres<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="<s:url action="addCinemaPanel"/>">Add New Cinema Theatre</a></li>
                  <li><a href="<s:url action="viewCinemas"/>">View & Modify Cinema Theatres</a></li>
                </ul>
              </li>
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Screens<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="<s:url action="addScreenPanel"/>">Add New Cinema Screen</a></li>
                  <li><a href="<s:url action="viewScreens"/>">View & Modify Cinema Screens</a></li>
                </ul>
              </li>
              
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Movies<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="<s:url action="addMoviePanel"/>">Add New Movie</a></li>
                  <li><a href="<s:url action="viewMovies"/>">View & Modify Movies</a></li>
                </ul>
              </li>
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Schedules<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="<s:url action="addSchedulePanel"/>">Add New Schedule</a></li>
                  <li><a href="<s:url action="viewSchedules"/>">View & Modify Schedules</a></li>
                </ul>
              </li>
              
            </ul>
  
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	


</body>
</html>