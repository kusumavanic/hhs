<html>	
	<head>
		<script>
			$(document).ready(function(){
				$(".request").click(function(){
					window.alert("Your request is send..!!! and you can send request only for one consumer in perticular catogeory...!!!");
				});
		});
		</script>
	</head>
	<body>
		<table class="table-hover">
				<tr>
					<th>ProviderId</th>
					<th>ProviderName</th>
					<th>MobileNumber</th>
					<th>EmailId</th>
					<th>Location</th>
					<th>City</th>
					<th>Status</th>
		
				
		
				</tr>
				<#list list as l>
	
						<tr>
						<td> <input type="radio" value=${l.id} name="providerId">${l.id}</td>
						<td>${l.providerName}</td>
						<td>${l.mobileNumber}</td>
						<td>${l.emailId}</td>
						<td>${l.location}</td>
						<td>${l.city}</td>
						<td>${l.status}</td>
						<td><a href="/hhs/rest/consumer/requestToProvider/${id}/${l.id}"><button class="request">Submit</button></a></td>
						</tr>
			
				</#list>
		</table>	
	</body>
</html>