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
					 <form action="/info" method="POST" class="appointment-form">  
					 <h2>Information Center</h2>
		               <div class="form-group-1">
		                    <select id="continent" name="continent" size="1">
		                     <option value="" selected="selected">Select Continent</option>
		                      <option value="europe">Europe</option>
							  <option value="america">America</option>
							  <option value="africa">Africa</option>
							  <option value="asia">Asia</option> 
							</select>
							
							<p></p><p></p><p></p>
					        <select id="country" name="country" size="1">
					          <option value="#" selected="selected">Select Country</option>
					          <option value="egypt">Egypt</option>
					          <option value="england">England</option>
							  <option value="india">India</option>
							  <option value="iran">Iran</option>
							  <option value="italy">Italy</option>
							  <option value="mexico">Mexico</option>
							  <option value="southKorea">South Koreas</option>
							  
							  <option value="vietnam">Vietnam</option>
							</select>
							<textarea rows="2" cols="90" name="countryDesc">Country Description</textarea>
							<p></p><p></p><p></p>
							<input type="text" name="city" id="city" placeholder="City" />
							<input type="text" name="site" id="site" placeholder="Site" />
							<textarea rows="2" cols="60" name="siteDesc">Site Description</textarea>
							<p></p>
							<p></p>
		                </div>
		
		                <div class="form-submit">
		                    <input type="submit" name="submit" id="submit" class="submit" value="Submit" />
		                </div>
		                 <p class="red">${error}</p> 
		            </form>
                </div>
                	<p class="red">${error}</p>
     


        </div>
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>