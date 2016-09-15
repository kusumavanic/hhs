<!doctype html>
<html>
<head>
<title>Provider page</title>
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
		});
		</script>
		<style>
				.navbar-fixed-left {
				  width: 230px;
				  position: fixed;
				  border-radius: 0;
				  height: 100% !important;
				  padding-bottom:25% !important;
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
	<body id="admin">
	<div id="header"></div>
		<#list list as l>
		<h3>WELCOME ${l.providerName}</h3>
		<div style="float:left;height:500px;width:200px;background:#050C13;">
		<div class="navbar navbar-fixed-left;" style="background:#050C13;">
  			<ul class="nav navbar-nav">
  				<li class="navli"><a style="color:white;font-family:calibri;font-size:130%" href="/hhs/rest/login/${l.id}">viewStatus</a></li>
  				<li class="navli"><a style="color:white;font-family:calibri;font-size:130%" href="/hhs/rest/login/providers">AvailableProviders</a></li> 
  				<li class="navli"><a style="color:white;font-family:calibri;font-size:130%" href="/hhs/rest/provider/requestConsumer/${l.id}">Request Consumers</a></li> 
			</ul>
		</div>
		</div>
		</#list>
		<div class="col-md-4" style="background:white; width:826px;height:400px; float:right;margin-right:200px;padding:0px;border:1px solid blue;border-radius:10px;margin-bottom:30px;margin-top:0px">
			<div id="new"></div>
		</div>
		<div class="clearfix"></div>
	<div id="footer" style="position:relative"></div>
</html>