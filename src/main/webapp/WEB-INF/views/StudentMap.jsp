<%@ page import="net.squadleader.people.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Map</title>

<script src="https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&location="></script>
<script>
function initialize() 
{
 	var mapProp = {
	  center:new google.maps.LatLng(42.7937895,-83.7500016),
	  zoom: 6,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map=new google.maps.Map(document.getElementById("googleMap"), mapProp);
	SetMarkers();
}

google.maps.event.addDomListener(window, 'load', initialize);

function SetMarkers() {
//call to database for lat and long
<c:forEach var="student" items="${students}">
	var latitude: ${student.getLAT()};
	var longitude: ${student.getLNG()};
	var myLatLng = {lat: latitude, lng: longitude};
	var name = ${student.getFIRST_NAME()} + " " + ${student.getLAST_NAME()};

	var marker = new google.maps.Marker({
		position: myLatLng;
		map: map;
		title: name;
	}) ;
</c:forEach>

} 


</script>
</head>

<body>
<div id="googleMap" style="width:500px;height:380px;"></div> 


</body>
</html>