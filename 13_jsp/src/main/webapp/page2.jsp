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
<h3 align="center">Page2</h3>
<jsp:useBean id="one" class="com.easylearning.model.User" scope="session" />
<jsp:useBean id="two" class="com.easylearning.model.User" scope="request" />

<%=one %><br>
<%= two %>

<h3>User1 details</h3>
<p>Username: <b><jsp:getProperty property="username" name="one"/> </b></p>
<p>Firstname: <b><jsp:getProperty property="firstname" name="one"/></b></p>
<p>Lastname: <b><jsp:getProperty property="lastname" name="one"/></b></p>

<h3>User2 details</h3>
<p>Username: <b><jsp:getProperty property="username" name="two"/></b></p>
<p>Firstname: <b><jsp:getProperty property="firstname" name="two"/></b></p>
<p>Lastname: <b><jsp:getProperty property="lastname" name="two" /></b></p>


<hr>
<a href="test.jsp">Go to test page</a>
</body>
</html>