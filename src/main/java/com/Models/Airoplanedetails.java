package com.Models;

import jakarta.persistence.*;

@Table(name="Airoplane")
@Entity(name="Airoplane")
public class Airoplanedetails{
	
	@Id
	private int Flightno;
	private String flightname;
	private String departuretime;
	private String departuredate;
	private String From;
	private String To;
	private String departureterminal;
	private String arrivaltime;
	private String arrivaldate;
	private String arrivalterminal;
	private int price;
	private int Availableseat;
	
	
	public String getDeparturedate() {
		return departuredate;
	}
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}
	public String getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public int getAvailableseat() {
		return Availableseat;
	}
	public void setAvailableseat(int availableseat) {
		Availableseat = availableseat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getFlightno() {
		return Flightno;
	}
	public void setFlightno(int flightno) {
		Flightno = flightno;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime){
		this.departuretime = departuretime;
	}
	public String getDepartureterminal() {
		return departureterminal;
	}
	public void setDepartureterminal(String departureterminal){
		this.departureterminal = departureterminal;
	}
	public String getArrivaltime(){
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime){
		this.arrivaltime = arrivaltime;
	}
	public String getArrivalterminal(){
		return arrivalterminal;
	}
	public void setArrivalterminal(String arrivalterminal){
		this.arrivalterminal = arrivalterminal;
	}
	
}