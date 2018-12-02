package model;

public class InvoiceDetail {
	private long invoiceId;
	private int productId;
	
	private short quantity;
	private int price;
	private String title;
	private String imageUrl;

	

	public InvoiceDetail(long invoiceId, int productId, short quantity, int price) {
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public InvoiceDetail(long invoiceId, int productId, short quantity, int price, String title, String imageUrl) {
		super();
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		this.imageUrl = imageUrl;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getId() {
		return invoiceId;
	}

	public void setId(long id) {
		this.invoiceId = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
