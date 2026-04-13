
package com.iispl.repository;

import java.util.List;

import com.iispl.entity.Account;
import com.iispl.entity.Transaction;

public interface BankOperations {
	public void storeAcc(Account account);
	public List<Account> retrieveAcc();
	public void updateAcc();
	public void deleteAcc();
	
	public void storeTxn(Transaction transaction);
    public List<Transaction> retrieveTxn();
    public void deleteTxn(String transactionId);

}
