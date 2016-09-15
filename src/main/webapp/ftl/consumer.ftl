<html>
	<head>
		<title>Service Consumer Details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	    <script src="/hhs/consumer.js"></script>
 	    <script>  	    
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html");  
  			 $("#side").load("/hhs/sidenav.html");
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
		margin-left:240px;
		padding: 5px 5px ;
		width:10%;
		background-color:#C1E3FF !important;
	}
	th {
   		text-align: center !important;
	}
</style>
	</head>
	<body>
	<div id="header"></div>
	<div id="side"></div>
	<h2 style="color:#227D21" class="col-md-offset-4" >Service Consumer Details</h2>
		
				
		<div id="listDisplay"></div>
		<div id="searchDisplayButtons" class="pagination" style="margin-left:540px"><ul ></ul>
		</div>
		
		<div id="footer"></div>
	</body>
</html>