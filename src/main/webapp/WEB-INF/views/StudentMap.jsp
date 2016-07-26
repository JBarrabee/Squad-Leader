<%@ page import="net.squadleader.people.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Map</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
      </style>
      <script>
      
      //inidiate the map
      
      function initMap() {
    	 	var mapProp = {
    	 			
    	 			//centering location over michigan
    	 			  center:new google.maps.LatLng(42.7937895,-83.7500016),
    	 			  zoom: 7,
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
    	}
      </script>
</head>

<body>
<div id="map"></div>

<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&callback=initMap"></script>

</body>
</html>