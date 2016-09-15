<html>	
	<head>
		<script>
	   		$(document).ready(function(){
	   			$(".del").click(function(){
	   				alert("selected consumer is deleted..!!!");
	   			});	   				
	   		});
	   	</script>
	</head>
	<body>
			<table class="table-hover">
				<tr>
					<th>ConsumerId</th>
					<th>ConsumerName</th>
		
				
		
				</tr>
				<#list list as l>
						<tr>
						<td> <input type="radio" value="${l.id}" name="id">${l.id}</td>
						<td>${l.consumerName}</td>
						<td><a href="/hhs/rest/login/deleteConsumer/${l.id}"><button class="del">Submit</button></td></form>
						</tr>
			
				</#list>
		</table>
	</body>
</html>