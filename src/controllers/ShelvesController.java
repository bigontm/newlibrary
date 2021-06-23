package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BookCategory;
import models.DBConnection;
import models.Shelves;
import models.Student;

public class ShelvesController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "shelves";

	

	public List<Shelves> findAll()
	{
		
		List<Shelves>shelves  =  new ArrayList<Shelves>();
		
		String sql = "SELECT * FROM shelves";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
		while (rs.next())
			{
			Shelves shelvess = new Shelves(
					rs.getInt(0),
					rs.getString(1),
					rs.getString(2)
						);
				
			shelves.add(shelvess);
				
			}
			
			stmt.close();
			return shelves;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	
		
	}
	
}
