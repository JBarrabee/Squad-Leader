<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="net.squadleader.links.LinksDAO"%>
<%@ page import="net.squadleader.links.Links"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/tablepage.css">
<title>View Resource List</title>
</head>
<body>
	<h1>All Links</h1>
	<nav class="navbar navbar-dark bg-inverse ">
	<ul class="nav navbar-nav ">

	<li class="nav-item"><a class="nav-link"
	href=" Logout.html">LOG OUT</a></li>
	<li class="nav-item">
 		<a class="nav-link" href="addSuccess.html">Student Home</a>
  		</li>
  		<li class="nav-item">
 		<a class="nav-link" href="addlinks.html">Add a Resource</a>
  		</li>
	</ul>
	</nav>
	
	<form>
	<select name="categories">
	<option value="all">All Categories</option>
	<option value="SQL">SQL</option>
	<option value="Java">Java</option>
	<option value="Javascript">JavaScript</option>
	</select>
	</form>
	<table>
		<tr>
			<th>Category</th>
			<th>Title</th>
		</tr>
		<c:forEach var="row" items="${Links}">
		<tr>
			<td>${row.getCategory()}</td>
			<td><a href="${row.getURL()}">${row.getTitle()}</a></td>
		</tr>
		</c:forEach>
		</select>
	</table>
</body>
</html>