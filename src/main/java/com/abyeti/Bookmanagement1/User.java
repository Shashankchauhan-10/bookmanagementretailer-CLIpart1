package com.abyeti.Bookmanagement1;
import javax.persistence.*;

@Entity
@Table(name = "user", catalog = "bookmanagementdb")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userid;
	private String username;
	private long mobile;
	private boolean admin;

	public User() {
	}

	public User(String username,long mobile) {
		this.username=username;
		this.mobile=mobile;
		this.admin=false;
	}

	@Id	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "mobile")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Column(name = "admin")
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
