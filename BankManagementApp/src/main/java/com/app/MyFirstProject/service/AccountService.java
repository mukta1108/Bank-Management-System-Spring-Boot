package com.app.MyFirstProject.service;

import com.app.MyFirstProject.entity.Account;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    
    public Account getAccountDetailsByAccountNumber(long Accountumber);
    
    public List<Account> getAllAccounts();
    
    public Account depositeAmount(long account_number, double depositAmount);
    
    public Account withdrawAmount(long account_number, double withdrawAmount);
    
    public void closeAccount(long account_number);
}
