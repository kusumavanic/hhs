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
  			 $("#footer").load("/hhs/newFooter.html");
  			 $("#newOption").load("/hhs/newCatogeory4.html");
  			 
		});
		function showDiv() {
			   document.getElementById('welcomeDiv').style.display = "block";
			}
		</script>
		
</head>
	<body id="admin">
	<div id="header"></div>
		  	 <div id="add"></div>
			<div style="background:#F5EEEF; width:826px;height:550px; margin-left:233px;padding:0px">
		
		<#list list as l>
		<div class="col-md-4">
		<h3>WELCOME ${l.consumerName}</h3>
		
		<form style="float:left ; margin-top:20px" action="/hhs/rest/login/consumer/${l.emailId}">
			<button class="btn btn-primary" style="width:200px;height:50px">View Status</button></form><br>
			<form style="float:left ; margin-top:20px" action="/hhs/rest/newCatogeory/get/all">
			<button class="btn btn-primary" style="width:200px;height:50px">Available Providers</button></form><br>
		 </div>

	<div class="col-md-12" style="margin-top:20px">
		<button class="btn btn-primary" style="width:200px;height:50px" value="Show Div" onclick="showDiv()">Send Request</button>
		<div id="welcomeDiv" style="display:none;">
		<h3 style="color:red">Enter which serviceType do u want</h3>
		<form action="/hhs/rest/consumer/sentRequest/${l.emailId}" method="POST">
		<#--<input type="text" id="catogeory" name="catogeory" placeholder="enter here"/>-->
		
		<div id="newOption"></div>
		
		<button class="btn btn-success" type="submit" name="submit">submit</button>
		</form>
		</div>
</div>	</div>
		</#list> 
	<div id="footer">
	</body>
</html>