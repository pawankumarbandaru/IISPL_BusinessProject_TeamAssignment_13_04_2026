package com.iispl.repository;

import java.util.List;

import com.iispl.entity.Account;

public interface BankOperations {
	public void storeAcc(Account account);
	public List<Account> retrieveAcc();
	public void updateAcc();
	public void deleteAcc();
	
	public void storeTxn();
	public void retrieveTxn();
	public void updateTxn();
	public void deleteTxn();
}
