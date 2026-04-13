package com.iispl.service;

import com.iispl.entity.Transaction;

import java.util.List;
import java.util.Scanner;

public interface TransactionService {

    void addTransaction(Scanner sc);

    void displayAllTransactions();

    void displayHighValueTransactions();

    void displayFailedTransactions();

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByAccountID(String accountNumber);
}