package model;

public class Category implements Entity {
	private int id;
	private String name;
	private Integer parentId;
	private String parentName;
	
	
	public Category(int id, String name, Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}
	
	public Category(int id, String name, Integer parentId, String parentName) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.parentName = parentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	
}
