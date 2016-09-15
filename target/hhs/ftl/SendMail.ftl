<html>
	<head>
		<title>Send Mail</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
 	     <script>  	    
			$(function(){
	 			 $("#header").load("/hhs/newHeader1.html"); 
	 			  $("#footer").load("/hhs/newFooter.html"); 
	 			 $("#newOption").load("/hhs/newCatogeory4.html");  
	  			 $("#button").click(function(){
						alert("your message is successfully send to provider...!!!");
				 });
			});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
		}
		</script>
		<style>
		div#header {
			width: 100%;
			height: 700px;
			background: #6BAAEA;
			margin:0;
			padding:0px;
		}

		body{
			margin:0;
			padding:0;
		}
			.navbar-fixed-left {
		  width: 230px;
		  position: fixed;
		  border-radius: 0;
		  height: 100%;
		  padding-bottom:45%;
		}
		
		.navbar-fixed-left .navbar-nav > li {
		  float: none; 
		  width: 139px;
		  font-size:120%
		}
		
		.navbar-fixed-left + .container {
		  padding-left: 200px;
		}
		
		.navbar-fixed-left .navbar-nav > li > .dropdown-menu {
		  margin-top: -50px;
		  margin-left: 140px;
		}
		.navli :hover{
			background-color:black !important;
		}
		</style>
		
	</head>
	<body>
		<div id="header"></div>
		<div id="side" style="float:left">
		<#list list as l>
			<div class="navbar navbar-fixed-left" style="padding-bottom:20%;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/login/consumer/${l.providerId}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/newCatogeory/get/all">AvailableProviders</a></li> 
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/consumer/composeMail">Send Request Through Email</a></li>     
 			 </ul>
 			 	<span style="float:left;margin-left:20px;margin-top:20px">
					<button class="btn btn-default" value="Show Div" onclick="showDiv()">Send Request</button>
					<div id="welcomeDiv" style="display:none;">
					<h3 style="color:white">Select serviceType</h3>
					<form action="/hhs/rest/consumer/sentRequest/${l.providerId}" method="POST">
				
				<div id="newOption"></div>
			
				<button class="btn btn-default" type="submit" name="submit">submit</button>
				</form>
				</div>
			</span>
		</div>
		</#list>
		
		
		</div>
		<div class="col-md-4" style="background:white; width:426px;height:530px; float:right;margin-right:300px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:10px;margin-top:10px">
		<div class="container">
			<form action="/hhs/rest/sendEmail/request" method="POST">
					<div class="col-md-4">
					<h4>Compose Email</h4>
						<div class="form-group">
			             	<label>From:</label><input class="form-control" type="text" id="fromEmail" name="fromEmail" placeholder="enter sent email address"/><p id="warn" style="color:blue" >You need to turn on secure apps</p>
			            </div>
			            <div class="form-group">
			             	<label>Password:</label><input class="form-control" type="password" id="password" name="password" placeholder="enter password"/>
			            </div>
			            <div class="form-group">
			             	<label>To:</label><input class="form-control" type="text" id="toEmail" name="toEmail" placeholder="enter to email address"/>
			            </div>
			            <div class="form-group">
			             	<label>Subject</label><input class="form-control" type="text" id="subject" name="subject" placeholder="enter subject here"/>
			       		 </div>
			       		 <div class="form-group">
		    				<label>Write body here</label>
		   					<textarea class="form-control" id="body" name="body" rows="3"></textarea>
		  				 </div>
	  					<button class="btn btn-primary" id="button" type="submit">submit</button>
	  					<button class="btn btn-primary" id="button" type="reset">Reset</button>
  				</form>
	        </div>	
	        <div class="clearfix"></div>
	        </div>
        </div>
        
        <div id="footer" style="position:relative"></div>
	</body>
</html>