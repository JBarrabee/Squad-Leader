<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">

<script src="bootstrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/tablepage.css">
<title>Upcoming Meetups</title>

 <style>
       #map {
        width: 100%;
        height: 400px;
      }
    </style>
   

</head>

<body>
<div class="container">
  <h2>Upcoming Meetups</h2>
  
  <table class="table table-hover">
    <thead>
      <tr>
 <script>
 
 //${EventList}
 /* for (i = 0; i < EventList.length; i++) {
	 
		
	 
 document.getElementById(list).innerHTML = document
	.getElementById(list).innerHTML
	+ "<p>"
	+ "Group EVENT = " + EventList.get(i).meetup.EVENT_ID */
	/* + ", Group URL = " + meetup.GROUP_URL
	+ "<br>"
	+ "Group Name = " + meetup.GROUP_NAME
	+ ", Event Date =  " + meetup.EVENT_DATE
	+ ", Event Name =  " + meetup.EVENT_NAME
	+ "<br>"
	+ "Event Venue Name = " + meetup.EVENT_VENUE_NAME
	+ "<br>"
	+ ", Event Street =  " + meetup.EVENT_STREET
	+ ", Event City =  " + meetup.EVENT_CITY
	+ ", Event State = " + meetup.EVENT_STATE
	+ ", Event ZIP =  " + meetup.EVENT_ZIP
	+ "<br>"
	+ ", Event LONG = " + meetup.EVENT_LONGITUDE
	+ ", Event LAT =  " + meetup.EVENT_LATITUDE
	+ ", Event Link =  " + meetup.EVENT_LINK */
	/* + "</p><br>";
 }
      */
    </script>
<c:forEach var="meetup" items="${EventList}">
	
<table>
  <tr>
				<td>${meetup.GROUP_NAME}</td>
				<td>${meetup.EVENT_NAME}</td>
				<td>${meetup.EVENT_DATE}</td>
				<td>${meetup.EVENT_STREET}</td>
				</tr>
				</tbody>
	</table>
	 			
</div>
</c:forEach>
    
<%--  ${EventList } --%>
   <div id= list> </div>

</body>
</html>