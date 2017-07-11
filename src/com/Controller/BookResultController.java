package com.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.oxm.xstream.CatchAllConverter;

import com.BO.BookResultsBO;
import com.DAO.SearchBean;

import JDBCMapping.BookResultsMap;
import JDBCMapping.JDBCLoanMap;
import JDBCMapping.JdbcAvailability;

public class BookResultController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		System.out.println("hello");
		String search=(String) request.getParameter("FindaBook");
		BookResultsBO b1=new BookResultsBO(search);
		boolean isbn=b1.isISBN();
		BookResultsMap m=new BookResultsMap(); 
		ResultSet set;
		try{
		if(isbn==true){// check whether search variable is string or isbn
			System.out.println("inside isbn");
			int searches=Integer.parseInt(search);
			double s=(double)searches;
			set=m.Books(s);
		}
		else{
			
			System.out.println("hello5");
			set=m.Books(search);
		}
		// availability of isbns
		System.out.println("hello7");
		JdbcAvailability av=new JdbcAvailability();
		String lists=null;
		System.out.println("hello9");
		while(set.next()){// check availability
			System.out.println("hello3");
			String isbnCheck =set.getString(1);
			System.out.println(isbnCheck);
			lists=av.Notavailibile(isbnCheck);
			
			System.out.println(lists);
			BookResultsBO b=new BookResultsBO("hi");
			b.availability(isbnCheck, lists);
			System.out.println("hello3");
			
		}
		
		// add data to results for display
		
		           set.beforeFirst();
		            List<SearchBean> list= new ArrayList<>();
		            SearchBean b=new SearchBean();
		            System.out.println("hello2");
					while(set.next()){// add resultset into list
						String isbns=set.getString(1);
					    b.setIsbn(set.getString(1));
						b.setFname(set.getString(3));
						b.setLname(set.getString(4));
						b.setTitle(set.getString(2));
						b.setAvailable(JDBCLoanMap.available.get(isbns));
						list.add(b); 
					}
					System.out.println(list);
					request.setAttribute("BookResults", list);
					RequestDispatcher rd = request.getRequestDispatcher("/BookResults.jsp");
					rd.forward(request, response);
			} 
	catch(SQLException s){
		
	}
	}

}