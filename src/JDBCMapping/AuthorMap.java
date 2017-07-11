package JDBCMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Authors;
import com.DAO.Connections;

public class AuthorMap {

	public int  maxAuthorID() throws SQLException{
	Connections s=new Connections();
	Connection c=s.getConnection();
	String query="select max(card_id) from borrowers ";
	PreparedStatement stmt=c.prepareStatement(query);
	ResultSet set=stmt.executeQuery();
	if(set.next()==false){
		return 1;
	}
	int max=set.getInt(1);
	c.close();
	return max;
	}
	public void addAuthor(Authors a) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="insert into authors values(?,?,?) ";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, a.getAuthorid());
		stmt.setString(2, a.getFname());
		stmt.setString(3, a.getLname());
		stmt.executeUpdate();
		c.close();
	}
}
