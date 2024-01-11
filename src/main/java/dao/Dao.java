package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin;
import dto.Movie;


public class Dao 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
}
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException 
	{
		Connection conn=getConnection();
		PreparedStatement pst =conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		
		pst.setInt(1,admin.getAdminid());
		pst.setString(2,admin.getName());
		pst.setLong(3,admin.getContact());
		pst.setString(4,admin.getAdminmail());
		pst.setString(5,admin.getAdminpassword());

		return pst.executeUpdate() ;
}
	public Admin findByEmail(String adminmail) throws ClassNotFoundException, SQLException {

		Connection connection =getConnection();
		PreparedStatement pst =connection.prepareStatement("select * from admin where adminmail = ?");

		pst.setString(1, adminmail);

		ResultSet rs =pst.executeQuery();
		Admin a =new Admin();
        
		rs.next();
		a.setAdminid(rs.getInt(1));
		a.setName(rs.getString(2));
		a.setContact(rs.getLong(3));
		a.setAdminmail(rs.getString(4));
		a.setAdminpassword(rs.getString(5));

		return a;
	}
		public int saveMovie(Movie movie) throws  SQLException, ClassNotFoundException {

			Connection conn =getConnection();
			PreparedStatement pst =conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
			
			pst.setInt(1,movie.getMovieid());
			pst.setString(2,movie.getMoviename());
			pst.setDouble(3,movie.getMovieprice());
			pst.setDouble(4,movie.getMovieratings());
			pst.setString(5,movie.getMoviegenre());
			pst.setString(6,movie.getLanguage());
			Blob imageblob =new SerialBlob(movie.getMovieimage());
			pst.setBlob(7,imageblob);

			return pst.executeUpdate();

		}
		public List<Movie> getAllMovies() throws ClassNotFoundException, SQLException{
			Connection conn=getConnection();
			PreparedStatement pst =conn.prepareStatement("select * from movie");
			ResultSet rs =pst.executeQuery();
			
			List<Movie> moviesList =new ArrayList<Movie>();
			
			while (rs.next()) {
				Movie movie =new Movie();
				movie.setMovieid(rs.getInt(1));
				movie.setMoviename(rs.getString(2));
				movie.setMovieprice(rs.getDouble(3));
				movie.setMovieratings(rs.getDouble(4));
				movie.setMoviegenre(rs.getString(5));
				movie.setLanguage(rs.getString(6));
				Blob b =rs.getBlob(7);
				byte[] img = b.getBytes(1,(int)b.length());
				movie.setMovieimage(img);
				moviesList.add(movie);
			}
			return moviesList;
			
		}
		public int deleteMovies(int id) throws ClassNotFoundException, SQLException {
			
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("delete from movie where movieid = ?");
       
			pst.setInt(1,id);
			return pst.executeUpdate();
			
		}

}
