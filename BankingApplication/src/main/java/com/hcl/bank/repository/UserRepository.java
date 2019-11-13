package com.hcl.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findUserByuserName(String userName);

	public User findUserByaccountNumber(Integer accountNumber);

}
