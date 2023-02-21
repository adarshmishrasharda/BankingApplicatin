package com.user.customer_management_service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	
	@Id
	private String id;
	private String name;
	private String phone;
	@Transient
	private account Account;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String name, String phone, account account) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		Account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public account getAccount() {
		return Account;
	}
	public void setAccount(account account) {
		Account = account;
	}
	
}