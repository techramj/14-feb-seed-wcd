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
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	User user = new User();
	user.setUsername(username);
	user.setPassword(pwd);
	
	//session.setAttribute("user", user);
	if("123".equals(pwd)){
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
		rd.forward(request, response);
	}else{
%>
<p>Invalid username & password</p>
<a href="login.jsp">click</a> for Login page

<%
	}
%>

</body>
</html>