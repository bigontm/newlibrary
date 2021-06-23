package controllers;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.DBConnection;
import models.Book;
import models.Author;
import models.BookCategory;
import models.Shelves;
import models.Student;



public class manageBook {
	static Connection conn = DBConnection.connect();
	public static String tableName = "books";

	public List<Book> findAll(){
		
		String sql = "SELECT * FROM books b, book_categories bc,shelves s,authors a WHERE b.id=bc.id AND b.id=s.id AND a.id=b.id ";
		List<Book>books =  new ArrayList<Book>();
		System.out.println();
		try {
            Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Author author = new Author(
                      rs.getInt(20),
                      rs.getString(21),
						rs.getString(22),
						rs.getString(23)
						);
				  Shelves shelves=new Shelves(
						  rs.getInt(15),
	                      rs.getString(16),
	                      rs.getString(17)
						  );
				  BookCategory bookcate=new BookCategory (
						  rs.getInt(11),
	                      rs.getString(12)
						  );
				
				Book book = new Book(
						rs.getInt(1),
						author,
						shelves,
						bookcate,
						
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);
				books.add(book);
			}
			
			stmt.close();
			return books;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}



	public boolean addBook(Book b){
		
     boolean success = true;
      try {
    	
    	  conn.setAutoCommit(false);
    	  //Them vao bang shelves
    	  String shelf = b.getShelves().getShelf();
    	  String floor = b.getShelves().getFloor();
    	  
    	  String query = "insert into shelves(shelf, floor) values (?,?)";
    	  PreparedStatement ps = conn.prepareStatement(query);
    	  ps.setString(1, shelf);
    	  ps.setString(2, floor);
    	  int result = ps.executeUpdate();
    	  if(result<=0) {
    		  //Khong them duoc
    		  success = false;
    		  conn.rollback();
    	  }
    	  else {
    		  //Lay ID dong vua them
    	  }   	 
    	  
//    	//Them vao author
    	  String author_name = b.getAuthor().getAuthorName();
    	  
    	  String query2= "insert into authors(author_name) values (?)";
    	  PreparedStatement ps2 = conn.prepareStatement(query2);
    	  ps2.setString(1, author_name);
           int result2 = ps2.executeUpdate();
      if(result2<=0) {
    		  //Khong them duoc
    	 success = false;
    	 conn.rollback();
    	 }
    	 else {
    		  //Lay ID dong vua them
    	 }
    	  
    	  
    	  //Them vao bang book_cate
    	  String bookCateName = b.getBookcate().getBookCateName();
    	  String query3 = "insert into book_categories(book_cate_name) values (?)";
    	  PreparedStatement ps3 = conn.prepareStatement(query3);
    	  ps3.setString(1, bookCateName);
    	  int result3 = ps3.executeUpdate();
    	  if(result3<=0) {
    		  //Khong them duoc
    		  success = false;
    		  conn.rollback();
    	  }
    	  else {
    		  //Lay ID dong vua them
    	  }
    	  
    	  //them vao bang book
    	  int author_id = 1;
    	  int book_cate_id = 1; 
    	  int publication_house_id = 1;
    	  int shelf_id = 1;
    	  String book_name = b.getBookName();
    	  String publication_year = b.getPublicationYear();
    	  String status = b.getStatus();
    	  
    	  String query4 = "insert into books(author_id, book_cate_id, publication_house_id, shelf_id, book_name, publication_year, status, createdAt, updatedAt) "+
    	  "values (?,?,?,?,?,?,?,?,?)";
    	  
    	  PreparedStatement ps4 = conn.prepareStatement(query4);
    	 
    	  ps4.setInt(1, author_id);
    	  ps4.setInt(2, book_cate_id);
    	  ps4.setInt(3, publication_house_id);
    	  ps4.setInt(4, shelf_id);
    	  ps4.setString(5, book_name);
    	  ps4.setString(6, publication_year);
    	  ps4.setString(7, status);
    	  ps4.setString(8,"1999/1/1");
    	  ps4.setString(9, "1999/1/1");
    	  int result4 = ps4.executeUpdate();
    	  if(result4<=0) {
    		  //Khong them duoc
    		  success = false;
    		  conn.rollback();
    	  }
    	  else {
    		  //Them duoc
    		  conn.commit();
    	  }
    	  
    	  return success;
//    		 PreparedStatement pt =  DBConnection.conn.prepareStatement("INSERT INTO books(id,author_id,book_cate_id,publication_house_id,shelf_id,book_name,publication_year,status VALUES (?,?,?,?,?,?,?,?)");
//    		pt.setInt(1,b.getId());
//    	   b.setAuthor(null);
//    	    
//    		b.setShelves(null);
//    		b.setBookcate(null);
//    		pt.setString(5,b.getBookName());
//    		pt.setString(6,b.getPublicationYear());
//    		pt.setString(7,b.getStatus());
//    		
//    		
//    		
//    		
//         
//          
//          
//          return pt.executeUpdate() >0; 
	
	
      } catch (Exception e) {
              e.printStackTrace();
          }
          return false;

      }
	public boolean deleteBook(int id) 
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
	public boolean update(Book book)
	{
		String sql = "UPDATE books set bookname=?,publication_year=? "+" where id= ?"  ;
	 
		try {
			
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getPublicationYear());
			ps.setInt(3,book.getId());
			
			
			return ps.executeUpdate() > 0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	public List<Book> findBySearch(String textSearch)
	{
		List<Book> books =  new ArrayList<Book>();
		
		String sql = "SELECT * FROM books b, book_categories bc,shelves s,authors a WHERE b.id=bc.id AND b.id=s.id AND a.id=b.id AND b.book_name LIKE '%\"  + textSearch + \"%' ";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next())
			{
				Author author = new Author(
                      rs.getInt(20),
                      rs.getString(21),
						rs.getString(22),
						rs.getString(23)
						);
				  Shelves shelves=new Shelves(
						  rs.getInt(15),
	                      rs.getString(16),
	                      rs.getString(17)
						  );
				  BookCategory bookcate=new BookCategory (
						  rs.getInt(11),
	                      rs.getString(12)
						  );
				
				Book book = new Book(
						rs.getInt(1),
						author,
						shelves,
						bookcate,
						
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);
				books.add(book);
			}
			
			stmt.close();
			return books;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	}

	

	
	