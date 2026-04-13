package com.iispl.service;

import com.iispl.entity.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceChoice {

    private static final List<Transaction> transactionList = new ArrayList<>();

    private static final double HIGH_VALUE_THRESHOLD = 100000.00;

 
    public static void chooseAccountService(Scanner sc) {
        char yourChoice;

        do {
            System.out.println("\n========== ACCOUNT SERVICES ==========");
            System.out.println("1. Add Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Display Only Active Accounts");
            System.out.println("4. Display Only Savings Accounts");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // TODO: Account team — Add Account logic here
                    break;

                case 2:
                    // TODO: Account team — Display All Accounts logic here
                    break;

                case 3:
                    // TODO: Account team — Display Only Active Accounts logic here
                    break;

                case 4:
                    // TODO: Account team — Display Only Savings Accounts logic here
                    break;

                default:
                    System.out.println("[!] Invalid choice! Please try again.");
            }

            System.out.print("\nDo you want to continue Account Services? (Y/N): ");
            yourChoice = sc.next().charAt(0);

        } while (yourChoice == 'y' || yourChoice == 'Y');
    }

    // ==================================================================
    //  TRANSACTION SERVICE MENU
    // ==================================================================
    public static void chooseTransactionService(Scanner sc) {
        char yourChoice;

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
                    addTransaction(sc);
                    break;

                case 2:
                    displayAllTransactions();
                    break;

                case 3:
                    displayHighValueTransactions();
                    break;

                case 4:
                    displayFailedTransactions();
                    break;

                default:
                    System.out.println("[!] Invalid choice! Please try again.");
            }

            System.out.print("\nDo you want to continue Transaction Services? (Y/N): ");
            yourChoice = sc.next().charAt(0);

        } while (yourChoice == 'y' || yourChoice == 'Y');
    }


    private static void addTransaction(Scanner sc) {
        System.out.println("\n---------- Add New Transaction ----------");

        sc.nextLine();

        System.out.print("Enter Transaction ID       : ");
        String transactionId = sc.nextLine().trim();

        System.out.print("Enter From Account Number  : ");
        String fromAccount = sc.nextLine().trim();

        System.out.print("Enter To Account Number    : ");
        String toAccount = sc.nextLine().trim();

        double amount = 0;
        while (true) {
            System.out.print("Enter Amount               : ");
            String amountInput = sc.nextLine().trim();
            try {
                amount = Double.parseDouble(amountInput);
                if (amount < 0) {
                    System.out.println("[!] Amount cannot be negative. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid amount. Please enter a numeric value.");
            }
        }

        System.out.println("Select Channel:");
        System.out.println("  1. NET_BANKING");
        System.out.println("  2. UPI");
        System.out.println("  3. ATM");
        System.out.println("  4. BRANCH");
        System.out.print("Enter channel choice (1-4): ");
        int channelChoice = Integer.parseInt(sc.nextLine().trim());
        String channel = switch (channelChoice) {
            case 1 -> "NET_BANKING";
            case 2 -> "UPI";
            case 3 -> "ATM";
            case 4 -> "BRANCH";
            default -> "UNKNOWN";
        };

        System.out.println("Select Status:");
        System.out.println("  1. SUCCESS");
        System.out.println("  2. FAILED");
        System.out.println("  3. PENDING");
        System.out.print("Enter status choice (1-3) : ");
        int statusChoice = Integer.parseInt(sc.nextLine().trim());
        String status = switch (statusChoice) {
            case 1 -> "SUCCESS";
            case 2 -> "FAILED";
            case 3 -> "PENDING";
            default -> "UNKNOWN";
        };

        // Duplicate ID check — business validation
        for (Transaction t : transactionList) {
            if (t.getTransactionId().equalsIgnoreCase(transactionId)) {
                System.out.println("[ERROR] Transaction ID '" + transactionId + "' already exists. Aborting.");
                return;
            }
        }

        // Create immutable Transaction object
        Transaction newTransaction = new Transaction(
                transactionId, fromAccount, toAccount, amount, channel, status
        );

        transactionList.add(newTransaction);
        System.out.println("[SUCCESS] Transaction added successfully!");
        System.out.println("  " + newTransaction);
    }

  
    private static void displayAllTransactions() {
        System.out.println("\n---------- All Transactions ----------");

        if (transactionList.isEmpty()) {
            System.out.println("[INFO] No transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : transactionList) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + transactionList.size());
    }

    private static void displayHighValueTransactions() {
        System.out.println("\n---------- High-Value Transactions (Amount > ₹"
                + String.format("%,.2f", HIGH_VALUE_THRESHOLD) + ") ----------");

        List<Transaction> highValue = new ArrayList<>();
        for (Transaction t : transactionList) {
            if (t.getAmount() > HIGH_VALUE_THRESHOLD) {
                highValue.add(t);
            }
        }

        if (highValue.isEmpty()) {
            System.out.println("[INFO] No high-value transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : highValue) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + highValue.size());
    }

    private static void displayFailedTransactions() {
        System.out.println("\n---------- Failed Transactions ----------");

        List<Transaction> failed = new ArrayList<>();
        for (Transaction t : transactionList) {
            if ("FAILED".equalsIgnoreCase(t.getStatus())) {
                failed.add(t);
            }
        }

        if (failed.isEmpty()) {
            System.out.println("[INFO] No failed transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : failed) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + failed.size());
    }

   
    private static void printTableHeader() {
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
        System.out.printf( "| %-10s | %-12s | %-12s | %14s | %-12s | %-8s |%n",
                "TXN ID", "FROM ACC", "TO ACC", "AMOUNT (INR)", "CHANNEL", "STATUS");
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
    }

    private static void printTableFooter() {
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
    }
}
=======
	public static void chooseAccountService(Scanner sc) {
		char yourChoice;
		
		do {
			System.out.println("\nAccount Service Menu:");
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
			
			System.out.println("Do you want to visit again?(Y/N)");
			yourChoice = sc.next().charAt(0);
		
		}while(yourChoice == 'y' || yourChoice == 'Y');
	}
		
		public static void chooseTransactionService(Scanner sc) {
			char yourChoice;
			
			do {
				System.out.println("\nTransaction Service Menu:");
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
				
			System.out.println("Do you want to visit again?(Y/N)");
			yourChoice = sc.next().charAt(0);
		
		}while(yourChoice == 'y' || yourChoice == 'Y');
	}	
}
	
