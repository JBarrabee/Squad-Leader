<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!--Links to local bootstrap and main .css and .js files THESE NEED TO BE INCLUDED IN EVERY PAGE  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<script src="bootstrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/tablepage.css">


<title>Upcoming Meetups</title>

<style>
#meetupDisplay {
	width: 100%;
	height: 400px;
}
table, tr {
	border: 1px solid black;
}
</style>
</head>
<body>
<h1>SQUAD LEADER</h1>
	<nav class="navbar navbar-dark bg-inverse ">
	<ul class="nav navbar-nav ">

		<li class="nav-item"><a class="nav-link" href="addSuccess.html">HOME</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="meetUpMap.html">Tech
				Meetups in Metro Detroit</a></li>
		<li class="nav-item"><a class="nav-link" href="viewLinks.html">Resources</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="StudentMap.html">Student
				Map</a></li>
		<li class="nav-item"><a class="nav-link" href=" Logout.html">Log
				Out</a></li>
	</ul>
	</nav>

	<h2>Upcoming Meetups in Metro Detroit</h2>

	<form method="Post" action="meetUpMap.html">
		<br> <span>Keyword Search</span> <input type="text"
			name="keyWord"> <input type="submit" value="Submit" /> <br>
		<span>Which Meetup Group?</span> <select name="include">
			<option value="0">All</option>
			<option value="1">IT in the D</option>
			<option value="2">Refresh Detroit</option>
			<option value="3">BDPA Detroit Technology</option>
			<option value="4">Detroit Java User Group</option>
			<option value="5">Girl DevelopIT Detroit</option>
			<option value="6">Detroit User Experience</option>
			<option value="7">Great Lakes Area NET User Group</option>
			<option value="8">TechShop Detroit</option>
			<option value="9">Tech248</option>
		</select> <span>How many events do you want to see?</span> <select name="limit">
			<option value="2">3</option>
			<option value="4">5</option>
			<option value="29">30</option>
		</select>
	</form>

 <script type="text/javascript">

alert("hello world");
document.getElementById("message").innerHTML ="No events match your query";
</script>
<div id= "message"></div>
	<table id="MeetupDisplay" align="left">
		<tr>
			<td>Group Name</td>
			<td>Event Name</td>
			<td>Event Time</td>
			<td>Event City</td>
		</tr>

		<c:forEach var="meetup" begin="0" end="${limit}" items="${EventList}">
			<tr>
				<td><a href="${meetup.EVENT_LINK}" target="_blank">${meetup.GROUP_NAME}</a></td>
				<td><a href="${meetup.EVENT_LINK}" target="_blank">${meetup.EVENT_NAME}</a></td>
				<td><a href="${meetup.EVENT_LINK}" target="_blank">${meetup.EVENT_DATE}</a></td>
				<td><a href="${meetup.EVENT_LINK}" target="_blank">${meetup.EVENT_CITY}</a></td>

			</tr>
		</c:forEach>
	</table>
	

</body>
</html>