package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InvoiceRepository extends Repository {

	public Invoice getInvoice(long id) {

		try {
			open();
			pstmt = connection.prepareStatement("SELECT * FROM Invoice INNER JOIN Status ON Invoice.StatusId=Status.StatusId WHERE InvoiceId=?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			Invoice obj = null;
			if (rs.next()) {
				/*obj = new Invoice(rs.getLong("InvoiceId"), rs.getLong("MemberId"), rs.getString("Tel"),
						rs.getString("Address"), rs.getString("Email"), rs.getShort("StatusId"));*/
				obj = new Invoice(rs.getLong("InvoiceId"), rs.getLong("MemberId"), rs.getString("Tel"), rs.getString("Address"),rs.getString("Email"), rs.getDate("AddedDate"), rs.getShort("StatusId"), rs.getString("StatusName"));
			}

			obj.setDetails(getInvoiceDetails(id));
			close();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private List<InvoiceDetail> getInvoiceDetails(long id) throws SQLException {
		String sql = "SELECT * FROM InvoiceDetail INNER JOIN Product ON InvoiceDetail.ProductId =Product.ProductId WHERE InvoiceId=?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, id);
		rs = pstmt.executeQuery();
		List<InvoiceDetail> list = new LinkedList<>();
		while (rs.next()) {
			InvoiceDetail obj = new InvoiceDetail(rs.getLong("InvoiceId"), rs.getInt("ProductId"),
					rs.getShort("Quantity"), rs.getInt("Price"), rs.getString("Title"), rs.getString("ImageUrl"));
			list.add(obj);
		}
		return list;
	}

	public int add(Invoice obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement(
					"INSERT INTO Invoice(InvoiceId, MemberId, Email, Tel, Address,StatusId) VALUES(?,?, ?, ?, ?, ?)");
			pstmt.setLong(1, obj.getId());
			pstmt.setObject(2, obj.getMemberId());
			pstmt.setString(3, obj.getEmail());
			pstmt.setString(4, obj.getTel());
			pstmt.setString(5, obj.getAddress());
			pstmt.setShort(6, obj.getStatusId());
			int ret = pstmt.executeUpdate();
			pstmt.close();
			add(obj.getDetails());
			return ret;
		} finally {
			close();
		}
	}

	private int[] add(List<InvoiceDetail> list) throws SQLException {
		pstmt = connection.prepareStatement(
				"INSERT INTO InvoiceDetail(InvoiceId, ProductId, Quantity, Price) VALUES(?, ?, ?, ?)");
		for (InvoiceDetail obj : list) {
			pstmt.setLong(1, obj.getInvoiceId());
			pstmt.setInt(2, obj.getProductId());
			pstmt.setShort(3, obj.getQuantity());
			pstmt.setInt(4, obj.getPrice());
			pstmt.addBatch();
		}
		int[] ret = pstmt.executeBatch();
		return ret;
	}
}
