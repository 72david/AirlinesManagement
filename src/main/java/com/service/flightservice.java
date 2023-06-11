package com.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Models.*;
import com.Repository.*;

@Service
public class flightservice {
	
	@Autowired
	AiroplaneRepository Airoplanerepo;
	
	public ArrayList<Airoplanedetails> flights(String from,String to,String date) {
		LocalDate Currentdate=LocalDate.parse(LocalDate.now().toString());
    	LocalDate Clientdate=LocalDate.parse(date);
    	if(Clientdate.compareTo(Currentdate)<0)
    		return null;
    	ArrayList<Airoplanedetails> flightlist=Airoplanerepo.findbyfrom(from,to);
    	flightlist.forEach((n)->{
    		n.setDeparturedate(date);
    		n.setArrivaldate(date);
    	});
    	
		return flightlist; 
	}
	public int totalseat(String flightno){
		Airoplanedetails details=findbyflightno(Integer.parseInt(flightno));
		return details.getAvailableseat();
	}
	
	public ArrayList<String> findallfrom() {
		return Airoplanerepo.findAllfrom(); 
	}
	public ArrayList<String> findallto() {
		return Airoplanerepo.findAllto(); 
	}
	public Airoplanedetails getflightdetails(int flightno) {
		return Airoplanerepo.findById(flightno).orElse(null);
	}
	public Airoplanedetails findbyflightno(int flightno) {
		return Airoplanerepo.findById(flightno).orElse(null); 
	}
}