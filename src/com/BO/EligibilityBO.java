package com.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCMapping.CardIDMap;
import JDBCMapping.FinesMap;
import JDBCMapping.JDBCLoanMap;

public class EligibilityBO {

	public boolean isEligible(int cardid) throws SQLException{
		CardIDMap book=new CardIDMap();
		int c=book.BookIssued(cardid);
		if(c==3){
			return false;
			//display page where heckout to check in
		}
		else{
			// check due_date- date_out >1
			//if fine exists generate fine and add to fine table 
			FinesBo f =new FinesBo();
			boolean b=f.CalculateFine(cardid);
			if(b){
				return false;
			}
			else{
				return true;
			}
		}
	}
}
