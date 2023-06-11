<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/Signin.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <title>Signin</title>
</head>
<body>
    <nav>

    </nav>
    <main>
        <div class="signin-container">
            <p class="message"><c:out value="${datas.getWmessage()}"/></p>
            <form action="logindata" class="signin-form">
                <div class="email-block">
                    <div class="label">Email</div>
                    <input type="text" class="email-input login-input" name="email"/>
                </div>
                <div class="password-block">
                    <div class="label">Password</div>
                    <input type="Password" class="password-input login-input" name="password"/>
                </div>
                <div class="submit-block">
                    <input type="submit" class="submit-input" value="Sign in"/>
                </div>
            </form>
            <div class="create-account">
                <p>Not a member? <a href="signup" style="color: red;">Create Account</a><p>
              </div>
        </div>
    </main>
</body>
</html>