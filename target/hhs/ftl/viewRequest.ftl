<html>
	<head>
		<script>
			$(document).ready(function(){
				$(".accept").click(function(){
					window.alert("status is updated..you are accept him");
				});
				$(".decline").click(function(){
					window.alert("status is updated..you are decline him");
				});
		});
		</script>
	</head>
	<body>
		<table>
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
						<td> <input type="radio" value=${l.id} name="id">${l.id}</td>
						<td>${l.providerName}</td>
						<td>${l.mobileNumber}</td>
						<td>${l.emailId}</td>
						<td>${l.location}</td>
						<td>${l.city}</td>
						<td>${l.status}</td>
						<td><a href="/hhs/rest/provider/respon?respon=accept&id=${l.id}"><button class="accept">Accept</button></a></td>
						<td><a href="/hhs/rest/provider/respon?respon=decline&id=${l.id}"><button class="decline">Decline</button></a></td>				
				</tr>
			</#list>
		</table>
	</body>
</html>
	