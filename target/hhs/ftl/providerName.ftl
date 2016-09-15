
<html>
	<head>
		<meta name="google-signin-client_id" content="518852838024-c2rbvo1r3do97r6ufp1k49an4qndqpah.apps.googleusercontent.com">
		<title>Service Provider details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  		 
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	    <script src="https://apis.google.com/js/platform.js" async defer></script>  
 	    <script src="/hhs/indexProvider.js"></script>
 	    <script> 
		$(function(){
  			 $("#footer").load("/hhs/newFooter.html");
		});
		</script>
		
 	   <style>
		table, th, td {
		   	border: 1px solid #0400FF;
		   	padding: 10px !important;
		   	text-align: center;
		}
		table {
		    color: #0F0FC5;
			margin-left:200px;
			padding: 10px 5px ;
			width:20%;
			background-color:#C1E3FF !important;
		}
		th {
		    text-align: center !important;
		}
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
			<button id="catogeory" value="${list}" hidden></button>
		
			<div class="col-md-offset-2" style="margin-top:20px">
			
		<div id="listDisplay"></div>
		<div id="searchDisplayButtons" class="pagination" style="margin-left:240px"><ul ></ul>
		</div>
		
		
		</div>
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