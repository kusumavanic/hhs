<!doctype html>
<html>
<head>
<title>Consumer page</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	    <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html"); 
 			  $("#new").load("/hhs/newCatogeory.html"); 
 			   $("#footer").load("/hhs/newFooter.html"); 
  			 $("#newOption").load("/hhs/newCatogeory4.html");
  			 
		});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
			}
		</script>
		<style>
		.navbar-fixed-left {
		  width: 230px;
		  height:391px
		  position: fixed;
		  border-radius: 0;
		  height: 100%;
		  padding-bottom:45%
		}
		
		.navbar-fixed-left .navbar-nav > li {
		  float: none; 
		  width: 139px;
		  font-size:120%
		}
		
		.navbar-fixed-left + .container {
		  padding-left: 100px;
		  padding-right: 100px;
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
	<body id="admin">
	<div id="header"></div>
		  	<div id="add"></div>		
		<#list list as l>
	
		<h3 style="margin-botton:150px">WELCOME ${l.consumerName}</h3>
		<div style="float:left;height:500px;">
			<div class="navbar navbar-fixed-left" style="padding-bottom:20%;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/consumer/${l.id}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/newCatogeory/get/all">AvailableProviders</a></li> 
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/consumer/composeMail">SendRequest Through Email</a></li>     
 			 </ul>
 			 	<span style="float:left;margin-left:20px;margin-top:20px">
					<button class="btn btn-default" value="Show Div" onclick="showDiv()">Send Request</button>
					<div id="welcomeDiv" style="display:none;">
					<h3 style="color:white">Select serviceType</h3>
					<form action="/hhs/rest/consumer/sentRequest/${l.id}" method="POST">
			
				<div id="newOption"></div>
			
				<button class="btn btn-default" type="submit" name="submit">submit</button>
				</form>
				</div>
			</span>
		</div>
			
		</#list> 
		</div>
		
		
		<div class="col-md-4" style="background:white; width:826px;height:400px; float:right;margin-right:200px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:30px">
			<div id="new"></div>
		</div>
		<div class="clearfix"></div>
		<div style="width:100%;height:50px:background:white"></div>
		<div id="footer" style="position:relative"></div>
	</body>
</html>