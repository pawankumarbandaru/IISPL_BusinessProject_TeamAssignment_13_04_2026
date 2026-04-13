package com.iispl.service;

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
			    List<Account> existingAccounts = bankOps.retrieveAcc(); // fetch current list
			    Account newAccount = accountService.createAccount(existingAccounts); // pass for duplicate check
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

        TransactionServiceImpl txnService = new TransactionServiceImpl();

        do {
            System.out.println("\n========== TRANSACTION SERVICES ==========");
            System.out.println("1. Add Transaction");
            System.out.println("2. Display All Transactions");
            System.out.println("3. Display Only High-Value Transactions");
            System.out.println("4. Display Only Failed Transactions");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    txnService.addTransaction(sc);
                    break;

                case 2:
                    txnService.displayAllTransactions();
                    break;

                case 3:
                    txnService.displayHighValueTransactions();
                    break;

                case 4:
                    txnService.displayFailedTransactions();
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.print("\nDo you want to continue Transaction Services? (Y/N): ");
            yourChoice = sc.next().charAt(0);

        } while (yourChoice == 'y' || yourChoice == 'Y');
	}
}
	
