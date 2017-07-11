package com.BO;

import java.sql.SQLException;

import com.DAO.Book;

import JDBCMapping.BookMap;

public class AddBookBO {

	public void addBook(String book,String isbn) throws SQLException{
		
		Book b=new Book();
		b.setIsbn(isbn);
		b.setTitle(book);
		BookMap m=new BookMap();
		m.addBook(b);
	}
}
