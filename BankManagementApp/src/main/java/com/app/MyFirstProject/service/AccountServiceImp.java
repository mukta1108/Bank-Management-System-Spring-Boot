package com.app.MyFirstProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.MyFirstProject.entity.Account;
import com.app.MyFirstProject.repo.AccountRepository;
@Service
public class AccountServiceImp implements AccountService{
@Autowired
AccountRepository repo;

@Override
public Account createAccount(Account account) {
	Account acc_saved=repo.save(account);
	return acc_saved;
}

	@Override
	public Account getAccountDetailsByAccountNumber(long Accountumber) {
		Optional<Account> account = repo.findById(Accountumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account isn't present !");
		}
		Account acc_found=account.get();
		return acc_found;
	}

	public List<Account> getAllAccounts() {
		List<Account> listOfAcc = repo.findAll();
		return listOfAcc;
	}

	@Override
	public Account depositeAmount(long account_number, double depositAmount) {
		Optional<Account> account=repo.findById(account_number);
		if(account.isEmpty()) {
			throw new RuntimeException("Account isn't present !");
		}
		Account present_acc = account.get();
		double totalBalance=present_acc.getAccount_balance()+depositAmount;
		present_acc.setAccount_balance(totalBalance);
		repo.save(present_acc);
		return present_acc;
	}

	@Override
	public Account withdrawAmount(long account_number, double withdrawAmount) {
		Optional<Account> account=repo.findById(account_number);
		if(account.isEmpty()) {
			throw new RuntimeException("Account isn't present !");
		}
		Account present_acc = account.get();
		double presentBalance=present_acc.getAccount_balance()-withdrawAmount;
		present_acc.setAccount_balance(presentBalance);
		repo.save(present_acc);
		
		return present_acc;
	}

	@Override
	public void closeAccount(long account_number) {
		getAccountDetailsByAccountNumber(account_number);
		repo.deleteById(account_number);
		
	}
    
}
