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
    <title>Admin Form</title>

    <!-- Font Icon -->
   <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/reglogin.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    

</head>
<body>

    <div class="-1">
        <div class="container">
        	<%-- <p><form:errors cssClass="red" path="continents.*"/></p> --%>
            <form:form action="/createContinents" method="POST" class="appointment-form" modelAttribute="continents">
                
                <div class="row">
                	<div class="col-3"><h2>Continents</h2></div>
                	<div class="col-2"><a href="/logout"><h2>Logout</h2></a></div>
                </div>
                
                <div class="form-group-1">
                    <form:input type="text" path="continent_name" name="continent_name" id="continent_name" placeholder="Continent Name"/>
	                <div class="form-submit">
	                   <input type="submit" name="submit" id="submit" class="submit" value="Create Continent" />
	                </div>
                </div>
                	<p class="red">${error}</p>
                	<h2>Countries</h2>
            </form:form>
            
           <form:form action="/createCountries" method="POST" class="appointment-form" modelAttribute="countries">
       		<!-- <h2>Countries</h2>  -->
                <div class="form-group-2">
                   <form:select cssClass="box" path="continents">
						<c:forEach items="${continentList}" var="continent">
							<form:option value="${continent.id}"><c:out value="${continent.continent_name}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
                    <form:input type="text" path="country_name" name="country_name" id="country_name" placeholder="Country Name"/>
	                <form:textarea path="description" rows="1" cols="90" placeholder="Country Description"/>
	                <div class="form-submit">
	                   <input type="submit" name="submit" id="submit" class="submit" value="Create Country" />
	                </div>
                </div>
                	<p class="red">${error}</p>
                	<h2>Sites</h2>
            </form:form>
             <form:form action="/createSite" method="POST" class="appointment-form" modelAttribute="sites">
                
                <div class="form-group-2">

				   <form:select cssClass="box" path="countries">
						<c:forEach items="${countryList}" var="country">
							<form:option value="${country.id}"><c:out value="${country.country_name}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
					<form:input type="text" path="city_name" name="city_name" id="city_name" placeholder="City Name"/>
                    <form:input type="text" path="site_name" name="site_name" id="site_name" placeholder="Site Name"/>
	                <form:textarea path="description" rows="1" cols="90" placeholder="Site Description"/>
	                <div class="form-submit">
	                   <input type="submit" name="submit" id="submit" class="submit" value="Create Site" />
	                </div>
                </div>
                	<p class="red">${error}</p>
            </form:form>

        </div>
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>