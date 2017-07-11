package JDBCMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DAO.Authors;
import com.DAO.Book_Authors;
import com.DAO.Connections;

public class Book_AuthorsMap {
	public void add(Book_Authors a) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="insert into authors values(?,?) ";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setInt(1, a.getAuthor_id());
		stmt.setString(2, a.getIsbn());
		stmt.executeUpdate();
		c.close();
	}
}
