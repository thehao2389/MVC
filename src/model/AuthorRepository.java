package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthorRepository extends Repository{
	public List<Author> getAuthors() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Author");
			List<Author> list = new LinkedList<Author>();
			while (rs.next()) {
				list.add(new Author(rs.getInt("AuthorId"), rs.getString("AuthorName")));
			}
			return list;
		} finally {
			close();
		}
	}
}
