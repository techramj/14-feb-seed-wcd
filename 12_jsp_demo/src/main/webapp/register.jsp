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
<div class="container" >
	<form role="form" action="registerSuccess1.jsp" method="post">
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" id="usernmae" placeholder="Enter username" name="username">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
	  </div>
	  
	  <div class="form-group">
	    <label for="confrimPassword">Confirm Password</label>
	    <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" 
	    name="confirmPassword">
	  </div>
	  
	  <button type="submit" class="btn btn-default">register</button>
	</form>
</div>


</body>
</html>