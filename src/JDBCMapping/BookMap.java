package JDBCMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DAO.Authors;
import com.DAO.Book;
import com.DAO.Connections;

public class BookMap {
	public void addBook(Book a) throws SQLException{
		Connections s=new Connections();
		Connection c=s.getConnection();
		String query="insert into book values(?,?) ";
		PreparedStatement stmt=c.prepareStatement(query);
		stmt.setString(1, a.getTitle());
		stmt.setString(2, a.getIsbn());
		stmt.executeUpdate();
		c.close();
	}
	
}
