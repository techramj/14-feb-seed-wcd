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
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	String confirmPwd = request.getParameter("confirmPassword");
	String invalidParam = request.getParameter("afasd");
%>
<h3>User Entered: </h3>
<p>Username : <b><%=username %></b></p>
<p>Password : <b><%=pwd %></b></p>
<p>Confirm Password : <b><%=confirmPwd %></b></p>
<p>invalidParam : <b><%=invalidParam %></b></p>






</body>
</html>