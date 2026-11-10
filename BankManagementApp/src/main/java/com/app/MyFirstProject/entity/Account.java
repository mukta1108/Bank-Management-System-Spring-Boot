package com.app.MyFirstProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long account_No;
	@Column
    private String account_holder_name;
	@Column
    private double account_balance;
	public Account() {
		
	}
	
	
	public Account(String account_holder_name, double account_balance) {
		super();
		this.account_holder_name = account_holder_name;
		this.account_balance = account_balance;
	}


	public long getAccount_No() {
		return account_No;
	}
	public void setAccount_No(long account_No) {
		this.account_No = account_No;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	@Override
	public String toString() {
		return "Account [account_No=" + account_No + ", account_holder_name=" + account_holder_name
				+ ", account_balance=" + account_balance + "]";
	}
	
}
