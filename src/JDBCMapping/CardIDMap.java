package JDBCMapping;

import com.DAO.Connections;
import java.sql.*;
public class CardIDMap {

	public ResultSet SampleCard(int cardId) throws SQLException{
		 
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select card_id from borrower where card_id=?";
		PreparedStatement stmt=c.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		//c.close();
		return set;
	}
	public int assignCardID() throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select max(card_id) from borrower ";
		PreparedStatement stmt=c.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		set.next();
		int max=0;
		try {
		max=set.getInt(1);
		}
		catch(NullPointerException e){
			max=0;
		}
		//c.close();
		return max;
	}
	public int BookIssued(int cardid) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="select count(card_id) from book_loans where card_id=?";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, cardid);
		ResultSet set=stmt.executeQuery();
		set.next();
		int count=set.getInt(1);
		//c.close();
		return count;
	}
}
