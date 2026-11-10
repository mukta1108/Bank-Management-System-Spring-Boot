package com.app.MyFirstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.MyFirstProject.entity.Account;
import com.app.MyFirstProject.service.AccountService;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
     @Autowired
     AccountService service;
	//create account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account acc) {
		Account createAcc = service.createAccount(acc);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAcc);
		
	}
	
	
	
	@GetMapping("/{acc_number}")
	public Account getAccountByAccountNumber(@PathVariable("acc_number") long acc_number) {
		Account account=service.getAccountDetailsByAccountNumber(acc_number);
		return account;
	}
	
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccountDetails(){
		List<Account> allAccDetails =service.getAllAccounts();
		return allAccDetails;
	}
	
	
	@PutMapping("/deposit/{acc_number}/{amountToDeposit}")
	public Account depositAccount(@PathVariable long acc_number, @PathVariable double amountToDeposit) {
		Account account = service.depositeAmount(acc_number, amountToDeposit);
		return account;
	}
	
	
	@PutMapping("/withdraw/{acc_number}/{amountToWithdraw}")
	public Account withdrawAccount(@PathVariable long acc_number, @PathVariable double amountToWithdraw) {
		Account account = service.withdrawAmount(acc_number, amountToWithdraw);
		return account;
	}
	
	
	
	
	@DeleteMapping("/delete/{acc_no}")
	public ResponseEntity deleteAccount(@PathVariable long acc_no) {
		service.closeAccount(acc_no);
		return (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
	}
}


