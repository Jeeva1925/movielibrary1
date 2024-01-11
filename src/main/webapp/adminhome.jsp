<%@page import="java.util.Base64"%>

<%@page import="java.util.List"%>

<%@page import="dto.Movie" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,td,th{
border: 2px solid black;
border-collapse: collapse;
background-color: burlywood;
}
th,td{
padding: 5px;
}
</style>
</head>
<body><center>
	<h1>Admin home:</h1>
<h4><a href="addmovie.jsp">Add movie -></a></h4>
<br>
<br>
<% List<Movie> movies=(List)request.getAttribute("movies"); %>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
<th>Ratings</th>
<th>Genre</th>
<th>Language</th>
<th>Image</th>
<th>Delete</th>
<th>Edit</th>
<%for(Movie m : movies){ %>
<tr>
<td><%=m.getMovieid()%></td>
<td><%=m.getMoviename() %></td>
<td><%=m.getMovieprice() %></td>
<td><%=m.getMovieratings() %></td>
<td><%=m.getMoviegenre() %></td>
<td><%=m.getLanguage() %></td>
<%String base64image = new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<td><img src="data:image/jpeg;base64,<%=base64image%>" height="150px" width="150px"></td>
<td><a href="deletemovie?id=<%=m.getMovieid()%>">Delete</a></td>
<td><a href=""id="">Edit</a>
</tr>
<%}%>
</table></center>
</body>
</html>