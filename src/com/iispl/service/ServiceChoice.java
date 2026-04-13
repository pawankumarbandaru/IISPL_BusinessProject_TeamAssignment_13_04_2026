package com.iispl.service;

import java.util.List;
import java.util.Scanner;

import com.iispl.entity.Account;
import com.iispl.repository.BankOperationsImpl;

public class ServiceChoice {
	private static BankOperationsImpl bankOps           = new BankOperationsImpl();
    private static AccountService     accountService;
	public static void chooseAccountService(Scanner sc) {
		accountService = new AccountServiceImpl();
		
		char yourChoice;
		
		do {
			System.out.println("1. Add Account"
					+ "\n2. Display All Accounts"
					+ "\n3. Display Only Active Accounts"
					+ "\n4. Display Only Savings Accounts"
					);
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
                // createAccount() reads from Scanner and returns Account object
                Account newAccount = accountService.createAccount();
                // Store it in BankOperationsImpl's ArrayList
                bankOps.storeAcc(newAccount);
                break;

            case 2:
                List<Account> allAccounts = bankOps.retrieveAcc();
                if (allAccounts.isEmpty())
                    System.out.println("No accounts found.\n");
                else
                    accountService.displayAllAccounts(allAccounts);
                break;
            	
            case 3:
                List<Account> activeList = bankOps.retrieveAcc();
                if (activeList.isEmpty())
                    System.out.println("No accounts found.\n");
                else
                    accountService.displayActiveAccounts(activeList);
                break;

            case 4:
                List<Account> savingsList = bankOps.retrieveAcc();
                if (savingsList.isEmpty())
                    System.out.println("No accounts found.\n");
                else
                    accountService.displaySavingsAccounts(savingsList);
                break;

            	
            	default:
            		System.out.println("Invalid choice!");
			}
			
			System.out.println("Do you want to login again?(Y/N)");
			yourChoice = sc.next().charAt(0);
		
		}while(yourChoice == 'y' || yourChoice == 'Y');
	}
		
		public static void chooseTransactionService(Scanner sc) {
			char yourChoice;
			
			do {
				System.out.println("1. Add Transaction"
						+ "\n2. Display All Transactions"
						+ "\n3. Display Only High-Value Transactions"
						+ "\n4. Display Only Falied Transactions"
						);
				int choice = sc.nextInt();
				
				switch(choice) {
		            case 1:
		            	// Add Transaction
		            	
		            	break;
	
		            case 2:
		                // Display All Transactions
		                
		            	break;
		            	
		            case 3:
		            	// Display Only High-Value Transactions
		            	
		            	break;
		            	
		            case 4:
		            	// Display Only Falied Transactions
		            	
		            	break;
		            	
		            default:
		                System.out.println("Invalid choice!");
				}
				
			System.out.println("Do you want to login again?(Y/N)");
			yourChoice = sc.next().charAt(0);
		
		}while(yourChoice == 'y' || yourChoice == 'Y');
	}	
}