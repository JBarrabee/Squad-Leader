<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Spring Form Tag Library -->    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Links to local bootstrap and main .css and .js files THESE NEED TO BE INCLUDED IN EVERY PAGE  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow|Open+Sans' rel='stylesheet' type='text/css'>

<style>
div {
    
    margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 150px;
    margin-left: 80px;
    
    
}
.error{
color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>



</head>
<body>
<h1>SQUAD LEADER</h1>
	 <!--logging out does not prevent you from clicking back through nav bar on this page if cookie is still valid
	 
	  <nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">
		<li class="nav-item">
		
 		<a class="nav-link" href="addSuccess.html">Home</a>
  		</li>
  		<li class="nav-item">
  		<a class="nav-link" href="meetUpMap.html">Tech Meetups in Metro Detroit</a>
  		Can we use this link to post to get a prefilled MeetupMap? Use Expression language
  		
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
	</nav>  -->
   		
<div>
<h3>Please Enter Your Account Information</h3>
	<form:form action="submitLogin.html" method="POST">
		<table>
			<tbody>
				<tr>
					<td><form:input path="EMAIL" placeholder="Enter email"></form:input></td>
					<td class="error">${userError}</td>
				</tr>
				<tr>
					<td><form:input path="PASS" placeholder="Enter password"></form:input></td>
					<td class="error">${passError}</td>
				</tr>
				<tr>
					
					<td colspan="2"></br></br><input type="submit" value="Submit"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<br>
	<a href="addPerson.html">Sign Up</a></div>
</body>
</html>