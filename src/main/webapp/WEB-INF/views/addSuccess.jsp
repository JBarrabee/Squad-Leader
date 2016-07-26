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

	<nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">

		<li class="nav-item"><a class="nav-link"
		href=" Logout.html">LOG OUT</a></li>
		<li class="nav-item">
  		<a class="nav-link" href="meetUpMap.html">Check out relevant MeetUps in the area!</a>
   		</li>
   		<li class="nav-item">
  		<a class="nav-link" href="viewLinks.html">Links to Online Resources!!</a>
   		</li>
		</ul>
	</nav>
	
	
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