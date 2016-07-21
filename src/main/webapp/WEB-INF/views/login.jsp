<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Spring Form Tag Library -->    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error{
color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>

<!--Links to local bootstrap and main .css and .js files THESE NEED TO BE INCLUDED IN EVERY PAGE  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>
<h1>Please Enter Your Account Information</h1>
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
					<td colspan="2"><input type="submit" value="Submit"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<br>
	<a href="addPerson.html">Sign Up</a>
</body>
</html>