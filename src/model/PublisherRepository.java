package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PublisherRepository extends Repository {
	public List<Publisher> getPublishers() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM publisher");
			List<Publisher> list = new LinkedList<Publisher>();
			while (rs.next()) {
				list.add(new Publisher(rs.getInt("PublisherId"), rs.getString("PublisherName")));
			}
			return list;
		} finally {
			close();
		}
	}

	public int add(Publisher obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("INSERT INTO Publisher(PublisherName) VALUES(?)");
			pstmt.setString(1, obj.getName());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

	public int delete(int id) {
		try {
			open();
			pstmt = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
			pstmt.setInt(1, id);
			int ret = pstmt.executeUpdate();

			close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public Publisher getPublisher(int id) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Publisher WHERE PublisherId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Publisher(rs.getInt("PublisherId"), rs.getString("PublisherName"));
			}
			return null;
		} finally {
			close();
		}
	}

	public int edit(Publisher obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("UPDATE Publisher SET PublisherName = ? WHERE PublisherId = ?");
			pstmt.setString(1, obj.getName());
			pstmt.setInt(2, obj.getId());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

	public int[] delete(List<Integer> list) {

		try {
			open();
			pstmt = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
			for (Integer id : list) {
				pstmt.setInt(1, id);
				pstmt.addBatch();
			}

			int[] ret = pstmt.executeBatch();
			close();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
