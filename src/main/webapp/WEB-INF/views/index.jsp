<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css"/>
    <link rel="stylesheet" href="styles/style-home.css"/>
    <title>BookFlight</title>
</head>
<body>
    <img src="images/aeroplane.jpg" class="background-img">
    <div class="container">  
        <nav>
            <ul class="navigation-ul">
                <li class="navigation-ul-first-child"><img class="logo-img" src="images/airplane-logo.png" /></li>
                <a href="index" >
                    <li class="this-page-list ">Home<hr class="this-page"></li>
                </a>
                <a href="tickets" >
                    <li class="navigation-list">Tickets</li>
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
        <section class="section-1">
           <p class="title" >Hi,Where would you like to go?</p>
           <a href="tickets"><div class="booknow-button">Book Now</div></a>
        </section>
        
        <footer>

        </footer>
</body>
</html>