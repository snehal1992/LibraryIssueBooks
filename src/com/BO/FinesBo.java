package com.BO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Fines;

import JDBCMapping.FinesMap;
import JDBCMapping.JDBCLoanMap;

public class FinesBo {

	public boolean CalculateFine(int cardid) throws SQLException{
		JDBCLoanMap n=new JDBCLoanMap();
		FinesMap m=new FinesMap();
		ResultSet s=n.diff(cardid);
		int flag=0;
		double fines;
		while(s.next()){
			int n1=s.getInt(1);
			int loanid=s.getInt(2);
			boolean present =m.finePresent(loanid);
			if(present){
				flag=1;
				continue;
			}
			else{
			if(n1>14){
				fines=0.25*(n1-14);
				Fines f=new Fines();
				f.setLoanid(s.getInt(2));
				f.setFine_amount(fines);
				f.setPaid(false);
				FinesMap map=new FinesMap();
				map.setFine(f);
				flag=1;
			}
		}
		}
		if(flag==1){
			return true;
		}
		else{
			return false;
		}
	
	}
	
}
