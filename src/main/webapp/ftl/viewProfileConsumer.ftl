<html>
	<title>
			View Profile
	</title>
	<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	     <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html"); 
 			 $("#footer").load("/hhs/newFooter.html"); 
 			 $("#newOption").load("/hhs/newCatogeory4.html");
 			 $("#sub").click(function(){
	   			alert("your profile is successfully edited..!!!");  				
	   		});
		});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
			   
			}
		function showDiv1(){
			 document.getElementById('welcomeDiv1').style.display = "block";
		}
		</script>
		<style>
			.navbar-fixed-left {
		  width: 230px;
		  position: fixed;
		  border-radius: 0;
		  height: 696px;
		  padding-bottom:25%;
		}
		
		.navbar-fixed-left .navbar-nav > li {
		  float: none; 
		  width: 139px;
		  font-size:120%
		}
		
		.navbar-fixed-left + .container {
		  padding-left: 200px;
		}
		.navli :hover{
			background-color:black !important;
		}
		</style>
	<body>
	<div id="header"></div>
	<#list list as l>
	<div id="side" style="width:200px;height:500px;float:left">
			<div class="navbar navbar-fixed-left" style="padding-bottom:20%;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli" ><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/consumer/${l.id}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/newCatogeory/get/all">AvailableProviders</a></li> 
     			 <li class="navli"><a  style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/consumer/composeMail">Send Request Through Email</a></li>     
 			 </ul>
 			 	<span style="float:left;margin-left:20px;margin-top:20px">
					<button class="btn btn-default" value="Show Div1" onclick="showDiv1()">Send Request</button>
					<div id="welcomeDiv1" style="display:none;">
					<h3 style="color:white">Select serviceType</h3>
					<form action="/hhs/rest/consumer/sentRequest/${l.id}" method="POST">
			
				<div id="newOption"></div>
			
				<button class="btn btn-default" type="submit" name="submit">submit</button>
				</form>
				</div>
			</span>
</div>
	
	</div>

			<div class="col-md-4" style="background:white; width:726px;height:650px; float:right;margin-right:100px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:30px;margin-top:20px">
			<h2 style="color:#166F10;margin-left:100px;margin-top:0px;margin-bottom:35px">${l.consumerName} Profile</h2>
			
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:100px"><b>Name :</b></label> ${l.consumerName}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:100px"><b>Email :</b></label> ${l.emailId}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:70px"><b>Alt Email :</b></label> ${l.altEmailId}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:20px"><b>MobileNumber :</b></label>${l.mobileNumber}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:70px"><b>Location :</b></label>${l.location}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:120px"><b>City :</b></label>${l.city}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:65px"><b>Password :</b></label>${l.password}</div>
			<div style="color:blue;font-size:20px;margin-left:50px"><label style="margin-right:20px"><b>Registion Date :</b></label>${l.createdAt}</div>
			
			
				<button class="btn btn-primary" value="Show Div" onclick="showDiv()" style="width:100px;height:40px;margin-left:50px;margin-top:30px">EDIT</button>
			<form action="/hhs/rest/consumer/editConsumer/${l.id}" method="POST">
				<div id="welcomeDiv" style="display:none;background:rgba(223, 240, 216, 0.69); width:600px;height:200px;margin-left:100px">
					<div><label style="color:#010513;margin-bottom:10px;margin-top:10px;margin-right:71px">Email:</label><input type="text" name="email" placeholder="Edit email Id" ></div>
					<div><label style="color:#010513;margin-bottom:10px;margin-top:10px;margin-right:50px">Alt Email:</label><input type="text" name="altEmail" placeholder="Edit altEmail Id" ></div>
					<div><label style="color:#010513;margin-bottom:10px;margin-top:10px;margin-right:10px">MobileNumber:</label><input type="number" name="mobileNumber" placeholder="Edit MobileNumber Id"></div>
					<div><label style="color:#010513;margin-bottom:30px;margin-top:10px;margin-right:40px">Password:</label><input type="text" name="password" placeholder="Edit your password"></div>
				
				<button class="btn btn-success" type="submit" id="sub">submit</button></div>
			</form>
			</#list>
		</div>
		<div class="float:left"></div>
		<div id="footer" style="position:relative"></div>
	</body>
</html>