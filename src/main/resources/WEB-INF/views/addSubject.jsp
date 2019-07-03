
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
	<h1>Add Subject</h1>
	
 
	<P>The time on the server is ${serverTime}.</p>

	<form action="subject" method="post">
	
		Subject Title:<input type="text" name="subTitle"><br>
		Duration In Hours:<input type="text" name="durationInHours"><br>
		
		<input type="submit" value="Add Subject">
	</form>
	<br>
	<br>
	<li><a href=".\" target="Window" class="embed-responsive-item">Go to Main Menu</a></li>
</body>
</html>
