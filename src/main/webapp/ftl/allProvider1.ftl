<html>
	<head>
		<title>Service Provider Details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
	 	<script src="/hhs/pagination.js"></script>
		<style>
			table, th, td {
			   	border: 1px solid #0400FF;
			   	border-collapse:collapse;
			   	padding: 10px !important;
			   	text-align: center;
			}
			table {
			    color:  #0F0FC5;
				margin-left:250px;
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

	<div id="side">
	<div class="navbar navbar-inverse navbar-fixed-left" style="background:#050C13;">
  			<ul class="nav navbar-nav">
  				 <li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/login/${list}">viewStatus</a></li>
  				<li class="navli"><a style="color:white;font-family:calibri;font-size:100%"  href="/hhs/rest/login/providers">AvailableProviders</a></li> 
  				<li class="navli"><a style="color:white;font-family:calibri;font-size:100%" href="/hhs/rest/provider/requestConsumer/${list}">Request Consumers</a></li> 
		</div>
	
	
	
	</div>
	<h2 style="color:#227D21" class="col-md-offset-4">Service Provider Details</h2>
		 <form class="navbar-form" role="search" style="margin-left:840px;margin-top:0px">
		    <div class="input-group add-on">
		      <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
		      <div class="input-group-btn">
		        <button class="btn btn-default" id="searchButton"style="size:30px"type="button"><i class="glyphicon glyphicon-search"></i></button>
		      </div>
		    </div>
		  </form>
		<div id="listDisplay"></div>
		<div id="searchDisplayButtons" class="pagination" style="margin-left:350px;margin-bottom:30px">
		</div>
		
		
	</body>
</html>