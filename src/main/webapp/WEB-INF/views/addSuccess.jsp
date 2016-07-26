<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>

<!--Links to local bootstrap and main .css and .js files THESE NEED TO BE INCLUDED IN EVERY PAGE  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>

<title>HOME</title>


</head>
<body>
<h1>Welcome To Squad Leader!</h1>
<nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">
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
		href=" Logout.html">LOG OUT</a></li>
		</ul>
	</nav>
	<p> This is your survival guide to coding bootcamps. Network your way into your first tech job, use only the most efficient and effective online resources, and find other coding bootcamp students near you for face-to-face support. OORAH!</p>
	
	
<%
// 		String loggedIn = null;
// 		Cookie[] cookies = request.getCookies();
// 		if(cookies != null) {
// 			for (Cookie cookie: cookies) {
// 				if (cookie.getName().equals("loggedIn") && cookie.getValue().equals("true"))
// 					loggedIn = cookie.getValue();
// 			}
// 		}
// 		if(loggedIn == null)
// 			System.out.println("bruh");
// 			response.sendRedirect("createLogin.html");
	
%>	
</body>
</html>