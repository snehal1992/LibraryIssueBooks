package com.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import JDBCMapping.JDBCLoanMap;

public class BookResultsBO {
 
	String s;
	 public BookResultsBO(String s){
		 this.s=s;
	 }
	 public void availability(String set, String  list) throws SQLException{
	    
		    boolean bool=false;
		    if(list==null){
		    	bool=false;
		    }
		    else{
		    	bool=true;
		    }
			 if(bool){
				 JDBCLoanMap.available.put(set,false);
			 }
			 else{
				 JDBCLoanMap.available.put(set,true);
			 }
		  }
	
	 public boolean isISBN(){
		 int op1;
		 try {
			    op1 = Integer.parseInt(s);
			    return true;
			} catch (NumberFormatException e) {
			    System.out.println("Wrong number");
			    op1 = 0;
			    return false;
			}
		 
	 }
	 
	
}
