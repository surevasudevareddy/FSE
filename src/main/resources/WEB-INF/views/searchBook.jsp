
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Search Book</h1>
	
 
	<P>The time on the server is ${serverTime}.</p>

	<form action="searchBook" method="post">
	
		Enter Book Id:<input type="text" name="bookId"><br><br>	
		Enter Subject Id:<input type="text" name="subject.subjectId"><br><br> OR
			Enter Book Title:<input type="text" name="title"><br><br>	
		
		<input type="submit" value="Search Books">
	</form>
	<br>
	<br>
	<h2>Search Results</h2>
 
    <table border="1">
        <tr>
            
            <th>Book Id</th>
            <th>Title</th>
            <th>Price</th>
            <th>Volume</th>
            <th>Publish Date</th>
            <th>Subject Id</th>
            
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>               
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.volume}</td>
                <td>${book.publishDate}</td>
                <td>${book.subject.subjectId}</td>
            </tr>
        </c:forEach>
    </table>
	<br>
	<br>
	<li><a href=".\" target="Window" class="embed-responsive-item">Go to Main Menu</a></li>
</body>
</html>
