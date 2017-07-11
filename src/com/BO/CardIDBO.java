package com.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCMapping.CardIDMap;

public class CardIDBO {

	public boolean isValid(int card) throws SQLException{
		
		CardIDMap m=new CardIDMap();
		ResultSet s=m.SampleCard(card);
		if(s.next()==false){
			return false;
		}
		else{
			return true;
		}
	}
}
