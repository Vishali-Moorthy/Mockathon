package com.hcl.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.model.Account;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public String transaction(Transaction transaction) {
		Account fromAccount = accountService.findAccountByaccountNumber(transaction.getFromAccount());
		Account toAccount = accountService.findAccountByaccountNumber(transaction.getToAccount());
		if(fromAccount == toAccount) {
			return "AccountNumber cannot be same";
		}
		Long amount = transaction.getTransferAmount();
		if(fromAccount.getBalance()>amount) {
			Long balanceAmount = fromAccount.getBalance() - amount;
			Long finalBalance = toAccount.getBalance() + amount;
			fromAccount.setBalance(balanceAmount);
			toAccount.setBalance(finalBalance);
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);
			transactionRepository.save(transaction);
			return "Transaction successful";
		} else {
			return "Amount should be greater than balance amount";
		}
	}

	@Override
	public List<Transaction> listTransaction() {
		return transactionRepository.findAll();
	}

	@Override
	public List<Transaction> findByfromAccount(Integer fromAccount) {
		
		return transactionRepository.findByfromAccount(fromAccount);
	}
	
	
}

	
