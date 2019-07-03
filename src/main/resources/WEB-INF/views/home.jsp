
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Action Menu</h1>
	<ul>
	<li><a href=".\addSubject" target="#" class="embed-responsive-item">Add Subject</a></li>
	<li><a href=".\addBook" target="#" class="embed-responsive-item">Add Book</a></li>
	<li><a href=".\deleteBook" target="blank" class="embed-responsive-item">Delete Book</a></li>
	<li><a href=".\deleteSubject" target="_blank" class="embed-responsive-item">Delete Subject</a></li>
	<li><a href=".\searchBook" target="_blank" class="embed-responsive-item">Search Book</a></li>
	<li><a href=".\searchSubject" target="_blank" class="embed-responsive-item" method="POST">Search Subject</a></li>
	</ul>
 
	<P>The time on the server is ${serverTime}.</p>

	
</body>
</html>
