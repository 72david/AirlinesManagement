package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.Airoplanedetails;
import com.Models.bookingentity;
import com.Repository.TicketsRepository;

@Service
public class ticketservice {
	
	@Autowired	
	TicketsRepository ticketrepo;
	
	private static Integer pnrnumber=null;
	
	public String bookticket(bookingentity booke,Airoplanedetails ad) {

		String name=booke.getName();
		String phonenumber=booke.getPhonenumber();
		int age=booke.getAge();
		int seatno=booke.getSeatno();
		String gender=booke.getGender();
		Pattern p=Pattern.compile("[^a-zA-Z\\s]");
    	Pattern pn=Pattern.compile("[^0-9]");
    	
    	Matcher mname=p.matcher(name);
    	Matcher mnumber=pn.matcher(phonenumber);
    	Matcher mage=pn.matcher(age+"");
    	
    	if(mname.find() || mnumber.find() || mage.find() || age>120 || age<0 || seatno==0 || gender==null) {
    		return "Invalid Data";
    	}
    	booke.setPnrnumber(Integer.parseInt(booke.getFlightno()+seatno));
    	booke.setDate(ad.getDeparturedate());
    	ticketrepo.save(booke);
    	pnrnumber=booke.getPnrnumber();
		return "Booked Successfully";
	}
	public ArrayList<Integer> availableseat(int avilableseat,String flightno){
		ArrayList<Integer> availableseats=new ArrayList<>();
		ArrayList<Integer> bookedseats=bookedseat(flightno);
		for(int i=1;(int)i<=avilableseat;i++) {
			if(bookedseats.contains(i))
				continue;
			availableseats.add(i);
		}
		return availableseats;
	}
	public Integer getpnrnumber() {
		return pnrnumber;
	}
	public void setpnrnumber() {
		pnrnumber=null;
	}
	public void save(List<bookingentity> bookes) {
		ticketrepo.saveAll(bookes);
	}
	public bookingentity findbypnrnumber(int pnrnumber) {
		return ticketrepo.findById(pnrnumber).orElse(null);
	}
	public String cancelticket(int pnrnumber) {
		bookingentity be=ticketrepo.findById(pnrnumber).orElse(null);
		if(be==null)
			return "Invalid PNRNumber";
		ticketrepo.delete(be);
		return "Ticket Canceled Successfully";
	}
	public ArrayList<Integer> bookedseat(String flightno){
		return ticketrepo.findavailableseat(flightno);
	}
	public boolean checkcarddetails(String cname,String cnumber,String cvv,String exp) {
		Pattern pn=Pattern.compile("[^0-9]");
		Pattern pt=Pattern.compile("[^a-zA-Z]");
		Pattern pexp=Pattern.compile("[^0-9/]");
		
		Matcher mcnum=pn.matcher(cnumber);
		Matcher mcvv=pn.matcher(cvv);
		Matcher mname=pt.matcher(cname);
		Matcher mexp=pexp.matcher(exp);
		
		if(mcnum.find() || mcvv.find() || mname.find() || mexp.find() || cname=="" || cnumber=="" || cvv=="" || exp=="")
			return true;
		return false;
	}
}
