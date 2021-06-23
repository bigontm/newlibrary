package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.DBConnection;
import models.Student;

public class StudentController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "students";
	
	public List<Student> findAll()
	{
		List<Student> students =  new ArrayList<Student>();
		
		String sql = "SELECT * FROM students";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Student student = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				students.add(student);
				
			}
			
			stmt.close();
			return students;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean delete(int id) 
	{
		String sql = "DELETE FROM " + tableName + " WHERE id = ?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println();
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public boolean update(Student student)
	{
		String sql = "UPDATE students SET dob = '" + student.getDob() + "', student_name = '" + student.getStudentName() + "' ,gender = " + student.getGender()
				+ ",class_name = '" + student.getClassName() + 
				"' ,contact_number = '" + student.getContactNumber() + 
				"' ,email = '" + student.getEmail() + "' WHERE id = " + student.getId();
		
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
	
	public static Student findOne(int id)
	{
		String sql = "SELECT S.* FROM renting_books R, students S WHERE R.student_id = S.id AND S.id = " + id;
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				
				Student student = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				return student;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Student> findBySearch(String textSearch)
	{
		List<Student> students =  new ArrayList<Student>();
		
		String sql = "SELECT * FROM students WHERE student_name LIKE '%"  + textSearch + "%'";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next())
			{
				Student student = new Student(
						rs.getInt(1),
						rs.getString(1),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						);
				
				students.add(student);
				
			}
			
			stmt.close();
			return students;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println(RentingBookController.findOne(145));
	}
}

