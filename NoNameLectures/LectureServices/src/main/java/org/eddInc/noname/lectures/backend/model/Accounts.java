package org.eddInc.noname.lectures.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_ID",unique=true,nullable=false)
	private int accountId;
	
	@Column(name="ACCOUNT_NAME",nullable=false)
	private String accountName;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="EMAIL",nullable=false,unique=true)
	private String email;
	
	@Column(name="PASSWORD",nullable=false,unique=false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID_FK",referencedColumnName="ROLE_ID")
	private Roles role;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	
	
	
	

}
