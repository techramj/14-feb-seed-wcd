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

<%@ include file="header.jsp" %>
<%-- <jsp:include page="header.jsp" /> --%>

<jsp:useBean id="user" class="com.easylearning.model.User" scope="request">
</jsp:useBean>


<h3>User Entered: </h3>
<p>Username : <b><jsp:getProperty property="username" name="user"/></b></p>
<p>Password : <b><jsp:getProperty property="password" name="user"/></b></p>

<%-- <%@ include file="footer.jsp" %> --%>
<jsp:include page="footer.jsp" />
</body>
</html>