package JDBCMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.Connections;

public class JdbcAvailability {

	public String Notavailibile(String isbn) throws SQLException{
		
		Connections s=new Connections();
		Connection c=s.getConnection();
		String s1=null;
		String query="select distinct isbn from book_loans  where isbn=? AND isNULL(date_in)";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setString(1, isbn);
		ResultSet set=stmt.executeQuery();
		while(set.next()){
			 s1=set.getString(1);
		}
		System.out.println(s1);
		//c.close();
		return s1;
	}
}
