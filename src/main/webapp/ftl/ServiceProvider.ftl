<!doctype html>
<html>
	<head>		
		<title>
			Join with Household Services
		</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<meta name="google-signin-client_id" content="518852838024-c2rbvo1r3do97r6ufp1k49an4qndqpah.apps.googleusercontent.com">
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
 	    <script src="https://apis.google.com/js/platform.js" async defer></script>
		
		<script src="/hhs/valid.js"></script> 
  		<script> 
		$(function(){
 			 $("#newOption").load("/hhs/newCatogeory4.html"); 
  			 $("#footer").load("/hhs/newFooter.html");
  			 $("#side").load("/hhs/side.html"); 
	   		 $("#submit").click(function(){
	   				alert("you are successfully registered..!!!");   				
	   		});
		});
		
		</script>
		<style>
		div#header {
			width: 100%;
			height: 120px;
			background: #6BAAEA;
			margin:0;
			padding:0px;
		}

		body{
			margin:0;
			padding:0;
		}
	</style>
	</head>
	<body>
	<html>
	<div id="header">
		 <a href="/hhs/rest/index"><img src="/hhs/image/logo.jpg" style="height:120px;width:17%; float:left;margin:0px" alt="logo"/></a>
	 <div style="margin-left:160px;float:left;color:white;margin-top:30px"><h1><i>House Hold Services</i></h1></div>	
	 <div  style="float:right;margin-top:67px">
  		 <nav class="navbar navbar-inverse">
           	<div class="container-fluid">
  		   	 <ul class="nav navbar-nav">  
  		   	 		
  		    		 <li style="margin-top:8px" id="googleSignInButton" class="g-signin2" data-onsuccess="onSignIn"></li>
        		 	 <li ><a href="/hhs/rest/index">Home<span class="glyphicon glyphicon-home"></span></a></li>
        
        	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Register<span class="glyphicon glyphicon-user"></span></a>
			      <ul class="dropdown-menu dropdown-menu-right">			     
	         		   <li><a href="/hhs/rest/index/providerRegistration">Registration for Service Provider</a></li> 
					   <li><a href="/hhs/rest/index/consumerRegistration">Registration for Service Consumer</a></li> 
	              </ul>
	          </li>
        		 
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Login<span class="glyphicon glyphicon-log-in"></span> </a>
				 <ul class="dropdown-menu dropdown-menu-right">
					   <li><a href="/hhs/rest/index/adminLogin">Admin Login</a></li>
					   <li><a href="/hhs/rest/index/providerLogin">Provider Login</a></li>
					   <li><a href="/hhs/rest/index/consumerLogin">Consumer Login</a></li>
					   <li><a href="/hhs/rest/index/guestLogin">Guest Login</a></li> 						   
				</ul>
			</li>
			
			</ul>
			</div>
						 
	    </nav>
	     
        </div>
       <div class="clearfix"></div>
	</div>
	
	
	</div>
	<div class="col-md-offeset-2">	
		<div style="width:900px;height:700px;float:left;margin-left:50px">
		
			<div class="col-md-12" >	
				<div class="col-md-8 col-md-offset-2 col-xs-12">
					<h1 >Provider Registration</h1>
					<hr id="line1" align="left" >
				</div>
			</div>
		<form  action="/hhs/rest/provider" method="POST">
		
		<div class="container">
		<div class="col-md-12" >
			<div class="col-md-4">
                	<div class="form-group">		
						<label ><b>Service Provider Name</b></label>
						<input type="text" name="providerName" class="form-control" id="serProviderName" placeholder="Enter your name" required>
						<span id="span-name"></span>
					</div>
			</div>
			
			
			<div class="col-md-4">
			<div class="form-group">
				<label><b>Mobile Number</b></label>
				<input type="text" name="mobileNumber"  class="form-control" id="serMobileNumber" placeholder="Enter 10 digit mobile no" required>
				<span id="span-mobile"></span>
			</div>
			<span></span>
			</div>
			
		</div>
		<div class="col-md-12" >
			
			<div class="col-md-4">
			<div class="form-group">
				<label><b>Email Id</b></label>
				<input type="email" name="emailId" class="form-control" id="serEmail" placeholder="Enter email Eg:abc@gmail.com" required>
				<span id="span-email"></span>
			</div></div>
			
			<div class="col-md-4">
			<div class="form-group">
				<label><b>Location</b></label>
				<input type="text" name="location" class="form-control" id="serLocation"  placeholder="Enter location Eg:Madhapur" required>
				<span id="span-location"></span>
			</div></div>	
	</div>
	<div class="col-md-12" >
			
			
			<div class="col-md-4">
			<div class="form-group">
			<label><b>City</b></label>
			<input type="text" name="city"  class="form-control" id="serCity"  placeholder="Enter name of city Eg:Hyderabad" required>
			<span id="span-city"></span>
			</div></div>
			
			<div class="col-md-4">
			
				<div id="newOption"></div>

			</div>
	</div>	
		<div class="col-md-12" >	
			<div class="col-md-4 col-md-offset-2 ">
			<div class="form-group">
				<label><b>Password</b></label>
				<input type="password" name="password"  class="form-control" id="serPassword" placeholder="Enter Password" required>
				<span id="span-password"></span>
			</div></div>
		</div>	
		<div class="col-md-12" >
			<div class="col-md-4 col-md-offset-2 ">
			<div class="form-group">
				<label><b>Confirm Password</b></label>
				<input type="password" name="confirmPassword"  class="form-control" id="serConfirmPassword" placeholder="ReEnter Password" required>
				<span id="span-cpassword"></span>
			</div></div>
		</div>
		<div class="col-md-12" >	
			<div class="col-md-4 col-md-offset-3 ">
			<div class="form-group">
                        <div class="checkbox">
                            <label  >
                                <input type="checkbox" name="checkbox" required>
                                I agree to the terms and conditions.
                            </label>
                        </div></div>
			 <button type="submit" class="btn btn-primary" id="submit">Submit</button>
			 <button type="reset" class="btn btn-primary">Reset</button>
                    </div></div>
		</div>
		</form>
	</div>
	</div>
	</div>
		<div id="side">			
		</div>	
	</div>
		
	<div class="clearfix"></div>
	
 	<div id="footer"></div>
		<script>			
			 function onSignIn(googleUser){
				  var profile = googleUser.getBasicProfile();
				  console.log('ID: ' + profile.getId()); 
				  console.log('Name: ' + profile.getName());
				  console.log('Image URL: ' + profile.getImageUrl());
				  console.log('Email: ' + profile.getEmail());
				  var id=googleUser.getAuthResponse().id_token;
				  var xhttp = new XMLHttpRequest();
				  document.getElementById('googleSignInButton').addEventListener("click",function(){
					  xhttp.onreadystatechange = function() {
					    if (xhttp.readyState == 4 && xhttp.status == 200) {
					      window.open("/hhs/rest/user/google?idtoken="+id,"_top");
					    }
					  };
					  xhttp.open("GET", "/hhs/rest/user/google?idtoken="+id, true);
					  xhttp.send();
					  });
			 }
		</script>
	</body>
</html>