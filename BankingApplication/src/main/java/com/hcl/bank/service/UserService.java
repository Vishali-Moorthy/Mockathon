package com.hcl.bank.service;

import java.util.List;

import com.hcl.bank.domain.Login;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.model.User;

public interface UserService {
	
	public String newUserRegister(User user);
	
	public List<User> getAllUsers();
	
	public List<Transaction> loginUser(Login login);
	
	public User findUserByaccountNumber(Integer accountNumber);

}
