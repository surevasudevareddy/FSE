
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Delete Subject</h1>
	
 
	<P>The time on the server is ${serverTime}.</p>

	<form action="deleteBook" method="post">
	
		Enter Book Id:<input type="text" name="bookId"><br><br>		
		
		<input type="submit" value="Delete Book">
	</form>
	<br>
	<br>
	<h2>Search Results</h2>
 
    
	<br>
	<br>
	<li><a href=".\" target="Window" class="embed-responsive-item">Go to Main Menu</a></li>
</body>
</html>
