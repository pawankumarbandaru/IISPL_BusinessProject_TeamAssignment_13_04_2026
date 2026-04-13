package com.iispl.service;

import java.util.Scanner;

public class ServiceChoice {
	public static void chooseAccountService(Scanner sc) {
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
            		// Add Account
            	
            		break;

            	case 2:
            		// Display All Accounts
                
            		break;
            	
            	case 3:
            		// Display Only Active Accounts
            	
            		break;
            	
            	case 4:
            		// Display Only Savings Accounts
            	
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
	
	
	