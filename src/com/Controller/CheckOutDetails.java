package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BO.EligibilityBO;
import com.DAO.Connections;
import com.DAO.book_loans;

import JDBCMapping.JDBCLoanMap;

public class CheckOutDetails {
	
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
             
      HttpSession s=request.getSession();
      String isbn=(String) s.getAttribute("Book");
      int card=Integer.parseInt(request.getParameter("CARDID"));
	  EligibilityBO b= new EligibilityBO();
	  boolean b1=b.isEligible(card);
	  if(b1){
		  DateFormat dateFormatYMD = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  JDBCLoanMap loan=new JDBCLoanMap();
		  int loanid=loan.maxLoanId()+1;
		  book_loans book1=new book_loans();
		  book1.setCardid(card);
		  book1.setIsbn(isbn);
		  book1.setLoanid(loanid);
		  java.sql.Date date = new java.sql.Date(0000-00-00);
		  book1.set(Date_out());
		  book1.setDate_out(due_date);
		  book1.setDate_in(null);
		  loan.setLoan(b);
	  }
	  else{
		  Connections s1 =new Connections();
		  Connection c=s1.getConnection();
		  String query ="select * from book_loans b outer join fines f on b.loan_id=f.loan_id and card_id=?";
		  PreparedStatement stmt=c.prepareStatement(query);
		  stmt.setInt(1, card);
		  ResultSet set=stmt.executeQuery();
		  // display on a web page ;
 }
	  }
}
