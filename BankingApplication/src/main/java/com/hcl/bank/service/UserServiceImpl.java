package com.hcl.bank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.domain.Login;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.model.User;
import com.hcl.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private TransactionService transactionservice;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String newUserRegister(User user) {
		userRepository.save(user);
		return "Registered successfully";
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<Transaction> loginUser(Login login) {
		String name = login.getUserName();
		String code = login.getPassWord();
		User user = userRepository.findUserByuserName(name);
		if(name.equals(user.getUserName()) && code.equals(user.getPassWord())) {
			Integer number = user.getAccountNumber();
			return transactionservice.findByfromAccount(number);
		} else {
			return null;
		}
	}

	@Override
	public User findUserByaccountNumber(Integer accountNumber) {
		return userRepository.findUserByaccountNumber(accountNumber);
	}
}
