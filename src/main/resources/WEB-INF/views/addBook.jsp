
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Add Book</h1>
	
 
	<P> ${userName}.</p>

	<form action="book" method="post">
	
		Title:<input type="text" name="title"><br>
		Price:<input type="text" name="price"><br>
		Volume:<input type="text" name="volume"><br>
		Publish Date:<input type="text" name="publishDate"><br>
		Subject Id:<input type="text" name="subject.subjectId"><br>
		<input type="submit" value="Add Book">
	</form>
	<br>
	<br>
	<li><a href=".\" target="Window" class="embed-responsive-item">Go to Main Menu</a></li>
</body>
</html>
