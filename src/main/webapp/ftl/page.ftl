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
					<td>${l.id}</td>
					<td>${l.providerName}</td>
					<td>${l.mobileNumber}</td>
					<td>${l.emailId}</td>
					<td>${l.location}</td>
					<td>${l.city}</td>
					<td>${l.status}</td>
					</tr>
				</#list>
</table>