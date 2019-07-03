
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Search Subject</h1>
	
 
	<P>The time on the server is ${serverTime}.</p>

	<form action="searchSubject" method="post">
	
		Enter Subject Id:<input type="text" name="subjectId"><br> OR <br>	
		Enter Duration In Hours :<input type="text" name="durationInHours"><br><br>	
		
		<input type="submit" value="Search Subject">
	</form>
	<br>
	<br>
	<h2>Search Results</h2>
 
    <table border="1">
        <tr>
            <th>Subject Id</th>
            <th>Subtitle</th>
            <th>Duration In Hrs</th>
        </tr>
        <c:forEach items="${subjects}" var="subject">
            <tr>
                <td>${subject.subjectId}</td>
                <td>${subject.subTitle}</td>
                <td>${subject.durationInHours}</td>
            </tr>
        </c:forEach>
    </table>
	<br>
	<br>
	<li><a href=".\" target="Window" class="embed-responsive-item">Go to Main Menu</a></li>
</body>
</html>
