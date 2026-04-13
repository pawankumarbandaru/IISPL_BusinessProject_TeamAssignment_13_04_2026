package com.iispl.service;

import java.util.List;
import java.util.Scanner;

import com.iispl.entity.Account;
import com.iispl.enums.AccountStatus;
import com.iispl.enums.AccountType;

public class AccountServiceImpl implements AccountService{
	Scanner sc = new Scanner(System.in);

	@Override
	public void displayAllAccounts(List<Account> accountList) {
		// TODO Auto-generated method stub
	int index=1;
	for(Account account:accountList) {
		System.out.println((index) + "AccountNumber  :"+account.getAccountNumber()+" \n AccountHolderName :"
				+account.getHolderName()+" \n Account Type :"+account.getAccountType()+" \n Account Balance :"
				+account.getBalance()+" \n Account Status :"+account.getAccountStatus()+"\n");
		index++;
	}
		
	}

	@Override
	public void displaySavingsAccounts(List<Account> accountList) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(account.getAccountType()==AccountType.SAVINGS) {
				int index=1;
				System.out.println((index) + "AccountNumber  :"+account.getAccountNumber()+" \n AccountHolderName :"
						+account.getHolderName()+" \n Account Type :"+account.getAccountType()+" \n Account Balance :"
						+account.getBalance()+" \n Account Status :"+account.getAccountStatus()+"\n");
				index++;
				
			}
			
		}
		
	}

	@Override
    public Account createAccount() {
        System.out.println("Enter Account Number:");
        String accountNumber = sc.next();

        System.out.println("Enter Holder Name:");
        String holderName = sc.next();

        System.out.println("Enter Account Type (SAVINGS / CURRENT):");
        AccountType accountType = AccountType.valueOf(sc.next().toUpperCase());

        System.out.println("Enter Balance:");
        long balance = sc.nextLong();
        System.out.println("Enter Account status (ACTIVE/INACTIVE): ");
        AccountStatus accountStatus=AccountStatus.valueOf(sc.next().toUpperCase());

        // Status is always ACTIVE on creation
        return new Account(accountNumber, holderName, accountType, balance, accountStatus);
    }
	@Override
	public void displayActiveAccounts(List<Account> accountList) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(account.getAccountStatus()==AccountStatus.ACTIVE) {
				int index=1;
				System.out.println((index) + "AccountNumber  :"+account.getAccountNumber()+" \n AccountHolderName :"
						+account.getHolderName()+" \n Account Type :"+account.getAccountType()+" \n Account Balance :"
						+account.getBalance()+" \n Account Status :"+account.getAccountStatus()+"\n");
				index++;
				
			}
		
	}

	
	

	}
}