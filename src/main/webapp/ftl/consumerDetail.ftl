
<table class="table-hover">
			<tr>
				<th>ConsumerId</th>
				<th>ConsumerName</th>
				<th>MobileNumber</th>
				<th>EmailId</th>
				<th>AltEmailId</th>
				<th>Location</th>
				<th>City</th>
			</tr>
			<#list list as l>
					<td>${l.id}</td>
					<td>${l.consumerName}</td>
					<td>${l.mobileNumber}</td>
					<td>${l.emailId}</td>
					<td>${l.altEmailId}</td>
					<td>${l.location}</td>
					<td>${l.city}</td>
					</tr>
			</#list>
</table>
		