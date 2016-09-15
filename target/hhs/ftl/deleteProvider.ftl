	<html>
	      <head>
	   			<script>
	   				$(document).ready(function(){
	   					$(".del").click(function(){
	   						alert("selected provider is deleted..!!!");
	   					});	   				
	   				});
	   			</script>
	      </head>
	  	 <body>
	     	 <table class="table-hover">
				<tr>
					<th>ProviderId</th>
					<th>ProviderName</th>
					<th>Status</th>
	
			</tr>
			<#list list as l>
					<tr>
					<td> <input type="radio" value="${l.id}" name="id" id="id">${l.id}</td>
					<td>${l.providerName}</td>
					<td>${l.status}</td>
					<td><a href="/hhs/rest/login/deleteProvider/${l.id}"><button class="del">submit</button></td>
					</tr>

			</#list>	
			
	</table>
	
</body>
</html>