package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.DBConnection;
import models.Staff;

public class StaffController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "staffs";
	
	public static List<Staff> findAll()
	{
		List<Staff> staffs =  new ArrayList<Staff>();
		
		String sql = "SELECT * FROM staffs";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{	
				Staff staff = new Staff(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6)
						);
				
				staffs.add(staff);
				
			}
			
			stmt.close();

			System.out.println(staffs.get(1));
			return staffs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean delete(int id) 
	{
		String sql = "DELETE FROM staffs WHERE id = " + id;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			System.out.println();
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public boolean update(Staff staff)
	{
		String sql = "UPDATE staffs SET staff_name = '" + staff.getUserName() + "' ,email = '" + staff.getEmail()
				+ "' ,password = '" + staff.getPassword() + 
				"' ,is_admin = " + staff.isAdmin() + 
				",description = '" + staff.getDescription() + "' WHERE id = " + staff.getId();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			
			return ps.executeUpdate() > 0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(findAll());
	}
}
