<html>
	<head>
		<title>Service Provider Details</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
	 	<script src="/hhs/allProvider.js"></script><script>  	    
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
				    color:  #0F0FC5;
					margin-left:250px;
					padding: 10px 5px ;
					width:20%;
					background-color:#C1E3FF !important;
				}
				th {
			   		text-align: center !important;
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
	<h2 style="color:#227D21" class="col-md-offset-4">${list} Details</h2>
		<button id="catogeory" value="${list}" hidden></button>
			 <form class="navbar-form" role="search" style="margin-left:850px">
		    <div class="input-group add-on">
		      <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
		      <div class="input-group-btn">
		        <button class="btn btn-default" id="searchButton"style="size:30px"type="button"><i class="glyphicon glyphicon-search"></i></button>
		      </div>
		    </div>
		  </form>
		  
			<div id="listDisplay"></div>
			<div id="searchDisplayButtons" class="pagination" style="margin-left:500px"><ul ></ul>
		
		</div>
	</body>
</html>