package com.hcl.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.model.Account;
import com.hcl.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Account>> listAllAccount() {
		return new ResponseEntity<List<Account>>(accountService.listAccount(), HttpStatus.OK);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> findByAccountId(@PathVariable Integer accountId) {
		return new ResponseEntity<Account>(accountService.findAccountByaccountId(accountId), HttpStatus.OK);
	}

}
