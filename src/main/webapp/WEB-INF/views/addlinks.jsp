<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online resources</title>
</head>
<body>
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
						<td colspan="3"><input type="submit" value="Add Link" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>