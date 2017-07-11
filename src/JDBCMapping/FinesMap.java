package JDBCMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Connections;
import com.DAO.Fines;
import com.DAO.book_loans;

public class FinesMap {

	public ResultSet fine(int cardid) throws SQLException{
		
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select * from fines join book_loans where card_id=?";
		PreparedStatement stmt=c.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		//c.close();
		return set;
	}
	public void setFine(Fines f) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="update fines set loan_id=? , fine_amt=?, paid=false ";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, f.getLoanid());
		stmt.setDouble(2, f.getFine_amount());
		stmt.executeQuery();
		//c.close();
	}
	public void payFine(int loanid) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="delete from fines where loan_id=?";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, loanid);
		stmt.executeQuery();
		//c.close();
	}
	public boolean finePresent(int loanid) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select * from fines where loan_id=?";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, loanid);
		ResultSet set=stmt.executeQuery();
	    while(set.next()){
	    	boolean b=set.getBoolean(3);
	    	if(b){
	    		return false;
	    	}
	    	else{
	    		return true;
	    	}
	    }
	    //c.close();
	    return false;
		
	}
}
