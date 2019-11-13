package com.hcl.bank.service;

import java.util.List;

import com.hcl.bank.model.Transaction;

public interface TransactionService {
	
	public String transaction(Transaction transaction);
	
	public List<Transaction> listTransaction();
	
	public List<Transaction> findByfromAccount(Integer fromAccount);
	
	

	
	

}
