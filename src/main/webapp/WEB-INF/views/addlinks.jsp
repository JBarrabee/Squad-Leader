<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online resources</title>
</head>
<body>
<h1>SQUAD LEADER</h1>
<nav class="navbar navbar-dark bg-inverse ">
	<ul class="nav navbar-nav ">

		<li class="nav-item"><a class="nav-link" href="addSuccess.html">HOME</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="meetUpMap.html">Tech
				Meetups in Metro Detroit</a></li>
		<li class="nav-item"><a class="nav-link" href="viewLinks.html">Resources</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="StudentMap.html">Student
				Map</a></li>
		<li class="nav-item"><a class="nav-link" href=" Logout.html">Log
				Out</a></li>
	</ul>
	</nav>
	<h2>Add a Resource</h2>
<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<form:form method="post" action="viewlinks.html">
				<%-- <form:errors path="*" cssClass="error" /> --%>
				<table>
					<tr>
						<td><spring:message code="lnk.cat" text="Category" /></td>
						<td><form:input path="Category" /></td>
						<td><form:errors path="Category" cssClass="error" /></td>
					</tr>


					<tr>
						<td><spring:message code="lnk.title" text="Title" /></td>
						<td><form:input path="Title" /></td>
						<td><form:errors path="Title" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lnk.url" text="URL" /></td>
						<td><form:input path="URL" /></td>
						<td><form:errors path="URL" cssClass="error" /></td>
					</tr>

					<tr>
						<td colspan="3"></br></br><input type="submit" value="Add Link" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>