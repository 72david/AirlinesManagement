package com.Models;

import jakarta.persistence.*;

@Entity
@Table(name="UserDetails")
public class userdetails {
	
	@Id
	private String Email;
	private String Firstname;
	private String Secondname;
	private String DateOfBirth;
	private String Gender;
	private String PhoneNumber;
	private String Password;
	
	
	@Override
	public String toString() {
		return "userdetails [Name=" + Firstname+Secondname + ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", Email=" + Email
				+ ", PhoneNumber=" + PhoneNumber + ", Password=" + Password + "]";
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getSecondname() {
		return Secondname;
	}
	public void setSecondname(String secondname) {
		Secondname = secondname;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
