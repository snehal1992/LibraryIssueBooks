package JDBCMapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DAO.Connections;
import com.DAO.book_loans;

public class JDBCLoanMap {
	
	public static Map<String, Boolean> available=new HashMap<String , Boolean>();

	public int maxLoanId() throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select max(laon_id) from book_loans?";
		PreparedStatement stmt=c.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		//c.close();
		set.next();
		return set.getInt(1);
	}
	public ResultSet isbn() throws SQLException{
		
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select isbn from book_loans where isNULL(date_in) ";
		PreparedStatement stmt=c.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		//c.close();
		return set;
		
	}
public ResultSet loans(int cardid) throws SQLException{
		
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select * from book_loans where cardid=? ";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, cardid);
		ResultSet set=stmt.executeQuery();
		//c.close();
		return set;
		
	}
public void setLoan(book_loans b ) throws SQLException{
	Connections s=new Connections();
	Connection c=s.getConnection();
	String query="update book_loans set loan_id=? , isbn=?, cardid=? , date_out=? , due_date=? ";
	PreparedStatement stmt=c.prepareStatement(query);
	stmt.setInt(1, b.getLoanid());
	stmt.setString(2, b.getIsbn());
	stmt.setInt(3, b.getCardid());
	stmt.setDate(4,b.getDate_out());
	stmt.setDate(5,b.getDue_date());
	stmt.executeQuery();
	available.put(b.getIsbn(),false);
	//c.close();
}
public ResultSet getLoanID(int cardid) throws SQLException{
	Connections s=new Connections();
	Connection c=s.getConnection();
	String query="select loan_id from book_loans where card_id=?";
	PreparedStatement stmt=c.prepareStatement(query);
	stmt.setInt(1, cardid);
	ResultSet set=stmt.executeQuery();
	//c.close();
	return set;
}
public   ResultSet diff(int cardid) throws SQLException{
	Connections s=new Connections();
	Connection c=s.getConnection();
	String query="select datediff(due_date, date_out) ,loan_id from book_loans where card_id=?";
	PreparedStatement stmt=c.prepareStatement(query);
	stmt.setInt(1, cardid);
	ResultSet set=stmt.executeQuery();
	//c.close();
	return set;
}
public void checkin(int loanid) throws SQLException{
	Connections s=new Connections();
	Connection c=s.getConnection();
	String query="delete from book_loans where loan_id=?";
	String query1="select isbn from book_loans where loan_id=?";
	PreparedStatement stmt=c.prepareStatement(query1);
	stmt.setInt(1, loanid);
	ResultSet set=stmt.executeQuery();
	set.next();
	String isbn=set.getString(1);
	available.put(isbn, true);
	stmt=c.prepareStatement(query);
	stmt.setInt(1, loanid);
	stmt.executeQuery();
	//c.close();
}
}
