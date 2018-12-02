package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository extends Repository {

	public int count() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS Total FROM Product");
			if (rs.next()) {
				return rs.getInt("Total");
			}
			return 0;
		} finally {
			close();
		}
	}

	private static Product fetch(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"), rs.getInt("PublisherId"),
				rs.getInt("AuthorId"), rs.getString("Title"), rs.getString("ISBN"), rs.getShort("Pages"),
				rs.getShort("Year"), rs.getString("Weight"), rs.getString("Size"), rs.getString("Description"),
				rs.getString("Content"), rs.getString("ImageUrl"), rs.getInt("Price"));
	}

	public static List<Product> fetchAll(ResultSet rs) throws SQLException {
		List<Product> list = new LinkedList<>();
		while (rs.next()) {
			list.add(fetch(rs));
		}
		return list;
	}

	public List<Product> getProducts() throws SQLException {
		try {
			open();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Product");
			/*
			 * List<Product> list = new LinkedList<>(); while (rs.next()) {
			 * 
			 * Product obj = new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"),
			 * rs.getInt("PublisherId"), rs.getInt("AuthorId"), rs.getString("Title"),
			 * rs.getString("ISBN"), rs.getShort("Pages"), rs.getShort("Year"),
			 * rs.getString("Weight"), rs.getString("Size"), rs.getString("Description"),
			 * rs.getString("Content"), rs.getString("ImageUrl"), rs.getInt("Price"));
			 * list.add(obj); }
			 */
			List<Product> list = fetchAll(rs);
			return list;
		} finally {
			close();
		}
	}

	public List<Product> getProducts(int pageIndex, int pageSize) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product LIMIT ?, ?");
			pstmt.setInt(1, pageIndex);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			/*
			 * List<Product> list = new LinkedList<>(); while (rs.next()) {
			 * 
			 * Product obj = new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"),
			 * rs.getInt("PublisherId"), rs.getInt("AuthorId"), rs.getString("Title"),
			 * rs.getString("ISBN"), rs.getShort("Pages"), rs.getShort("Year"),
			 * rs.getString("Weight"), rs.getString("Size"), rs.getString("Description"),
			 * rs.getString("Content"), rs.getString("ImageUrl"), rs.getInt("Price"));
			 * list.add(obj); }
			 */
			List<Product> list = fetchAll(rs);
			return list;
		} finally {
			close();
		}
	}

	public Product getProduct(int id) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product WHERE ProductId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				/*
				 * Product obj = new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"),
				 * rs.getInt("PublisherId"), rs.getInt("AuthorId"), rs.getString("Title"),
				 * rs.getString("ISBN"), rs.getShort("Pages"), rs.getShort("Year"),
				 * rs.getString("Weight"), rs.getString("Size"), rs.getString("Description"),
				 * rs.getString("Content"), rs.getString("ImageUrl"), rs.getInt("Price"));
				 */
				Product obj = fetch(rs);
				return obj;
			}
			return null;
		} finally {
			close();
		}
	}

	public List<Product> search(String q) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product WHERE Title LIKE ?");
			pstmt.setString(1, "%" + q + "%");
			rs = pstmt.executeQuery();
			/*
			 * List<Product> list = new LinkedList<>(); while (rs.next()) { Product obj =
			 * new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"),
			 * rs.getInt("PublisherId"), rs.getInt("AuthorId"), rs.getString("Title"),
			 * rs.getString("ISBN"), rs.getShort("Pages"), rs.getShort("Year"),
			 * rs.getString("Weight"), rs.getString("Size"), rs.getString("Description"),
			 * rs.getString("Content"), rs.getString("ImageUrl"), rs.getInt("Price"));
			 * list.add(obj); }
			 */
			List<Product> list = fetchAll(rs);
			return list;
		} finally {
			close();
		}
	}

	public List<Product> getProducts(int id) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Product WHERE CategoryId = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			List<Product> list = fetchAll(rs);
			close();
			return list;
		} finally {
			close();
		}
	}

	public int add(Product obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement(
					"INSERT INTO Product(CategoryId, PublisherId, AuthorId, ISBN, Title, Pages, Year, Weight, Size, Description, Content, ImageUrl, Price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, obj.getCategoryId());
			pstmt.setInt(2, obj.getPublisherId());
			pstmt.setInt(3, obj.getAuthorId());
			pstmt.setString(4, obj.getIsbn());
			pstmt.setString(5, obj.getTitle());
			pstmt.setShort(6, obj.getPages());
			pstmt.setShort(7, obj.getYear());
			pstmt.setString(8, obj.getWeight());
			pstmt.setString(9, obj.getSize());
			pstmt.setString(10, obj.getDescription());
			pstmt.setString(11, obj.getContent());
			pstmt.setString(12, obj.getImageUrl());
			pstmt.setInt(13, obj.getPrice());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}

}
