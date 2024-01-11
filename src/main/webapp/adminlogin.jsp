<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<html>
<body><center>
<h1>admin login</h1>
<form action="adminlogin"method="post">
<label for="email">Email</label>
<input type="email" name="user-email" id="email">
<br>

<label for="">Password</label>
<input type="password" name="user-password" id="password">
<br>

<input type="submit">

</form>

<%String msg=(String)request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%=msg %>
<%} %></center>
</body>
</html>