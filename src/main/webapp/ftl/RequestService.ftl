<html>
	<head>
		<title>Requested Providers</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html");
 			 $("#side").load("/hhs/sidenav.html");
 
		});
		</script>
		<script src="/hhs/pagRequestProvider.js"></script>
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
		#btn,#btn1{
		 margin:right:20px;
		}
	</style>
	
	<head>
		<body>
			<div id="header"></div>
			<div id="side"></div>
				<h2 style="color:#227D21" class="col-md-offset-4">Requested Provider details</h2>	
				
				<div id="listDisplay"></div>
				<div id="searchDisplayButtons" class="pagination" style="margin-left:500px">
			</div>
			<div id="footer"></div>
	</body>
</html>