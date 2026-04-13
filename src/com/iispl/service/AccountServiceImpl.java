package com.iispl.service;

import java.util.List;
import java.util.Scanner;
import com.iispl.entity.Account;
import com.iispl.enums.AccountStatus;
import com.iispl.enums.AccountType;

public class AccountServiceImpl implements AccountService {

    Scanner sc = new Scanner(System.in);

    @Override
    public Account createAccount(List<Account> existingAccounts) {

        String accountNumber;

        // Duplicate account number validation
        while (true) {
            System.out.println("Enter Account Number:");
            accountNumber = sc.next();

            boolean isDuplicate = false;
            for (Account acc : existingAccounts) {
                if (acc.getAccountNumber().equals(accountNumber)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Account Number already exists! Please enter a different Account Number.");
            } else {
                break;
            }
        }

        System.out.println("Enter Holder Name:");
        String holderName = sc.next();

        // Account Type validation
        System.out.println("Enter Account Type (SAVINGS / CURRENT):");
        AccountType accountType = null;
        while (accountType == null) {
            try {
                accountType = AccountType.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Account Type! Enter SAVINGS or CURRENT:");
            }
        }

        // Balance validation
        long balance = 0;
        while (true) {
            System.out.println("Please Enter Balance:");
            balance = sc.nextLong();
            if (balance < 1) {
                System.out.println("Invalid Balance! Must be greater than 0.");
            } else {
                break;
            }
        }

        // Account Status validation
        System.out.println("Enter Account Status (ACTIVE / INACTIVE):");
        AccountStatus accountStatus = null;
        while (accountStatus == null) {
            try {
                accountStatus = AccountStatus.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Status! Enter ACTIVE or INACTIVE:");
            }
        }

        return new Account(accountNumber, holderName, accountType, balance, accountStatus);
    }

    @Override
    public void displayAllAccounts(List<Account> accountList) {
        System.out.println("\n===== All Accounts =====");
        int index = 1;

        for (Account account : accountList) {
            System.out.println("---- Account " + index + " ----");
            System.out.println(account);
            System.out.println();
            index++;
        }
    }

    @Override
    public void displaySavingsAccounts(List<Account> accountList) {
        System.out.println("\n===== Savings Accounts =====");
        int index = 1;
        boolean found = false;

        for (Account account : accountList) {
            if (account.getAccountType() == AccountType.SAVINGS) {
                System.out.println("---- Account " + index + " ----");
                System.out.println(account);
                System.out.println();
                index++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No savings accounts found.\n");
        }
    }

    @Override
    public void displayActiveAccounts(List<Account> accountList) {
        System.out.println("\n===== Active Accounts =====");
        int index = 1;
        boolean found = false;

        for (Account account : accountList) {
            if (account.getAccountStatus() == AccountStatus.ACTIVE) {
                System.out.println("---- Account " + index + " ----");
                System.out.println(account);
                System.out.println();
                index++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No active accounts found.\n");
        }
    }
}