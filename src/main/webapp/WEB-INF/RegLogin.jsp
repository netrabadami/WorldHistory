<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
   <div class="container-main">

    <div class="container">
        <div class="rowtext">
            <div class="col-11"><h1>Welcome Sign in to know your world!</h1></div>
        </div>       
        <div class="row">
            <div class="col-6"><h2>Registration</h2></div>
            <div class="col-6"><h2>Login</h2></div>
        </div>
        <div class="row">
        	<div class="col-6">
                <form:form method="POST" action="/registration" modelAttribute="user">
                    <div class="form-group row">
                    	<form:label cssClass="col-sm-4 col-form-label col-form-label-sm" path="name">Name:</form:label>
                        <div class="col-sm-6">
                          <form:input type="text" cssClass="form-control form-control-sm" path="name"/>
                        </div>
                    </div>
                    <div class="form-group row">
                    	<form:label cssClass="col-sm-4 col-form-label col-form-label-sm" path="email">Email:</form:label>
                        <div class="col-sm-6">
                          <form:input type="email" cssClass="form-control form-control-sm" path="email"/>
                        </div>
                    </div>
                    <div class="form-group row">
                    	<form:label path="password" cssClass="col-sm-4 col-form-label col-form-label-sm">Password:</form:label>
                        <div class="col-sm-6">
                          <form:password path="password" cssClass="form-control form-control-sm"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="passwordConfirmation" cssClass="col-sm-4 col-form-label col-form-label-sm">Password Confirmation:</form:label>
                        <div class="col-sm-6">
                          <form:password path="passwordConfirmation" cssClass="form-control form-control-sm"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                          <button type="submit" class="btn btn-dark float-right">Register</button>
                        </div>
                    </div>
                    <p><form:errors cssClass="red" path="user.*"/></p>
                    <form:errors cssClass="red" path="name"/>
                    <p class="red">${error}</p>
                  </form:form>
            </div>
            <div class="line"></div>
            <div class="col-5">
                <form action="/login" method="post">
                
                    <div class="form-group row">
                        <label for="email" class="col-sm-4 col-form-label col-form-label-sm">Email</label>
                        <div class="col-sm-6">
                        <input type="email" class="form-control form-control-sm" id="email" name="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-4 col-form-label col-form-label-sm">Password</label>
                        <div class="col-sm-6">
                        <input type="password" class="form-control form-control-sm" id="password" name="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                        <button type="submit" class="btn btn-dark float-right ">Login!</button>
                        </div>
                    </div>
                    <p class="red">${error}</p>
            </form>
            </div>
        </div>
    </div>
     </div>

    
</body>
</html>