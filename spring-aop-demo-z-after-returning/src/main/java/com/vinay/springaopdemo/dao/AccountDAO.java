package com.vinay.springaopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vinay.springaopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+ ": Doing My DB WORK: ADDING AN ACCOUNT");
	}
	
	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<>();
//		create sample account
		Account tempAccount1 = new Account("John","Silver");
		Account tempAccount2 = new Account("Madhu","Platinum");
		Account tempAccount3 = new Account("Luca","Gold");
		
//		add them to our accounts list
		accounts.add(tempAccount1);
		accounts.add(tempAccount2);
		accounts.add(tempAccount3);
		
		return accounts;
	}

	public boolean doWork() {
		System.out.println(getClass()+" : doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+" : in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" : in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" : in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	

}
