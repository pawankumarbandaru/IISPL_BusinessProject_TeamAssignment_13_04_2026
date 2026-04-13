package com.iispl.repository;

public interface BankOperations {
	public void storeAcc();
	public void retrieveAcc();
	public void updateAcc();
	public void deleteAcc();
	
	public void storeTxn();
	public void retrieveTxn();
	public void updateTxn();
	public void deleteTxn();
}
