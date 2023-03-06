<%@page import="java.util.List"%>
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
<h3 align="center">Page1</h3>

<%
	User user1 = (User)request.getAttribute("two");
	User user2 = (User)session.getAttribute("one");
%>


<h3>User1 details</h3>
<p>Username: <b><%=user1.getUsername() %></b></p>
<p>Firstname: <b><%=user1.getFirstname() %></b></p>
<p>Lastname: <b><%=user1.getLastname() %></b></p>

<h3>User2 details</h3>
<p>Username: <b><%=user2.getUsername() %></b></p>
<p>Firstname: <b><%=user2.getFirstname() %></b></p>
<p>Lastname: <b><%=user2.getLastname() %></b></p>

<hr>

<table border="1">	
    <tr><th>Username</th><th>Name</th><th>Last Name</th></tr>
    <%
    	List<User> list = (List<User>)request.getAttribute("users");
        for(User user:list){
        	out.println("<tr>");
        	out.println("<td>"+user.getUsername()+"</td>");
        	out.println("<td>"+user.getFirstname()+"</td>");
        	out.println("<td>"+user.getLastname()+"</td>");
        	out.println("</tr>");
        }
    %>
</table>



<a href="test.jsp">Go to test page</a>
</body>
</html>