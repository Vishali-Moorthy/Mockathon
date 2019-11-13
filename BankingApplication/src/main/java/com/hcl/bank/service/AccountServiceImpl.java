package com.hcl.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.model.Account;
import com.hcl.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> listAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account findAccountByaccountId(Integer accountId) {
		return accountRepository.findAccountByaccountId(accountId);
	}
	
	@Override
	public Account findAccountByaccountNumber(Integer accountNumber) {
		return accountRepository.findAccountByaccountNumber(accountNumber);
	}
	
	

}
