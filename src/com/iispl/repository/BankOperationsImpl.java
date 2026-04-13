package com.iispl.repository;

import com.iispl.entity.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankOperationsImpl implements BankOperations {

    private static final List<Transaction> transactionList = new ArrayList<>();

    @Override
    public void storeAcc() {
    }

    @Override
    public void retrieveAcc() {
    }

    @Override
    public void updateAcc() {
    }

    @Override
    public void deleteAcc() {
    }

    @Override
    public void storeTxn(Transaction transaction) {
    	transactionList.add(transaction);
    }

    @Override
    public List<Transaction> retrieveTxn() {
        return Collections.unmodifiableList(transactionList);
    }

 

    @Override
    public void deleteTxn(String transactionId) {
        boolean removed = transactionList.removeIf(
            t -> t.getTransactionId().equalsIgnoreCase(transactionId)
        );
        if (!removed) {
            System.out.println("Transaction ID " + transactionId + " not found.");
        }
    }

    public boolean isDuplicateId(String transactionId) {
        for (Transaction t : transactionList) {
            if (t.getTransactionId().equalsIgnoreCase(transactionId)) {
                return true;
            }
        }
        return false;
    }
}