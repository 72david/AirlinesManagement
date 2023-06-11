package com.Models;

import org.springframework.stereotype.Component;

@Component
public class Variables {
	int accountstatus;
	String Wmessage;

	public int getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(int accountstatus) {
		this.accountstatus = accountstatus;
	}

	public String getWmessage() {
		return Wmessage;
	}

	public void setWmessage(String wmessage) {
		Wmessage = wmessage;
	}
	
}
