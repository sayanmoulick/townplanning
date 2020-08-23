<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="32x32" href="images/TP-Icon.png">
<link rel="icon" type="image/png" sizes="16x16" href="images/TP-Icon.png">
<title>Blog Template for Bootstrap</title>
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/blog/">
<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
<!-- <link href="blog.css" rel="stylesheet"> -->
<style>
     a{
/* color: #343A40; */
      }
   </style>
</head>
<body>
	<div class="container">
		<div class="">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
          <div class="container">
            <a class="navbar-brand" href="index.html">Town Planning</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">General Department
                    <span class="sr-only">(current)</span>
                  </a>
                </li>
                <li class="nav-item dropdown"> <!-- add "show" to activate this nav li -->
                  	<a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Departments</a>
		  		  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
	    		    <a class="dropdown-item" href="#">Works Department</a>
	    		    <a class="dropdown-item" href="#">Health Department</a>
	    		    <a class="dropdown-item" href="#">Council Department</a>
	    		    <a class="dropdown-item" href="#">General Department</a>
			    	<a class="dropdown-item" href="#">Revenue Department</a>
			    	<a class="dropdown-item" href="#">Buildings Department</a>
	    		    <a class="dropdown-item" href="#">Family Welfare Department</a>
	    		    <a class="dropdown-item" href="#">Land and Estate Department</a>
			    	<a class="dropdown-item" href="#">Financial Management Department</a>
			    	<a class="dropdown-item" href="#">Solid Waste Management Department</a>
  		         </div>
                </li>
                <li class="nav-item" style="cursor: pointer">
                  <a class="nav-link">Hi! <%=session.getAttribute("username") %></a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                  <a class="nav-link">Sign Out</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
	
	</div>

</body>
</html>