package com.hcl.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.model.Transaction;
import com.hcl.bank.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transferDetails(Transaction transaction) {
		return new ResponseEntity<String>(transactionService.transaction(transaction), HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Transaction>> listAllTransaction() {
		return new ResponseEntity<List<Transaction>>(transactionService.listTransaction(),HttpStatus.OK);
	}

}
