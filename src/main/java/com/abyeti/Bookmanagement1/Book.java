package com.abyeti.Bookmanagement1;
import javax.persistence.*;
import java.util.Scanner;

@Entity
@Table(name = "book", catalog = "bookmanagementdb")
public class Book implements java.io.Serializable {

	public static Scanner scan = new Scanner(System.in);
	private static final long serialVersionUID = 1L;

	private long isbn;
	private String bkname;
	private Integer authorid;
	private String edition;
	private Integer price;
	private Integer available_units;

	public Book(){}
	public Book(long isbn,String bkname, Integer authorid,String edition,Integer price,Integer available_units) {
		this.isbn=isbn;
		this.bkname = bkname;
		this.authorid = authorid;
		this.edition=edition;
		this.price=price;
		this.available_units=available_units;
	}

	@Id
	@Column(name = "isbn")
	public long getisbn() {
		return this.isbn;
	}
	public void setisbn(long isbn) {
		this.isbn = isbn;
	}

	@Column(name = "bkname")
	public String getbkname() {
		return this.bkname;
	}
	public void setbkname(String bkname) {
		this.bkname = bkname;
	}

	@Column(name = "authorid")
	public Integer getauthorid() {
		return this.authorid;
	}
	public void setauthorid(Integer authorid) {
		this.authorid = authorid;
	}

	@Column(name = "edition")
	public String getedition() {
		return edition;
	}
	public void setedition(String edition) {
		this.edition = edition;
	}

	@Column(name = "price")
	public Integer getprice() {
		return price;
	}
	public void setprice(Integer price) {
		this.price = price;
	}

	@Column(name = "available_units")
	public Integer getavailable_units() {
		return this.available_units;
	}
	public void setavailable_units(Integer available_units) {
		this.available_units = available_units;
	}
}
