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

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="bootstrap/js/bootstrap.js"></script>
	
<link rel="stylesheet" type="text/css" href="css/tablepage.css">
<link rel="stylesheet" type="text/css" href="css/sortTables.css">
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- <script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>View Resource List</title>
</head>
<body>
<h1>SQUAD LEADER</h1>
	
	<nav class="navbar navbar-dark bg-inverse ">
	<ul class="nav navbar-nav ">

		<li class="nav-item">
 		<a class="nav-link" href="addSuccess.html">Home</a>
  		</li>
  		<li class="nav-item">
  		<a class="nav-link" href="meetUpMap.html">Tech Meetups in Metro Detroit</a>
   		</li>
   		<li class="nav-item"><a class="nav-link" href="addlinks.html">Add a Resource</a>
		</li>
  		<li class="nav-item">
  		<a class="nav-link" href="StudentMap.html">Student Map</a>
   		</li>
   		
   		<li class="nav-item"><a class="nav-link"
		href=" Logout.html">Log Out</a></li>
		
	</ul>
	</nav>

	
<!-- 	<form action="viewLinks.html" method="Post"> -->
<!-- 	<select name="categories"> -->
<!-- 	<option value="all">All Categories</option> -->
<!-- 	<option value="SQL">SQL</option> -->
<!-- 	<option value="Java">Java</option> -->
<!-- 	<option value="Javascript">JavaScript</option> -->
<!-- 	<input type="submit" value="Filter"></input> -->
<!-- 	</select> -->
<!-- 	</form> -->

	<h2>Resources</h2>
	<script>
	function filterButton(){
		var Button = document.getElementById("filter");
		var Category = Button.options[Button.selectedIndex].value;
		var search = document.getElementById("search");
		search.value = Category;
		var event = new Event('onchange');
		search.dispatchEvent(event);
		
	}
	</script>
	<select name="categories" id = "filter" onchange="filterButton()">
	<c:forEach var="row" items="${Link}">
	<option value="${row.getCategory()}">${row.getCategory()}</option>
	</c:forEach>
	</select>
<!-- 	<button value="Filter" onclick="filterButton()">Filter</button> -->
	<div id="users">
  <input class="search" placeholder="Search" id="search"/>
  <button class="sort btn btn-primary btn-lg" data-sort="category">
    Sort by Category
  </button>
  </br>
  </br>
	<table>
		<tr>
			<th>Category</th>
			<th>Title</th>
		</tr>
		<tbody class="list">
		<c:forEach var="row" items="${Link}">
		<tr>
			<td class="category">${row.getCategory()}</td>
			<td class="link"><a href="${row.getURL()}">${row.getTitle()}</a></td>
		</tr>
		</c:forEach>
		</select>
	</tbody>
	</table>
	</div>
<script src="http://listjs.com/no-cdn/list.js"></script>
<script src="JS/tablesort.js"></script>
</body>
</html>