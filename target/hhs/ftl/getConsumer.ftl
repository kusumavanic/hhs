<html>
	<head>
		<title>Service Consumer Details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	   <script src="/hhs/getConsumer.js">
	 		</script>
 	    <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html");  
  			 $("#footer").load("/hhs/newFooter.html");
		});
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
				padding: 10px 5px ;
				width:20%;
				background-color:#C1E3FF !important;
			}
			th {
		   		text-align: center !important;
			}
			.navbar-fixed-left {
				  width: 230px;
				  position: fixed;
				  border-radius: 0;
				  height: 100%;
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
</style>
	<head>
	<body>
	<div id="header"></div>
	 <div class="navbar navbar-inverse navbar-fixed-left" style="float:left;background:#050C13;">
  			<ul class="nav navbar-nav">
  
   				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/login/${list}">viewStatus</a></li>
     			 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/login/providers">AvailableProviders</a></li>   
     			  <li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/provider/requestConsumer/${list}">RequestConsumer</a></li>  
 			 </ul>
	</div>
	<div style="float:right;margin-right:150px">
	<h2 style="color:#227D21" class="col-md-offset-2" >Requested Consumer Details</h2>
		<button id="id" value=${list} hidden></button>
		<div id="listDisplay"></div>
		<div id="searchDisplayButtons" class="pagination" style="margin-left:400px">
		</div>
	</div>
	<div id="footer" style="position:relative"></div>
	</body>
</html>