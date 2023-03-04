<%@page import="com.easylearning.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	User user = (User)request.getAttribute("user");
%>

<h3>User Entered: </h3>
<p>Username : <b><%=user.getUsername() %></b></p>
<p>Password : <b><%=user.getPassword() %></b></p>
</body>
</html>