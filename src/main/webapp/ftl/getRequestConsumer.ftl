<table class="table-hover">
			<tr>
				<th>ConsumerName</th>
				<th>MobileNumber</th>
				<th>EmailId</th>
				<th>Location</th>
				<th>City</th>
				<th style="width:150px">RequestAt</th>
			</tr>
			<#list list as l>
					<td>${l.consumerName}</td>
					<td>${l.mobileNumber}</td>
					<td>${l.emailId}</td>
					<td>${l.location}</td>
					<td>${l.city}</td>
					<td >${l.createdAt}</td>
					</tr>
				</#list>
		</table>
		