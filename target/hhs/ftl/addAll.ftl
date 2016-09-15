<html>
	<head>
		<title>Add Catogeory</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		 <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html");  
 			 $("#newOption").load("/hhs/newCatogeory4.html");
 			 $("#footer").load("/hhs/newFooter.html"); 
		});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
		}
		</script>
		<style>
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
			<div class="navbar navbar-fixed-left" style="padding-bottom:20%;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/consumer/${consumerId}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/newCatogeory/get/all">AvailableProviders</a></li> 
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/consumer/composeMail">Send Request Through Email</a></li>     
 			 </ul>
 			 	<span style="float:left;margin-left:20px;margin-top:20px">
					<button class="btn btn-default" value="Show Div" onclick="showDiv()">Send Request</button>
					<div id="welcomeDiv" style="display:none;">
					<h3 style="color:white">Select serviceType</h3>
					<form action="/hhs/rest/consumer/sentRequest/${consumerId}" method="POST">
			
				<div id="newOption"></div>
			
				<button class="btn btn-default" type="submit" name="submit">submit</button>
				</form>
				</div>
				
			</span>
		</div>
			
		
		
		
		</div>	
		<div class="col-md-4" style="background:white; width:826px;height:400px; float:right;margin-right:200px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:30px">
		<h3 style="text-align:center;color:blue">All Services</h3>
		<#list list as l>
			<div class="col-md-4">
			
	 		<ul style="list-style-type:none">
	 		<li style="font-family:calibri;font-size:140%">
	 		<a href="/hhs/rest/newCatogeory/details/${l.catogeory}" id="${l.catogeory}"><img src="/hhs/image/${l.icon}" width="90" height="70">${l.catogeory}</a></li>
			</ul>
	 		</div>	
	
	 	</#list>
		</div>
		<div class="clearfix"></div>
		<div id="footer" style="podsition:relative"></div>
	</body>
</html>