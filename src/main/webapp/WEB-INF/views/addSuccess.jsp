<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>

<title>HOME</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Carousel boostrap link -->
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 40%;
      margin: auto;
  }
</style>


</head>
<body>
<h2>Welcome to</h2>
<h1>Squad Leader</h1>
<nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">
		<li class="nav-item">
 		<a class="nav-link" href="addSuccess.html">Home</a>
  		</li>
		<li class="nav-item">
  		<a class="nav-link" href="meetUpMap.html">Tech Meetups in Metro Detroit</a>
  		<!-- Can we use this link to post to get a prefilled MeetupMap? Use Expression language
  		 -->
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
	<p> This is your survival guide for coding bootcamps. Network your way into your first tech job, use only the most efficient and effective online resources, and find other coding bootcamp students near you for face-to-face support. OORAH!</p>


<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://files.meetup.com/1760803/MEETUP%20Logo.jpg" alt="Meetup" width="460" height="345">
         <a href="meetUpMap.html">
          <h4>Metro Detroit Tech Meetups</h4> 
         <p>We recommend attending 1-2 meetups a week while on the job search to grow your network.</p>
         
      </div>

      <div class="item">
        <img src="http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-icon.png?v=c78bd457575a" alt="Links" width="460" height="345">
        <a href="viewLinks.html">
        <h4>Frequently Used Resources</h4>
        <p>No need to bookmark, here's a list of the resources you should go to first when you just can't figure out that tough code question on your own.</p>
         
      </div>
    
      <div class="item">
        <img src="http://www.destination360.com/north-america/us/michigan/detroit/ramada-inn-downtown-detroit-map.gif" alt="Student Map" width="460" height="345">
        <a href="StudentMap.html">
        <h4>Student Map</h4>
        <p> Sometimes the best solution is teamwork! Find out where fellow bootcampers are near you for help during after bootcamp hours or organize carpools easily.</p>
        
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


	
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