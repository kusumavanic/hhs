<html>
	<head>
		<title>Add Catogeory</title>
		<meta charset="utf-8">  
  		<meta name="viewport" content="width=device-width, initial-scale=1">  
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 	    
	</head>
	<body>
		
		<#list list as l>
			<div class="col-md-4">
	 		<ul style="list-style-type:none">
		 		<li style="font-size:100%;"><b>
			 		<a href="/hhs/rest/newCatogeory/${l.catogeory}"><img src="/hhs/image/${l.icon}" width="100" height="80">${l.catogeory}</a>
					</b>
				</li>
			</ul>
	 		</div>	
	
	 	</#list>
	 		
	</body>
</html>