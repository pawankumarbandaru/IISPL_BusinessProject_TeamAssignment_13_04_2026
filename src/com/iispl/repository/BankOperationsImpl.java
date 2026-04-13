package com.iispl.repository;

import com.iispl.entity.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.iispl.entity.Account;


public class BankOperationsImpl implements BankOperations{
	
	List<Account> accountList = new ArrayList<Account>();
	private static final List<Transaction> transactionList = new ArrayList<>();
	
	@Override
    public void storeAcc(Account account) {
        accountList.add(account);
        System.out.println("✔ Account added successfully!\n");
    }

	@Override
	public List<Account> retrieveAcc() {
		// TODO Auto-generated method stub
		return accountList;
	}


	@Override
    public void storeTxn(Transaction transaction) {
    	transactionList.add(transaction);
    }

    @Override
    public List<Transaction> retrieveTxn() {
        return Collections.unmodifiableList(transactionList);
    }

 

    @Override
    public void deleteTxn(String transactionId) {
        boolean removed = transactionList.removeIf(
            t -> t.getTransactionId().equalsIgnoreCase(transactionId)
        );
        if (!removed) {
            System.out.println("Transaction ID " + transactionId + " not found.");
        }
    }


    public boolean isDuplicateId(String transactionId) {
        for (Transaction t : transactionList) {
            if (t.getTransactionId().equalsIgnoreCase(transactionId)) {
                return true;
            }
        }
        return false;
    }
}
