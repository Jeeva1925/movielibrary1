<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<form action="adminsignup" method="post">
<label for="id">ID:</label>
<input type="number"name="user-id" id="id">
<br>
<label for="name">Name::</label>
<input type="text"name="user-name" id="name">
<br>
<label for="id">Contact:</label>
<input type="tel"name="user-contact" id="contact">
<br>
<label for="id">Email:</label>
<input type="email"name="user-email" id="email">
<br>
<label for="password">Password:</label>
<input type="password"name="user-password" id="password">
<br>
<input type="Submit"value="submit">
</form></center>
</body>
</html>