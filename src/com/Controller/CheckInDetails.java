package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BO.EligibilityBO;
import com.DAO.Connections;
import com.DAO.DisplayBean;

public class CheckInDetails {

	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
             
      HttpSession s=request.getSession();
      int card =(int) s.getAttribute("card");
      EligibilityBO b= new EligibilityBO();
	  boolean b1=b.isEligible(card);
	  Connections s1 =new Connections();
	  Connection c=s1.getConnection();
	  String query ="select * from book_loans b join fines f on  b.loan_id=f.loan_id where card_id=? and isNull(date_in)";
	  PreparedStatement stmt=c.prepareStatement(query);
	  stmt.setInt(1, card);
	  ResultSet set=stmt.executeQuery();
	  //display the fines table and loan  checkout button on each
	  // if button clicked on jsp page update the date_in  and paid=true thru jsp page
	  DisplayBean bean=new  DisplayBean();
	  List<DisplayBean> dis=new ArrayList<DisplayBean>();
	  while(set.next()){
		  bean.setLoanid(loanid);
		  bean.setCardid(set.getInt(3));
		  bean.setDate_in(date_in);
		  bean.setDate_out(date_out);
		  bean.setIsbn();
		  bean.setDue_date();
		  bean.setAmt();
		  dis.add(b);
	  }
	  request.setAttribute("CheckInBooks", dis);
		RequestDispatcher rd = request.getRequestDispatcher("/CheckInBooks.jsp");
		rd.forward(request, response);
}
}
