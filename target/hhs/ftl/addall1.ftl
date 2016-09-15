<html>
	<head>
		<title>Add Catogeory</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		 <script> 
		$(function(){
 			 $("#header").load("/hhs/newHeader1.html"); 
 			 $("#footer").load("/hhs/newFooter.html");  
  			 $("#side").load("/hhs/sidenav.html");
		});
		</script>
	</head>
	<body>
		
		<div id="header"></div>
		<div id="side"></div>
		<div class="col-md-4" style="background:white; width:796px;height:500px; margin-left:247px;padding:0px;border:1px solid blue;border-radius:10px">
		<h3 style="text-align:center;color:blue">All Services</h3>
		<#list list as l>
			<div class="col-md-4">
	 		<ul style="list-style-type:none">
	 		<li style="font-family:calibri;font-size:140%">
	 		<a href="/hhs/rest/newCatogeory/details/ad/${l.catogeory}" id="${l.catogeory}"><img src="/hhs/image/${l.icon}" width="90" height="70">${l.catogeory}</a></li>
			</ul>
	 		</div>	
	
	 	</#list>
		</div>
	 	<div id="footer" style="position:relative"></div>	
	</body>
</html>