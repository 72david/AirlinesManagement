<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/cancelticket.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <title>cancelTicket</title>
</head>
<body>
			<nav>
	            <ul class="navigation-ul">
	                <li class="navigation-ul-first-child"><img class="logo-img" src="images/airplane-logo.png" /></li>
	                <a href="index" >
	                    <li class="navigation-list">Home</li>
	                </a>
	                <a href="tickets" >
	                	<li class="navigation-list" >Tickets</li>
	            	</a>
	                <a href="checkticket" >
	                    <li class="navigation-list" >CheckTicket</li>
	                </a>
	               <a href="cancelticket" >
	                	<li class="this-page-list">Cancel Ticket<hr class="this-page"></li>
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
    <main class="container">
        <form action="checkticketdetails" class="search-container">
            <input type="text" placeholder="Enter PNR Number" class="input-text" name="pnrnumber"/>
            <input type="submit" class="input-submit" value="Search" />
            
        </form>
        <p class="cancelmessage"><c:out value="${datas.getWmessage()}"/></p>
        <c:if test="${ticketdetails!=null}">
            <div class="ticketdetails">
                <div class="ticketrow">
                	<span>${flightdata.getDeparturetime()}--${flightdata.getArrivaltime()}</span>
                	<span style="margin:0 0 0 -80px;">${ticketdetails.getName()}</span>
                	<span>$${flightdata.getPrice()}</span>
                </div>
                <div class="ticketrow">
                	<span>${flightdata.getFlightname()}</span>
                	<span style="margin:0 0 0 80px;" >${ticketdetails.getDate()}</span>
                	<span>${flightdata.getFrom()} to ${flightdata.getTo()}</span>
                </div>
            </div>
            <a href="ticketcancel?pnrnumber=${ticketdetails.getPnrnumber()}" >
            	<input type="submit" class=" cancel-input" value="Cancel Ticket" />
            </a>
        </c:if>
    </main>
    <footer>

    </footer>
</body>
</html>