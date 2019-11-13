package com.hcl.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	public Account findAccountByaccountId(Integer accountId);

	public Account findAccountByaccountNumber(Integer accountNumber);

}
