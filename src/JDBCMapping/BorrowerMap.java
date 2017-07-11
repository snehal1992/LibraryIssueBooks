package JDBCMapping;

import com.DAO.Borrower;
import com.DAO.Connections;

import java.sql.*;
public class BorrowerMap {
public boolean BorrowerMap1(Borrower b) throws SQLException{
	Connections s=new Connections();	
	Connection c=null;
	c=s.getConnection();
	String query="insert into borrower values (?,?,?,?,?,?);";
	PreparedStatement prep=c.prepareStatement(query);
	prep.setInt(1,b.getCard_id());
	prep.setInt(2, b.getSsn());
	prep.setString(3, b.getFname());
	prep.setString(4, b.getLname());
	prep.setString(5, b.getAddress());
	prep.setString(6, b.getPhone());
    prep.executeUpdate();
    //c.close();
		return true ;
		
	}

}
