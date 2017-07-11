package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

import com.DAO.Borrower;
import com.DAO.Connections;

import JDBCMapping.BorrowerMap;
import JDBCMapping.CardIDMap;

@WebServlet("/BorrowerController")
public class BorrowerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BorrowerController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		Borrower b=new Borrower();
		CardIDMap map=new CardIDMap();
		int cardid=0;
		try {
			cardid = map.assignCardID()+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ssn1=request.getParameter("SSN");
		int ssn =Integer.parseInt(ssn1);
	    String fname=(String) request.getParameter("Fname");
	    String lname=(String) request.getParameter("Lname");
	    String addr=(String) request.getParameter("Address");
		String phone=(String) request.getParameter("phone");
		b.setCard_id((cardid));
		b.setSsn((ssn));
		b.setFname((fname));
		b.setLname((lname));
		b.setAddress((addr));
		b.setPhone((phone));
	    BorrowerMap m=new BorrowerMap();
	    try {
			boolean bool=m.BorrowerMap1(b);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println();
	
	RequestDispatcher rd = request.getRequestDispatcher("/BookSearch.jsp");
	rd.forward(request, response);
	}
}
