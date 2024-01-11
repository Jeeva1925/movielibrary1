package controller;

import java.io.IOException;
import java.sql.SQLException;

import dto.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
@WebServlet("/deletemovie")
public class DeleteMovies extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		
		Dao dao =new Dao();
		
		try {
			dao.deleteMovies(id);
			req.setAttribute("movies",dao.getAllMovies());
			RequestDispatcher dispatcher =req.getRequestDispatcher("adminhome.jsp");
			dispatcher.include(req, resp);
            }
		 catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }
	}
}