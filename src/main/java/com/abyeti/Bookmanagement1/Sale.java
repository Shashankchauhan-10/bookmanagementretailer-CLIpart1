package com.abyeti.Bookmanagement1;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale", catalog = "bookmanagementdb")
public class Sale implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer saleid;
	private long isbn;
	private Integer userid;
	private Integer quantity;
	private Date date;

	public Sale() {
	}
	public Sale(long isbn,Integer userid,Integer quantity) {
		this.isbn=isbn;
		this.userid=userid;
		this.quantity=quantity;
		this.date= new Date();
	}

	@Id	@GeneratedValue
	@Column(name = "saleid", unique = true, nullable = false)
	public Integer getSaleid() {
		return saleid;
	}
	public void setSaleid(Integer saleid) {
		this.saleid = saleid;
	}

	@Column(name = "isbn")
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "userid")
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
