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
	   		 $("#sub").click(function(){
	   			alert("your profile is successfully edited..!!!");  				
	   		});
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
				  padding-bottom:55%;
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
	<body>
	<div id="header"></div>
			<#list list as l>
				<div class="navbar navbar-fixed-left" style="float:left;background:#050C13;">
	  			<ul class="nav navbar-nav">
	  				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/${l.id}">viewStatus</a></li>
	  				<li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/providers">AvailableProviders</a></li> 
	  				<li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/provider/requestConsumer/${l.id}">Request Consumers</a></li>
	  			</ul>
	  			</div> 
	  		</div>
  			<div class="col-md-4" style="background:white; width:486px;height:600px; float:right;margin-top:20px;margin-right:300px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:30px">
  			
			<h2 style="color:#166F10;margin-right:150px;margin-left:100px;margin-top:5px;margin-bottom:35px">${l.providerName} Profile</h2>
			
			<div style="color:blue;font-size:20px;margin-left:20px"><label style="margin-right:100px"><b>Name :</b></label> ${l.providerName}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:100px"><b>Email :</b></label> ${l.emailId}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:20px"><b>MobileNumber :</b></label>${l.mobileNumber}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:70px"><b>Location :</b></label>${l.location}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:120px"><b>City :</b></label>${l.city}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:65px"><b>Password :</b></label>${l.password}</div>
			<div style="color:blue;font-size:20px;margin-left:20px;"><label style="margin-right:20px"><b>Registion Date :</b></label>${l.createdAt}</div>
			
			
				<button class="btn btn-primary" value="Show Div" onclick="showDiv()" style="width:100px;height:40px;margin-top:30px">EDIT</button>
				<form action="/hhs/rest/provider/editProvider/${l.id}" method="POST">
				<div id="welcomeDiv" style="display:none;background:rgba(223, 240, 216, 0.69); width:300px;height:200px;margin-left:100px;">
					<div><label style="color:#010513;margin-bottom:10px;margin-top:10px;margin-right:71px">Email:</label><input type="text" name="email" placeholder="Edit email Id" ></div>
					<div><label style="color:#010513;margin-bottom:10px;margin-top:10px;margin-right:10px">MobileNumber:</label><input type="number" name="mobileNumber" placeholder="Edit MobileNumber Id"></div>
					<div><label style="color:#010513;margin-bottom:30px;margin-top:10px;margin-right:40px">Password:</label><input type="text" name="password" placeholder="Edit your password"></div>
				
				<button class="btn btn-success" style="margin-left:80px" type="submit" id="sub">submit</button></div>
			</form>
			</#list>
		</div>
		</div>
		<div id="footer"></div>
	</body>
</html>