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

<title>Add Employee Form</title>


</head>

<body>

	<nav class="navbar navbar-dark bg-inverse ">
		<ul class="nav navbar-nav ">

			<li class="nav-item pull-*-right"><a class="nav-link"
				href=" addEmployee.html">SIGN UP</a></li>
			<li class="nav-item"><a class="nav-link" href="">LOG IN</a></li>
		</ul>
	</nav>

	<div class="row">
		<h2>
			<spring:message code="lbl.page" text="Enter Your Info" />
		</h2>
	</div>


	<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<form:form method="post" modelAttribute="employee">
				<%-- <form:errors path="*" cssClass="error" /> --%>
				<table>
					<tr>
						<td><spring:message code="lbl.firstName" text="First Name" /></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>


					<tr>
						<td><spring:message code="lbl.lastName" text="Last Name" /></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl.email" text="Email " /></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl." text="Street Address" /></td>
						<td><form:input path="streetAddress" /></td>
						<td><form:errors path="streetAddress" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl." text="City" /></td>
						<td><form:input path="city" /></td>
						<td><form:errors path="city" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl." text="State" /></td>
						<td><form:input path="state" /></td>
						<td><form:errors path="state" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl." text="State" /></td>
						<td><form:input path="state" /></td>
						<td><form:errors path="state" cssClass="error" /></td>
					</tr>
					


					<tr>
						<td colspan="3"><input type="submit" value="Add Employee" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>