<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	text-align: left;
}

table, tr {
	border: 1px solid black;
	allign: left
}

th {
	text-align: left;
}
</style>


</head>

<body>

	<h2>Upcoming Meetups</h2>

	<form method="Post" action="meetUpMap.html">
		<select name="limit">
			<option value="2">3</option>
			<option value="4">5</option>
			<option value="29">30</option>
		</select> <select name="include">
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
		</select> <input type="text" name="keyWord"> <input type="submit"
			value="Submit" />
	</form>
	<!--
		<form action="#" th:action="@{/MeetupController}" th:object="${selections}" method="post">
    	<p>Meetup Choice<input type="text" th:field="*{include}" /></p>
        <p>keyword: <input type="text" th:field="*{keyWord}" /></p>
        <p> <input type="reset" value="Reset" /></p>
    </form>
-->

	<table id="MeetupDisplay" align="left">
		<c:forEach var="meetup" begin="0" end="${limit}" items="${EventList}">
			
			<a href="${meetup.EVENT_LINK}"></a>
				<tr >
					<td>${meetup.GROUP_NAME}</td>
					<td>${meetup.EVENT_NAME}</td>
					<td>${meetup.EVENT_DATE}</td>
					<td>${meetup.EVENT_CITY}</td>
				</tr>
	
		</c:forEach>
	</table>


	<div id=list></div>
</body>
</html>