<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="./resources/mobiscroll/mobiscroll-2.3.custom.min.css"
	rel="stylesheet" type="text/css" />
<link href="./resources/mobiscroll/mobiscroll.ios-2.3.css"
	rel="stylesheet" type="text/css" />
<script src="./resources/mobiscroll/mobiscroll-2.3.custom.min.js"
	type="text/javascript"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});

	$(function() {
		$('#timepicker').scroller({
			preset : 'time',
			theme : 'ios',
			display : 'bubble',
			animate : 'pop',
			timeFormat : 'HH:ii:ss',
			mode : 'scroller',
			timeWheels : 'hhiissA'

		});
	});
</script>

<script>
	$(document).ready(function() {
		$("#panel").hide().fadeIn("slow");
	});
</script>
<script>
 $(function() {
        $( document ).tooltip({
            position: {
                my: "center bottom-20",
                at: "center top",
                using: function( position, feedback ) {
                    $( this ).css( position );
                    $( "<div>" )
                        .addClass( "arrow" )
                        .addClass( feedback.vertical )
                        .addClass( feedback.horizontal )
                        .appendTo( this );
                }
            }
        });
    });
    </script>
    
    <style>
    .ui-tooltip, .arrow:after {background: black; border: 1px solid white;}
    .ui-tooltip {padding: 10px 20px; color: white; border-radius: 20px; font: bold 14px "Helvetica Neue", Sans-Serif; text-transform: uppercase; box-shadow: 0 0 7px black;}
    .arrow {width: 70px; height: 16px; overflow: hidden; position: absolute; left: 50%; margin-left: -35px; bottom: -16px;}
	.arrow.top {top: -16px; bottom: auto;}
    .arrow.left {left: 20%;}
    .arrow:after {content: ""; position: absolute; left: 20px; top: -20px; width: 25px; height: 25px; box-shadow: 6px 5px 9px -9px black; -webkit-transform: rotate(45deg);
                 -moz-transform: rotate(45deg); -ms-transform: rotate(45deg); -o-transform: rotate(45deg); tranform: rotate(45deg);}
    .arrow.top:after {bottom: -20px; top: auto;}
    </style>
    
</head>

<body>
	<div class="container-fluid" id="panel"
		style="background-image: url(resources/images/linedpaper.png);">
		<br /> <br /> <br /> <br /> <br />
		<div class="span12 offset2">
			<h1 align="center">You can add new Schedules here</h1>
			<hr size="4" color="#009987">
		</div>

		<div class="span12 offset2">
			<br /> <br />
			<h2 align="center" style="font-family: Helvetica Neue">Add new
				schedule?</h2>
			<s:form action="addSchedules" method="post">
				<table class="table table-bordered table-hover">
					<tbody>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Show
								Date:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>

								<div class="input-prepend">
									<span class="add-on"><i class="icon-calendar"
										style="color: black;"></i></span> <input type="text" id="datepicker"
										name="showDate" readonly="readonly" class="input-xxlarge" placeholder="Please Click to enter Show Date"/>
								</div>
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Show
								Time:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>
								<div class="input-prepend">
									<span class="add-on"><i class="icon-time"
										style="color: black;"></i></span> <input type="text" id="timepicker"
										name="showtime" readonly="readonly" class="input-xxlarge" placeholder="Please Click to enter Show Time"/>
								</div>
							</td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Screen
								ID:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="screenID" label="SCREEN ID: " size="20" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Movie
								ID:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="movieID" label="MOVIE ID: " size="20" theme="simple"
									cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>General
								Class Price:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="genClass" label="GENERAL CLASS PRICE: " size="20"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Silver
								Class Price:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="silverClass" label="SILVER CLASS PRICE: " size="20"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

						<tr class="success">
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'>Gold
								Class Price:</td>
							<td
								style='text-align: center; vertical-align: middle; font-size: 18px'><s:textfield
									name="goldClass" label="GOLD CLASS PRICE: " size="20"
									theme="simple" cssClass="input-block-level" /></td>
						</tr>

					</tbody>
				</table>
				<br />
				<s:submit name="commandButton" value="ADD MOVIE" align="center" cssClass="btn btn-large btn-inverse" title="Add Movie?"/>
			</s:form>
		</div>
	</div>

</body>

</html>