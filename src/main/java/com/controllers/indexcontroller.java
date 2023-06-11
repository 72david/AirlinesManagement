package com.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Models.*;
import com.Repository.TicketsRepository;
import com.service.*;

@RestController
public class indexcontroller {
	
	@Autowired	
	TicketsRepository ticketrepo;
	
	@Autowired	
	ticketservice ticketser;
	
	@Autowired
	CheckDatas Checkdata;
	
	@Autowired
	Variables var;
	
	@Autowired 
	flightservice flightser;
	
	private static ModelAndView view;
	private Airoplanedetails airoplanedetails;
	private String date;
	
	@RequestMapping("index")
	public ModelAndView index(){
		if(view==null) {
			view=new ModelAndView();
			view.addObject("datas",var);
			}
		view.setViewName("index");
		return view;
	}
	@GetMapping("signin")
	public ModelAndView causal() {
		var.setWmessage(null);
		view.setViewName("signin");
		return view;
	}
	@RequestMapping("logindata")
	public ModelAndView logindata(String email,String password){
		String login=Checkdata.Logindata(email,password);
		if(login==null) {
			var.setAccountstatus(1);
			view.setViewName("index");	
		}
		var.setWmessage(login);
		return view;
	}
	@GetMapping("signup")
	public ModelAndView signup() {
		var.setWmessage(null);
		view.setViewName("signup");
		return view;
	}
	@RequestMapping("userdata")
	public ModelAndView adduserdetails(userdetails userdata,String repassword) {
		if(repassword.equals(userdata.getPassword())) {
			var.setWmessage(Checkdata.Signupdata(userdata));
		}
		else{
			var.setWmessage("Password Not Matching With repassword");
		}
		return view;
	}
	@GetMapping("tickets")
	public ModelAndView flights() {
		var.setWmessage("Search......");
		view.addObject("searchresults",null);
		view.addObject("from",flightser.findallfrom());
		view.addObject("to",flightser.findallto());
		view.setViewName("Tickets");
		return view;
	}
	
	@RequestMapping("ticketsearch")
	public ModelAndView searchrespond(String from,String to,String date) throws Exception {
		
		ArrayList<Airoplanedetails> flight=flightser.flights(from,to,date);
		if(flight==null)
			var.setWmessage("Invalid Date");
		else if(flight.size()==0)
			var.setWmessage("No Flights Found");
		else
			var.setWmessage(null);
		view.addObject("searchresults",flight);
		this.date=date;
		view.setViewName("Tickets");
		return view;
	}	
	@RequestMapping("ticket")
	private ModelAndView ticket(String flightno) {
		Airoplanedetails ad=flightser.findbyflightno(Integer.parseInt(flightno));
		ad.setDeparturedate(this.date);
		ad.setArrivaldate(this.date);
		this.airoplanedetails=ad;
		view.addObject("ticketdata",ad);
		view.addObject("availableseats", ticketser.availableseat(flightser.totalseat(flightno),flightno) );
		view.setViewName("bookticket");
		return view;
	}
	@GetMapping("bookticket")
	public ModelAndView bookTicket() {
		var.setWmessage(null);
		view.setViewName("bookticket");
		return view;
	}
	@GetMapping("booknow")
	private ModelAndView booknow(bookingentity bookticketdata,String cardname,String cardnumber,String exp,String cvv) {
		if(ticketser.checkcarddetails(cardname,cardnumber,cvv,exp)) {
			var.setWmessage("Wrong card details");
			return view;
		}
		var.setWmessage(ticketser.bookticket(bookticketdata,this.airoplanedetails));
		view.addObject("pnrnumber",ticketser.getpnrnumber());
		ticketser.setpnrnumber();
		return view;
	}
	@GetMapping("checkticket")
	private ModelAndView checkTicket() {
		view.addObject("ticketdetails",null);
		var.setWmessage(null);
		view.setViewName("checkticket");
		return view;
	}
	@GetMapping("cancelticket")
	private ModelAndView cancelTicket() {
		view.addObject("ticketdetails",null);
		var.setWmessage(null);
		view.setViewName("cancelticket");
		return view;
	}
	@GetMapping("ticketcancel")
	private ModelAndView cancelTicket(String pnrnumber) {
		var.setWmessage(ticketser.cancelticket(Integer.parseInt(pnrnumber)));
		view.addObject("ticketdetails",null);
		return view;
	}
	@GetMapping("checkticketdetails")
	private ModelAndView checkTicketdetails(String pnrnumber) {
		bookingentity be=ticketser.findbypnrnumber(Integer.parseInt(pnrnumber));
		if(be==null) {
			var.setWmessage("NO Ticket Found");
			be=null;
		}
		else {
			view.addObject("flightdata",flightser.getflightdetails(Integer.parseInt(be.getFlightno())));
			var.setWmessage(null);
		}
		view.addObject("ticketdetails",be);
		return view;
	}
	
	@GetMapping("logout")
	public ModelAndView LogOut() {
		var.setAccountstatus(0);
		return view;
	}
}