<html>
	<head>
		<title>Service Provider Details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		 <script> 
		$(function(){
  			 $("#side").load("/hhs/sidenav.html");
  			 $("#footer").load("/hhs/newFooter.html");
		});
		</script>
	 	<script src="/hhs/pagination.js">
	 		</script>
		<style>
			table, th, td {
			   	border: 1px solid #0400FF;
			   	border-collapse:collapse;
			   	padding: 10px !important;
			   	text-align: center;
			}
			table {
			    color:  #0F0FC5;
				margin-left:350px;
				padding: 10px 5px ;
				width:20%;
				background-color:#C1E3FF !important;
			}
			th {
		   		text-align: center !important;
			}
			html {
				position: relative;
			    min-height: 100%;
			}
			body {
			   margin-bottom: 60px;
			}
			#footer {
			   position: absolute;
			   bottom: 0;
			   width: 100%;
			   height: 100px;
			   background-color: #6BAAEA;
			}
			div#header {
					width: 100%;
					height: 120px;
					background: #6BAAEA;
					margin:0;
					padding:0px;
				}

		body{
			margin:0;
			padding:0;
		}
		</style>
	</head>

	<body>
	<div id="header">
	
	<img src="/hhs/image/logo.jpg" style="height:120px;width:17%; float:left" alt="logo"/>

  		 <div  style="float:right;margin-top:67px">
  		 <nav class="navbar navbar-inverse">
            <div class="container-fluid">
  		    <ul class="nav navbar-nav">  
        		 	  <li><a href="/hhs/rest/index">Home<span class="glyphicon glyphicon-home"></span></a></li>
        		 	  				    			     
						<li><a href="/hhs/rest/index" onClick="signOut">LogOut<span class="glyphicon glyphicon-home"></span></a></li>
			 </ul>
			 </div>
	    </nav>
	     
        </div>
       <div class="clearfix"></div>
	</div>
	<div id="side"></div>
	<div>	
	<h2 style="color:#227D21" class="col-md-offset-3">Consumer request</h2>
		<table class="table-hover">
			<tr>
				
				<th>ProviderId</th>
				<th>ConsumerId</th>
				
			</tr>
			<#list list as l>
					<tr>
					    
					    <td>${l.consumerId}</td>
						<td>${l.providerId}</td>
					</tr>
				</#list>
</table>
		
		</div>
		<div style="width:500px;height:100px"></div>
		<div id="footer" style="position:relative"></div>
	</body>
</html>