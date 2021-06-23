package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Author;
import models.BookCategory;
import models.DBConnection;
import models.Student;

public class AuthorController{
	static Connection conn = DBConnection.connect();
	public static String tableName = "authors";

	

	public List<Author> findAll()
	{
		
		List<Author>authors  =  new ArrayList<Author>();
		
		String sql = "SELECT * FROM authors";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
		while (rs.next())
			{
				Author author = new Author(
					rs.getInt(0),
					rs.getString(1),
					rs.getString(2),
					rs.getString(3)
				);
				authors.add(author);
				
			}
			
			stmt.close();
			return authors;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	
		
	}
	
}
