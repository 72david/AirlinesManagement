<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/checkticket.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <title>checkTicket</title>
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
	                    <li class="this-page-list" >CheckTicket<hr class="this-page"></li>
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
    <main class="container">
        <form action="checkticketdetails" class="search-container">
            <input type="text" placeholder="Enter PNR Number" class="input-text" name="pnrnumber"/>
            <input type="submit" class="input-submit" value="Search" />    
        </form>
        <p class="cancelmessage"><c:out value="${datas.getWmessage()}"/></p>
        <c:if test="${ticketdetails!=null}">
	        <div class="ticket-container">
	            <div class="ticket-name">Name:${ticketdetails.getName()}</div>
	            <div class="ticket-name">Seat No:${ticketdetails.getSeatno()}</div>
	            <div class="flight-details-heading">
	                Flight Details
	            </div>
	            <hr>
	            <table class="ticket-table">
	                <tr class="ticket-table-heading">
	                    <th>From</th> <th>Flight Name</th> <th>Departure Terminal</th> <th>Departure Time</th>
	                </tr>
	                <tr class="ticket-table-data">
	                    <td>${flightdata.getFrom()}</td>
	                    <td>${flightdata.getFlightname()}</td>
	                    <td>${flightdata.getDepartureterminal()}</td>
	                    <td>${ticketdetails.getDate()},${flightdata.getDeparturetime()}</td>
	                </tr>
	            </table>
	            <hr>
	            <table  class="ticket-table">
	                <tr class="ticket-table-heading">
	                    <th>To</th> <th>Flight Number</th><th>Departure Terminal</th> <th>Arrival Time</th>
	                </tr>
	                <tr class="ticket-table-data">
	                    <td>${flightdata.getTo()}</td><td>${flightdata.getFlightno()}</td>
	                    <td>${flightdata.getArrivalterminal()}</td>
	                    <td>${ticketdetails.getDate()},${flightdata.getArrivaltime()}</td>
	                </tr>
	            </table>
		</c:if>
        </div>
    </main>
    <footer>

    </footer>
</body>
</html>