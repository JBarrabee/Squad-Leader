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
			<form:form method="post" modelAttribute="person">
				<%-- <form:errors path="*" cssClass="error" /> --%>
				<table>
					<tr>
						<td><spring:message code="lbl.firstName" text="First Name" /></td>
						<td><form:input path="FIRST_NAME" /></td>
						<td><form:errors path="FIRST_NAME" cssClass="error" /></td>
					</tr>


					<tr>
						<td><spring:message code="lbl.lastName" text="Last Name" /></td>
						<td><form:input path="LAST_NAME" /></td>
						<td><form:errors path="LAST_NAME" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl.email" text="Email " /></td>
						<td><form:input path="EMAIL" /></td>
						<td><form:errors path="EMAIL" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl.streetAddress" text="Street Address" /></td>
						<td><form:input path="STREET_ADDRESS" /></td>
						<td><form:errors path="STREET_ADDRESS" cssClass="error" /></td>
					</tr>

					<tr>
						<td><spring:message code="lbl.city" text="City" /></td>
						<td><form:input path="CITY" /></td>
						<td><form:errors path="CITY" cssClass="error" /></td>
					</tr>

					
					<tr>
						<td><spring:message code="lbl." text="State" /></td>
						
						<td><select id="STATE" name="STATE">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisianna</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
						
						</select></td>
						<td><form:errors path="STATE" cssClass="error" /></td>
					</tr>
					<tr>
						<td><spring:message code=".lbl" text="DOB" /></td>
						<td><form:input type="date" path="DOB" />
<!-- 						<td><select id="DOB_Month" name="DOB_Month"> -->
<!-- 							<option value="1">January</option> -->
<!-- 							<option value="2">February</option> -->
<!-- 							<option value="3">March</option> -->
<!-- 							<option value="4">April</option> -->
<!-- 							<option value="5">May</option> -->
<!-- 							<option value="6">June</option> -->
<!-- 							<option value="7">July</option> -->
<!-- 							<option value="8">August</option> -->
<!-- 							<option value="9">September</option> -->
<!-- 							<option value="10">October</option> -->
<!-- 							<option value="11">November</option> -->
<!-- 							<option value="12">December</option> -->
<!-- 							</select> -->
<!-- 						</td> -->
<!-- 						<td> -->
<!-- 							<select id="DOB_Day" name="DOB_Day"> -->


							
							</select>
						
						</td>
					</tr>
					<tr>
					<td><form:hidden path="ACCESS_LEVEL" /></td>
					<input id="ACCESS_LEVEL" name="ACCESS_LEVEL" type="hidden" value="false"/> 
					

					<tr>
						<td colspan="3"><input type="submit" value="Add Person" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>