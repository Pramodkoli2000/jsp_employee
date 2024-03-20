<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String message=(String)request.getAttribute("message");

if(message!=null){
	
%>


<h2><%= message %></h2>
<%
}
%>


<form action="login" method="post">
  <h2>Enter the details...</h2>
   Email:<input type="text" name="email">
   Password:<input type="password" name="password">
   <button>LogIn</button>
   </form>

</body>
</html>
