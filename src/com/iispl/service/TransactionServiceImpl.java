package com.iispl.service;

import com.iispl.entity.Transaction;
import com.iispl.repository.BankOperationsImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionServiceImpl implements TransactionService {

    private static final BigDecimal HIGH_VALUE_THRESHOLD = new BigDecimal("10000.00");
    private static final String STATUS_FAILED = "FAILED";

    private final BankOperationsImpl repo = new BankOperationsImpl();

    @Override
    public void addTransaction(Scanner sc) {
        System.out.println("\n---------- Add New Transaction ----------");

        sc.nextLine();

        String transactionId;
        while (true) {
            System.out.print("Enter Transaction ID       : ");
            transactionId = sc.nextLine().trim();
            if (repo.isDuplicateId(transactionId)) {
                System.out.println("Transaction ID '" + transactionId + "' already exists. Please enter a different ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter From Account Number  : ");
        String fromAccount = sc.nextLine().trim();

        System.out.print("Enter To Account Number    : ");
        String toAccount = sc.nextLine().trim();

        BigDecimal amount;
        while (true) {
            System.out.print("Enter Amount               : ");
            String amountInput = sc.nextLine().trim();
            try {
                amount = new BigDecimal(amountInput);
                if (amount.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Amount cannot be negative. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
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

        Transaction newTransaction = new Transaction(
                transactionId, fromAccount, toAccount, amount, channel, status
        );

        repo.storeTxn(newTransaction);
        System.out.println("Transaction added successfully!");
        System.out.println("  " + newTransaction);
    }

    @Override
    public void displayAllTransactions() {
        System.out.println("\n---------- All Transactions ----------");

        List<Transaction> transactionList = repo.retrieveTxn();

        if (transactionList.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : transactionList) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + transactionList.size());
    }

    @Override
    public void displayHighValueTransactions() {
        System.out.println("\n---------- High-Value Transactions (Amount > Rs."
                + String.format("%,.2f", HIGH_VALUE_THRESHOLD) + ") ----------");

        List<Transaction> highValue = new ArrayList<>();
        for (Transaction t : repo.retrieveTxn()) {
            if (t.getAmount().compareTo(HIGH_VALUE_THRESHOLD) > 0) {
                highValue.add(t);
            }
        }

        if (highValue.isEmpty()) {
            System.out.println("No high-value transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : highValue) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + highValue.size());
    }

    @Override
    public void displayFailedTransactions() {
        System.out.println("\n---------- Failed Transactions ----------");

        List<Transaction> failed = new ArrayList<>();
        for (Transaction t : repo.retrieveTxn()) {
            if (STATUS_FAILED.equalsIgnoreCase(t.getStatus())) {
                failed.add(t);
            }
        }

        if (failed.isEmpty()) {
            System.out.println("No failed transactions found.");
            return;
        }

        printTableHeader();
        for (Transaction t : failed) {
            System.out.println(t);
        }
        printTableFooter();
        System.out.println("Total records: " + failed.size());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repo.retrieveTxn();
    }

    @Override
    public List<Transaction> getTransactionsByAccountID(String accountNumber) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : repo.retrieveTxn()) {
            if (accountNumber.equals(t.getFromAccount())
                    || accountNumber.equals(t.getToAccount())) {
                result.add(t);
            }
        }
        return result;
    }

    private void printTableHeader() {
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
        System.out.printf("| %-10s | %-12s | %-12s | %14s | %-12s | %-8s |%n",
                "TXN ID", "FROM ACC", "TO ACC", "AMOUNT (INR)", "CHANNEL", "STATUS");
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
    }

    private void printTableFooter() {
        System.out.println("+------------+--------------+--------------+----------------+--------------+----------+");
    }
}