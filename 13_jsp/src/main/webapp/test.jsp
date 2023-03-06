<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="test">
    <input  type="hidden"  name="page" value="page1.jsp" >
	<button type="submit">Go to page1</button>
</form>
<br>
<form action="test">
    <input  type="hidden"  name="page" value="page2.jsp" >
	<button type="submit">Go to page2</button>
</form>
<br>
<form action="test">
    <input  type="hidden"  name="page" value="page3.jsp" >
	<button type="submit">Go to page3</button>
</form>

<br>
<form action="a.do">
    <input  type="hidden"  name="page" value="a.do" >
	<button type="submit">Go to Page A</button>
</form>

</body>
</html>