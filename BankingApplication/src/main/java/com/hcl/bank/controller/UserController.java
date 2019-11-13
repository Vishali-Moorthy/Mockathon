package com.hcl.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.domain.Login;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.model.User;
import com.hcl.bank.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<String> newUser(User user) {
		return new ResponseEntity<String>(userService.newUserRegister(user), HttpStatus.OK);
	}
	
	@GetMapping("/allUsers") 
	public ResponseEntity<List<User>> allUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<List<Transaction>> loginAuthenticate(Login login) {
		return new ResponseEntity<List<Transaction>>(userService.loginUser(login), HttpStatus.OK);
	}
	
	@PostMapping("/find/{accountNumber}")
	public ResponseEntity<User> findByAccountNumber(@PathVariable Integer accountNumber) {
		return new ResponseEntity<User>(userService.findUserByaccountNumber(accountNumber), HttpStatus.OK);
	}
}

