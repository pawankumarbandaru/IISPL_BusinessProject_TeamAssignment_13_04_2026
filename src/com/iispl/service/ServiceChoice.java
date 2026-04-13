package com.iispl.service;

import java.util.Scanner;

public class ServiceChoice {

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
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.print("\nDo you want to continue Account Services? (Y/N): ");
            yourChoice = sc.next().charAt(0);

        } while (yourChoice == 'y' || yourChoice == 'Y');
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