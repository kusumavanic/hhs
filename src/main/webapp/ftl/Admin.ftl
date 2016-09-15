<!doctype html>
<html>
<head>
<title>Admin page</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	    <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html");  
  			 $("#side").load("/hhs/sidenav.html");
  			 
  			 $(document).load(function(){
  			 	ajax({
  			 		type:"GET",
					url:"/hhs/rest/newCatogeory/get/all/ad",								
					contentType:"application/json",
					success:function(data){
						data:JSON.stringify(data),
						alert("hi");
					}
					
  			 	});
  			 });
		});
		</script>
		
</head>
	<body id="admin">
	<div id="header"></div>
	<div id="side"></div>
	<div id="footer"></div>
	</body>
</html>