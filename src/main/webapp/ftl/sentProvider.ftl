<html>
	<head>
		<title>Sent Request To Provider</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="/hhs/sentRequestProvider.js">
	 		</script>
		<script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html"); 
 			 $("#header").load("/hhs/newHeader1.html");  
 			 $("#newOption").load("/hhs/newCatogeory4.html");
		});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
		}
		</script>
		<style>
		table, th, td {
		   	border: 1px solid #0400FF;
		   	border-collapse:collapse;
		   	padding: 10px !important;
		   	text-align: center;
		}
		 table {
		    color: #0F0FC5;
			margin-left:240px;
			padding: 10px 5px ;
			width:20%;
			background-color:#C1E3FF !important;
		 }
		 th {
	   		text-align: center !important;
		 }
		 #btn,#btn1{
		  margin:right:20px;
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
	
	<head>
	<body>
	<div id="header"></div>
	<div id="side">
	
		<div id="side" style="float:left">
			<div class="navbar navbar-fixed-left" style="padding-bottom:20%;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/consumer/${consumerId}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/newCatogeory/get/all">AvailableProviders</a></li> 
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/consumer/composeMail">Send Request Throw Email</a></li>     
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
	
	</div>
	
	<div style="float:right:margin-right:50px">
	<#list list as l>	
	<h2 style="color:#227D21" class="col-md-offset-3">${l.serviceType} details you can send request to him</h2>	
		
			<button id="id" value="${l.providerId}" hidden></button>
			<button id="catogeory" value="${l.serviceType}" hidden></button>
		</#list>

		 <form class="navbar-form" role="search" style="margin-left:840px;margin-top:0px">
		    <div class="input-group add-on">
		      <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
		      <div class="input-group-btn">
		        <button class="btn btn-default" id="searchButton"style="size:30px"type="button"><i class="glyphicon glyphicon-search"></i></button>
		      </div>
		    </div>
		  </form>
		<div id="listDisplay"></div>
		<div id="searchDisplayButtons" class="pagination" style="margin-left:300px">
		</div>
		
	</div>
	</body>
	<div id="footer"></div>
</html>