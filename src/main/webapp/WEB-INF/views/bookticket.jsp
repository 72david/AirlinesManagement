<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="styles/bookticket.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <title>BookTicket</title>
</head>
<body style="margin:0;">
		 	<nav>
            <ul class="navigation-ul">
                <li class="navigation-ul-first-child"><img class="logo-img" src="images/airplane-logo.png" /></li>
                <a href="index" >
                    <li class="navigation-list ">Home</li>
                </a>
                <a href="tickets" >
                    <li class="this-page-list">Tickets<hr class="this-page"></li>
                </a>
                <a href="checkticket" >
                    <li class="navigation-list">CheckTicket</li>
                </a>
               <a href="cancelticket" >
                	<li class="navigation-list" >Cancel Ticket</li>
            	</a>
                <c:choose>
				  <c:when test="${datas.getAccountstatus()==1}">
	                <a href="logout" >
	                    <li class="navigation-list">Log out</li>
	                </a>
	              </c:when>	
	              <c:otherwise>
	              	<a href="signin" >
	                    <li class="navigation-list">Sign in</li>
	                </a>
	              </c:otherwise>
				</c:choose>
            </ul>
        </nav>
    <section class="container">
        <p class="message" style="color:green;"><c:out value="${datas.getWmessage()}"/></p>
         <c:if test="${pnrnumber!=null}"><p class="pnrnumber">PRN Number:${pnrnumber}</p></c:if>
        <form action="booknow?" class="form-container">
            <div class="input">Name<input name="name" placeholder="Name" type="text"  class="input-text"/></div>
            <div class="input" >Mobile Number<input placeholder="Mobile Number" name="phonenumber" type="text" class="input-text" /></div>
            <div class="input">Age<input  placeholder="Age" name="age" type="text"  class="input-text" /></div>
            <div class="input">Seat No
                <select name="seatno"  class="input-text seat-select-input">
                    <option style="display:none;"></option>
                    <c:forEach items="${availableseats}" var="seatno">
	                    <option><c:out value="${seatno}"/></option>
	                </c:forEach> 
                </select>
            </div>
            <div ><input name="flightno" style="display:none" value="${ticketdata.getFlightno()}" /></div>
            <div class="input" style="padding-right:115px;">Gender
                <input  type="radio" name="gender" value="Male"/><label class="gender-label">Male</label>
                <input type="radio" name="gender" name="Female"/><label class="gender-label">Female</label>
                <input type="radio" name="gender" name="Other"/><label class="gender-label">Other</label>
            </div>
            <div class="input-price ">
            	<div class="ticket-price-label">Price</div> 
            	<div class="ticket-price">${ticketdata.getPrice()}</div>
            </div>
            <p class="card-heading">Credit Card Details</p>
            
            <div class="input">Card Holder<input type="text" placeholder="Holder Name" name="cardname" class="input-text" /></div>
            <div class="input">Card Number<input type="text" placeholder="Card Number" name="cardnumber" class="input-text" /></div>
            <div class="input card-data">
                <div>CVC<input placeholder="ex.123" type="text" style="margin-right: 70px;" class="input-card" name="cvv"></div>
                <div>EXPIRY Date<input name="exp" placeholder="MM / YY" type="text" class="input-card" /></div>
            </div>
            <div class="input"><input type="submit" style="margin:20px 170px 15px 0; " value="Book" class="input-submit" name="submit"/></div>
        </form>
    </section>
</body>
</html>