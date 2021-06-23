package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BookCategory;
import models.DBConnection;
import models.Student;

public class BookCategorycontroller {
	static Connection conn = DBConnection.connect();
	public static String tableName = "book_categories";

	

	public List<BookCategory> findAll()
	{
		
		List<BookCategory>book_categories  =  new ArrayList<BookCategory>();
		
		String sql = "SELECT * FROM book_categories";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
		while (rs.next())
			{
				BookCategory bookcategory = new BookCategory(
					rs.getInt(0),
					rs.getString(1)
						);
				
				book_categories.add(bookcategory);
				
			}
			
			stmt.close();
			return book_categories;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	
		
	}
	
}
