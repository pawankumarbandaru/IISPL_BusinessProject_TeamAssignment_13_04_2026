
package com.iispl.repository;

import java.util.ArrayList;
import java.util.List;

import com.iispl.entity.Account;
import com.iispl.service.AccountServiceImpl;


public class BankOperationsImpl implements BankOperations{
	
	List<Account> accountList = new ArrayList<Account>();
	
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
	public void updateAcc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAcc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeTxn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retrieveTxn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTxn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTxn() {
		// TODO Auto-generated method stub
		
	}

}