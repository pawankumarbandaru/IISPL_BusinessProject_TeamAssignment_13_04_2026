package com.iispl.service;

import java.util.List;
import com.iispl.entity.Account;

public interface AccountService {
    Account createAccount();
    void displayAllAccounts(List<Account> accountList);
    void displaySavingsAccounts(List<Account> accountList);
    void displayActiveAccounts(List<Account> accountList);
}