package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.DBConnection;
import models.RentingBook;
import models.Student;

public class RentingBookController {
	static Connection conn = DBConnection.connect();
	public static String tableName = "renting_books";
	
	public void loadUITable(JTable UITable)
	{
		String sql = "SELECT S.student_name, R.id, S.contact_number,R.createdAt, R.return_date, St.staff_name, R.actual_return_date, B.book_name FROM renting_books R, students S, staffs St, books B WHERE B.id = R.book_id AND  R.student_id = S.id AND St.id = R.staff_id";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
			
            String[] cols = new String[columnCount];
            DefaultTableModel model = (DefaultTableModel) UITable.getModel();

            int index = 0;
            while (rs.next())
            {
               index++;
               Object[] row = new Object[columnCount];
               row[0] = index;
               row[1] = rs.getString(1);
               row[2] = rs.getInt(2);
               row[3] = rs.getString(3);
               row[4] = rs.getDate(4);
               row[5] = rs.getDate(5);
               row[6] = rs.getString(6);
               row[7] = rs.getDate(5).compareTo(rs.getDate(7)) > 0?"Ä�Ã£ tráº£ sÃ¡ch":"ChÆ°a tráº£ sÃ¡ch";
               model.addRow(row);
            }
            
           UITable.setModel(model);
           model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean delete(int id) 
	{
		String sql = "DELETE FROM " + tableName + " WHERE id = ? ";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public static boolean update(RentingBook rentingbook)
	{
		String sql = "UPDATE SET book_id = ? , staff_id = ?, student_id = ?"
				+ "actual_return_date = ?, return_date = ?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(2, rentingbook.getBookId());
			ps.setInt(3,rentingbook.getStaffId());
			ps.setInt(3, rentingbook.getStudentId());
			ps.setDate(4, rentingbook.getActualReturnDate());
			ps.setDate(5, rentingbook.getReturnDate());
			
			return true;
		
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
	
	public static void main(String[] args)
	{
		System.out.println(RentingBookController.findOne(145));
	}
}

