<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome <%=request.getParameter("username") %></h3>
<h5>Welcome ${param.username } </h5>

<hr>

<!--  HTMl Comment -->
<%-- JSP comment --%>

<p>Scriptlet</p>

<%!int a = 10; %> <%-- This is called declartion tag --%>
<% int b = 20; %> <%-- THis is call scriplet tag --%>

<%
	for(int i = 1;i<=10;i++){
		out.println(i);
	}
%>

<%= "This is expression" %>
<br>
<%= "a="+a %><br>
<%= "b="+b %><br>


<% int num1=1000; %>
<%! int num1 = 1111; %>

<%= "num1="+num1 %>

<%= 10/2 %>

<h5 align="right"><%= new Date() %></h5>





</body>
</html>