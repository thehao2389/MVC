package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategoryRepository extends Repository {
	public List<Category> getCategories() {

		try {
			open();
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT Child.CategoryId,Child.CategoryName,Child.ParentId,Parent.CategoryName AS ParentName FROM Category AS Parent RIGHT JOIN Category AS Child ON Child.ParentId=Parent.CategoryId");
			
			
			List<Category> list = new LinkedList<>();
			while (rs.next()) {
				Category obj = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"), rs.getString("ParentName"));
				list.add(obj);
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public List<Category> getCategories2() {

		try {
			open();
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM Category");
			
			
			List<Category> list = new LinkedList<>();
			while (rs.next()) {
				list.add(fetch(rs));
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public List<Category> getParents() {

		try {
			open();
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM Category WHERE ParentID IS NULL");
		
			List<Category> list = new LinkedList<>();
			while (rs.next()) {
				list.add(fetch(rs));
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public int add(Category obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("INSERT INTO Category(CategoryName,ParentID) VALUES(?,?)");
			pstmt.setString(1, obj.getName());
			pstmt.setInt(2, obj.getParentId());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}
	
	private static Category fetch(ResultSet rs) throws SQLException {
		return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
	}
	public Category getCategory(int id) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Category WHERE CategoryId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Category obj = null;
			if(rs.next()) {
				obj = fetch(rs);
			}
			return obj;
		} finally {
			close();
		}
	}
}
