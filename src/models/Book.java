package models;


public class Book {
    int id;
   // int authorId;
    Author author;
    Shelves shelves;
    BookCategory bookcate;
   // int bookCateId;
    int publicationHouseId;
   // int shelfId;
    String bookName;
    String publicationYear;
    String status;
    
    
    
    public Book(int id, Author author ,   Shelves shelves,  BookCategory bookcate,int publicationHouseId,String bookName, String publicationYear, String status) {
    	this.id = id;
    	this.author = author;
    	this.shelves = shelves;
    	this.bookcate = bookcate;
        this.publicationHouseId=publicationHouseId;
        this.bookName = bookName;
        this.publicationYear = publicationYear;
        this.status = status;
        
       
    }

   



	public Book() {
		// TODO Auto-generated constructor stub
	}





	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Shelves getShelves() {
		return shelves;
	}

	public void setShelves(Shelves shelves) {
		this.shelves = shelves;
	}

	public BookCategory getBookcate() {
		return bookcate;
	}

	public void setBookcate(BookCategory bookcate) {
		this.bookcate = bookcate;
	}

	public int getId() {
        return id;
    }

    
   

 

    public int getPublicationHouseId() {
		return publicationHouseId;
	}





	public void setPublicationHouseId(int publicationHouseId) {
		this.publicationHouseId = publicationHouseId;
	}









	public void setBookName(String bookName) {
		this.bookName = bookName;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getBookName() {
        return bookName;
    }

   

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
