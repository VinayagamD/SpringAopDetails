package com.vinay.springaopdemo.dao;

import org.springframework.stereotype.Component;

import com.vinay.springaopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+ ": Doing My DB WORK: ADDING AN ACCOUNT");
	}

	public boolean doWork() {
		System.out.println(getClass()+" : doWork()");
		return false;
	}

}
