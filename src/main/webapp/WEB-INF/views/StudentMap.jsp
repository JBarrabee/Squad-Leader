<%@ page import="net.squadleader.people.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Map</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 500px;
      }
      </style>
      <script>
      
      //inidiate the map
      
      function initMap() {
    	 	var mapProp = {
    	 			
    	 			//centering location over michigan
    	 			  center:new google.maps.LatLng(42.4448945,-83.1213776),
    	 			  zoom: 10,
    	 			  mapTypeId: google.maps.MapTypeId.ROADMAP
    	 			};
    	 			var map=new google.maps.Map(document.getElementById("map"), mapProp);

    	 			//loop that runs through students in database and creates markers for students with addresses
   	 				<c:forEach var="student" items="${students}">
   	 					<c:set var="hasLatLng" value="${student.getLAT()!=null  && student.getLNG()!=null}" />
   	 					<c:if test="${hasLatLng}">
   	 				
   	 							var latitude=${student.getLAT()};
   	 							var longitude= ${student.getLNG()};
   	 							var myLatLng = {lat: latitude, lng: longitude};
   	 							var name = "${student.getFIRST_NAME()} ${student.getLAST_NAME()}";
   	 							var marker = new google.maps.Marker({
   	 								position: myLatLng,
   	 								map: map,
   	 								title: name
   	 							}) ;
   	 						</c:if>
   	 				</c:forEach>
   	 			//<c:forEach var="meetup" items="${eventList}">
   					//	<c:set var="hasLatLng" value="${meetup.getEVENT_LATITUDE()!=null  && meetup.getEVENT_LONGITUDE()!=null}" />
   					//	<c:if test="${hasLatLng}">
   					
   							//	var latitude=${meetup.getEVENT_LATITUDE()};
   							//	var longitude= ${meetup.getEVENT_LONGITUDE()};
   							//	var myLatLng = {lat: latitude, lng: longitude};
   							//	var name = "${meetup.getEVENT_NAME()} ${student.getLAST_NAME()}";
   							//	var marker = new google.maps.Marker({
   							//		position: myLatLng,
   							//		map: map,
   							//		title: name
   							//	}) ;
   						//	</c:if>
   					//</c:forEach>
    	}
      </script>
</head>

<body>
<h1>SQUAD LEADER</h1>
<nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">

		<li class="nav-item">
  		<a class="nav-link" href="addSuccess.html">HOME</a>
   		</li>
   		<li class="nav-item">
  		<a class="nav-link" href="meetUpMap.html">Tech Meetups in Metro Detroit</a>
   		</li>
   		<li class="nav-item">
  		<a class="nav-link" href="viewLinks.html">Resources</a>
   		</li>
   		<li class="nav-item">
  		<a class="nav-link" href="StudentMap.html">Student Map</a>
   		</li>
   		<li class="nav-item"><a class="nav-link"
		href=" Logout.html">Log Out</a></li>
		</ul>
	</nav>
<h2>Student Map</h2>
<div id="map"></div>

<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&callback=initMap"></script>

</body>
</html>