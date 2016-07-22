<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <style>
       #map {
        width: 100%;
        height: 400px;
      }
    </style>
   

</head>
<body>
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

				<p>${meetup.EVENT_STREET}</p>
				

</c:forEach>
    BREAK
<%--  ${EventList } --%>
   <div id= list> </div>

</body>
</html>