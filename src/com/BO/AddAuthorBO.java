package com.BO;

import java.sql.SQLException;

import com.DAO.Authors;
import com.DAO.Book;

import JDBCMapping.AuthorMap;
import JDBCMapping.BookMap;

public class AddAuthorBO {

public void addAuthor(String author) throws SQLException{
		
		Authors a=new Authors();
		AuthorMap m= new AuthorMap();
		int authorid=m.maxAuthorID()+1;
		a.setFname(author);
		a.setAuthorid(authorid);
		m.addAuthor(a);
	}
}
