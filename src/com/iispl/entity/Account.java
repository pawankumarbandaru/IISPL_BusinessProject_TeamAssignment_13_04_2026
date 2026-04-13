package com.iispl.entity;

import com.iispl.enums.AccountStatus;
import com.iispl.enums.AccountType;

public class Account {
	private  String accountNumber;
	private String holderName;
	private AccountType accountType;
	private long balance;
	private AccountStatus AccountStatus;
	public Account(String accountNumber, String holderName, AccountType accountType, long balance, AccountStatus activeStatus) {
		super();
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.accountType = accountType;
		this.balance = balance;
		this.AccountStatus = activeStatus;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public AccountStatus getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		AccountStatus = accountStatus;
	}

	

}
