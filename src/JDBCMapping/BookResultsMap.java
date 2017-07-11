package JDBCMapping;

import java.sql.*;
import com.DAO.Connections;

public class BookResultsMap {
	
	public ResultSet Books(double base) throws SQLException{
		
		Connections s=new Connections();
		Connection n=s.getConnection();
		String query;
		String base1=String.valueOf(base);
	    query="select b1.isbn , title , fname ,lname from book_authors b join author a join book b1 where b1.isbn=? and b1.isbn=b.isbn and a.author_id=b.author_id";
	    PreparedStatement stmt=n.prepareStatement(query);
		stmt.setString(1, base1);
		ResultSet set=stmt.executeQuery();
	    //n.close();
		return set; 
		
	}
		public ResultSet Books(String base) throws SQLException{
			Connections s=new Connections();
			Connection n=s.getConnection();
			System.out.println(base);
			String query="select b1.isbn , title , fname , lname from book_authors b join authors a join book b1 where fname like ?  OR title like ? and b1.isbn=b.isbn and a.author_id=b.author_id";
			PreparedStatement stmt=n.prepareStatement(query);
			stmt.setString(1, "%"+base+"%");
			stmt.setString(2, "%"+base+"%");
			ResultSet set =stmt.executeQuery();
			//n.close();
			return set;
		}
		
	}

