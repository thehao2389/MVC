package model;

public class Product {
	private int id;	
	private int categoryId;
	private int publisherId;
	private int authorId;
	private String title;
	private String isbn;
	private short pages;
	private short year;
	private String weight;
	private String size;
	private String description;
	private String content;
	private String imageUrl;
	private int price;
	
	public Product(int id, int categoryId, int publisherId, int authorId, String title, String isbn, short pages,
			short year, String weight, String size, String description, String content, String imageUrl, int price) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.publisherId = publisherId;
		this.authorId = authorId;
		this.title = title;
		this.isbn = isbn;
		this.pages = pages;
		this.year = year;
		this.weight = weight;
		this.size = size;
		this.description = description;
		this.content = content;
		this.imageUrl = imageUrl;
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public short getPages() {
		return pages;
	}
	public void setPages(short pages) {
		this.pages = pages;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
