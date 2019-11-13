package com.hcl.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table ( name = "user" )
public class User {
	
	@Id
	private int accountNumber;
	private String userName;
	private String passWord;
	private Date dateOfBirth; 
    private Integer age;
    private String gender;
    private long phoneNo;
    private String email;
    private String city;
    private String state;
    private String accountType;

}
