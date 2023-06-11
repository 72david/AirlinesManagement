<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css" />
    <link rel="stylesheet" href="styles/bookticket.css" />
    <title>Airlines</title>
</head>
<body style="margin:0;">
   		 <nav>
            <ul class="navigation-ul">
                <li class="navigation-ul-first-child"><img class="logo-img" src="images/airplane-logo.png" /></li>
                <a href="index" >
                    <li class="navigation-list">Home</li>
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
    <main>
        <section class="section-1">
            
            <form action="ticketsearch" class="search-container">
                <div>
                	<select class="select-input" name="from" >
                        <option style="display:none"></option>
                        <c:forEach items="${from}" var="from">
                    	<option>${from}</option>
                    	</c:forEach>
                    </select>
                </div>
                <div>
                    <select class="select-input" name="to" >
                        <option style="display:none"></option>
                        <c:forEach items="${to}" var="to">
                    	<option>${to}</option>
                    	</c:forEach>
                    </select>
                </div>
                <div>
                    <input class="search-input" type="date" placeholder="To:" name="date" />
                </div>
                <input class="search-input-submit" type="submit" value="Search" />
            </form>
            <div class="details-list">
                <p class="message"><c:out value="${datas.getWmessage()}"/></p>
                <c:if test="${searchresults.size()>0}" >
	                <c:forEach var="data" items="${searchresults}">
	                    <a href="ticket?flightno=${data.getFlightno()}"><div class="ticketdetails">
	                        <div class="ticketrow">
	                        	<span>${data.getDeparturetime()}-${data.getArrivaltime()}</span><span>$${data.getPrice()}</span>
	                        </div>
	                        <div class="ticketrow">
	                        	<span>${data.getFlightname()}</span><span>${data.getFrom()} to ${data.getTo()}</span>
	                        </div>
                		</div></a>
	                </c:forEach>
	             </c:if>
            </div>
        </section>
    </main>
    <footer>
    </footer>
</body>
</html>