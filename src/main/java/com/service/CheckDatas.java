package com.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.*;
import com.Repository.*;

@Service
public class CheckDatas {
	
	@Autowired
	UserDataRepository userrepo;
	
	
	public String Logindata(String email,String password) {
		userdetails userdata=userrepo.findById(email).orElse(null);
		if(userdata==null || !userdata.getPassword().equals(password)) {
			return "Enter Valid User Details";
		}
		return null;
	}
	public String Signupdata(userdetails userdata) {
		String name,sname,email,dateofbirth,phonenumber,gender,password;
		name=userdata.getFirstname();
		sname=userdata.getSecondname();
		email=userdata.getEmail();
		dateofbirth=userdata.getDateOfBirth();
		phonenumber=userdata.getPhoneNumber();
		gender=userdata.getGender();
		password=userdata.getPassword();
		
		name=(!(sname==null))?name+" "+sname:name;//first name+last name
		System.out.print(name+email+dateofbirth+phonenumber+gender+password);
		if(name==null || email==null || dateofbirth==null || phonenumber==null || gender==null || password ==null)
			return "Enter Information";
		
		
		//pattern for validate the information
    	Pattern p=Pattern.compile("[^a-zA-Z\\s]");
    	Pattern pn=Pattern.compile("[^0-9]");
    	Pattern pe=Pattern.compile("@gmail.com$");
    	
    	Matcher mname,mnumber,memail;//matcher variables
    	//matcher for validate the data
    	mname=p.matcher(name);
    	mnumber=pn.matcher(phonenumber);
    	memail=pe.matcher(email);
    	if(mname.find() || mnumber.find() || !memail.find()) {
    		return "Invalid Data";
    	}
    	
		return "Added Successfully";
		
	}
}