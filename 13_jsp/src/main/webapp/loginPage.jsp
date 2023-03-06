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

<jsp:useBean id="user" class="com.easylearning.model.User" scope="request">
	<jsp:setProperty property="username" name="user" />
	<jsp:setProperty property="password" name="user"  />
</jsp:useBean>


<jsp:useBean id="user1" class="com.easylearning.model.User" scope="request">
	<jsp:setProperty property="*" name="user1" />
</jsp:useBean>


<jsp:forward page="loginSuccess.jsp" />


</body>
</html>