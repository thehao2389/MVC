package model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private long id;
	private Long memberId;
	private String tel;
	private String address;
	private String email;
	private Date date;
	private short statusId;
	private String statusName;

	private List<InvoiceDetail> details;

	public Invoice(long id, Long memberId, String tel, String address, String email, Date date, short statusId) {
		this.id = id;
		this.memberId = memberId;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.date = date;
		this.statusId = statusId;
	}
	
	

	public String getStatusName() {
		return statusName;
	}



	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}



	public Invoice(long id, Long memberId, String tel, String address, String email, Date date, short statusId,
			String statusName) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.date = date;
		this.statusId = statusId;
		this.statusName = statusName;
	}



	public Invoice(long id, Long memberId, String tel, String address, String email, short statusId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.statusId = statusId;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public short getStatusId() {
		return statusId;
	}

	public void setStatusId(short statusId) {
		this.statusId = statusId;
	}

	public List<InvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}

}
