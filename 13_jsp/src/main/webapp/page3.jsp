<%@page import="com.easylearning.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Page3</h3>


	<h3>User1 details</h3>
	<p>
		Username: <b>${sessionScope.one.username } </b>
	</p>
	<p>
		Firstname: <b>${sessionScope.one.firstname }</b>
	</p>
	<p>
		Lastname: <b>${sessionScope.one.lastname }</b>
	</p>

	<h3>User2 details</h3>
	<p>
		Username: <b>${requestScope.two.username } </b>
	</p>
	<p>
		Firstname: <b>${requestScope.two.firstname }</b>
	</p>
	<p>
		Lastname: <b>${requestScope.two.lastname }</b>
	</p>

	<hr>

	<h3>User1 details</h3>
	<c:set var="a" value="10"></c:set>
	<c:out value="Hello"></c:out>
	<c:out value="${a }" />

	<table border="1">
		<tr>
			<th>Username</th>
			<th>Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="user" items="${requestScope.users }">
			<tr>
				<td>${user.username }</td>
				<td>${user.username }</td>
				<td>${user.username }</td>
			</tr>
		</c:forEach>
	</table>



	<hr>
	<a href="test.jsp">Go to test page</a>
</body>
</html>