package com.hcl.bank.service;

import java.util.List;

import com.hcl.bank.model.Account;

public interface AccountService {

	public List<Account> listAccount();
	
	public Account findAccountByaccountId(Integer accountId);

	public Account findAccountByaccountNumber(Integer accountNumber);
}
