package com.iispl.repository;

import com.iispl.entity.Transaction;
import java.util.List;

public interface BankOperations {

    public void storeAcc();
    public void retrieveAcc();
    public void updateAcc();
    public void deleteAcc();

    public void storeTxn(Transaction transaction);
    public List<Transaction> retrieveTxn();
    public void deleteTxn(String transactionId);
}