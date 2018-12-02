package model;

import java.sql.SQLException;

import model.Member;
import util.Helper;

public class MemberRepository extends Repository {

	public int add(Member obj) {
		String sql = "INSERT INTO Member(MemberId, Username, Password, FullName, Email, Gender) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			open();
			pstmt = connection.prepareStatement(sql);
			// pstmt.setLong(1,Helper.randomLong());
			pstmt.setLong(1, obj.getId());
			pstmt.setString(2, obj.getUsername());
			pstmt.setBytes(3, Helper.hash(obj.getPassword()));
			pstmt.setString(4, obj.getFullname());
			pstmt.setString(5, obj.getEmail());
			pstmt.setByte(6, obj.getGender());
			int ret = pstmt.executeUpdate();
			close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int logOn(Member obj) throws SQLException {
		try {
			open();
			pstmt = connection
					.prepareStatement("SELECT MemberId,Email FROM Member WHERE Username = ? AND Password = ?");
			pstmt.setString(1, obj.getUsername());
			pstmt.setBytes(2, Helper.hash(obj.getPassword()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				obj.setId(rs.getLong("MemberId"));
				obj.setEmail(rs.getString("Email"));
				return 1;
			}
			close();
		} finally {
			close();
		}
		return 0;
	}
}
