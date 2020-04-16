<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="google-signin-client_id" content="30270013673-ksta4hc4os22ldfvu45c36k0fetnivk8.apps.googleusercontent.com">
    
    <title>Register Or Login</title>

    <!-- Font Icon -->
   <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/reglogin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>

    <div class="main">
        <div class="container">
        	<p><form:errors cssClass="red" path="user.*"/></p>
            <form:form action="/register" method="POST" class="appointment-form" modelAttribute="user">
                <h2>Registration</h2>
                <div class="form-group-1">
                    <form:input type="text" path="name" name="name" id="name" placeholder="Name"/>
                    <form:input type="email" path="email" name="email" id="email" placeholder="Email" />
                    <form:password path="password" name="password" id="password" placeholder="Password" />
                    <form:password path="passwordConfirmation" name="passwordConfirmation" id="passwordConfirmation" placeholder="Confirm Password" />
	                <div class="form-submit">
	                   <input type="submit" name="submit" id="submit" class="submit" value="Register" />
	                </div>
                </div>
                	<p class="red">${error}</p>
            </form:form>
            <div>
			 <form action="/login" method="POST" class="appointment-form">  
                <div class="form-group-2">
                    <h2>Login</h2>
					<input type="email" name="email" id="email" placeholder="Email" />
					<input type="password" name="password" id="password" placeholder="Password" />
                </div>

                <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Login" />
                </div>
                 <p class="red">${error}</p> 
            </form>  
            </div>
<!-- <div class ="g-signin2" data-onsuccess="onSignIn" style= "width:200px;">Sign In</div> -->
        </div>
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>