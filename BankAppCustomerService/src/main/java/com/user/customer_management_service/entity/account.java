package com.user.customer_management_service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class account {
	
	@Id
	private Integer acc_id;
	private String Name;
	private long Balance;
	@Transient
	private Customer customer;
	public Integer getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getBalance() {
		return Balance;
	}
	public void setBalance(long balance) {
		Balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public account(Integer acc_id, String name, long balance, Customer customer) {
		super();
		this.acc_id = acc_id;
		Name = name;
		Balance = balance;
		this.customer = customer;
	}
	public account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}