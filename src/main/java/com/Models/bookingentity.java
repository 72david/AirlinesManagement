package com.Models;

import jakarta.persistence.*;

@Entity(name="Tickets")
@Table(name="Tickets")
public class bookingentity {
	
	@Id
	private int pnrnumber;
	private String flightno;
	private String name;
	private int age;
	private String gender;
	private int seatno;
	private String phonenumber;
	private String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getPnrnumber() {
		return pnrnumber;
	}
	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "bookingentity [pnrnumber=" + pnrnumber + ", flightno=" + flightno + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", seatno=" + seatno + ", phonenumber=" + phonenumber + ", date=" + date + "]";
	}
	
}
