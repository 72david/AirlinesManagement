<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/Signin.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <title>Signup</title>
    </head>
    <body>
        <div id="container">
            <nav>

            </nav>
            <main class="signup-container">
                <p class="message"><c:out value="${datas.getWmessage()}" /></p>
                <form action="userdata">
                    <div class="signup-form">
                        <div id="ufname" class="signup-input-block">
                            <label for="uname">First Name</label>
                            <input class="signup-input" type="text" name="firstname" >
                            
                        </div>
                        <div class="signup-input-block" id="ulname">
                            <label for="ulname">Last Name</label>
                            <input class="signup-input" type="text" name="secondname" >
                        </div>
                        <div class="signup-input-block" id="udob">
                            <div class="signup-date-label">
                                <div><label id="dateofb">Date of Birth</label></div>
                                <div><label id="dateofb">(DD-MM-YYYY)</label></div>
                            </div>
                            <div>
                                <input type="date" name="dateOfBirth" class="signup-input" for="date_label_contanier">
                            </div>
                        </div>
                        <div class="signup-input-block" id="ugender">
                            <label>Gender</label>
                            <select for="ugender" name="gender"class="signup-input">
                                <option></option>
                                <option>Male</option>
                                <option>Female</option>
                                <option>Other</option>
                            </select>
                        </div>
                        <div class="signup-input-block" id="uemail">
                            <label>Email</label>
                            <input class="signup-input" type="text" name="email" >
                        </div>
                        <div class="signup-input-block" id="umobileno">
                            <label>Mobile Number</label>
                            <input type="text" name="phoneNumber" class="signup-input">
                        </div>
                        <div class="signup-input-block" id="umobileno">
                            <label>Password</label>
                            <input type="password" name="password" class="signup-input">
                        </div>
                        <div class="signup-input-block" id="umobileno">
                            <label>Re-Password</label>
                            <input type="password" name="repassword" class="signup-input">
                        </div>
                        <div class="signup-button">
                            <a href="signin"><div class="signup-submit-input">Back</div></a>
                            <input class="signup-submit-input" type="submit" name="submit" value="Sign up">
                        </div>             
                    </div>
                </form>
            </main>
        </div>
    </body>
</html>