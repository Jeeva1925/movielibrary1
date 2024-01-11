<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add movie</h1>
<form action="savemovie" method="post" enctype="multipart/form-data">
	 <label for="id">Id:</label>
        <input type="number" name="user-id" id="id">
        <br>
         <label for="name">Name:</label>
        <input type="text" name="user-name" id="name">
        <br>
         <label for="price">Price:</label>
        <input type="number" name="user-price" id="price">
        <br>
         <label for="ratings">Ratings:</label>
        <input type="number" name="user-ratings" id="ratings">
        <br>
         <label for="genre">Genre:</label>
        <input type="text" name="user-genre" id="genre">
        <br>
         <label for="language">Language:</label>
        <input type="text" name="user-language" id="language">
        <br>
         <label for="image">Image:</label>
        <input type="file" name="user-image" id="image">
        <br>  
        <input type="submit">
        <input type="reset">
	</form>
</body>
</html>