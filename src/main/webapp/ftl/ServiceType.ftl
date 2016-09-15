<table class="table-hover">
	<tr>
		<th>ProviderId</th>
		<th>Service Type</th>
	</tr>
	<#list list as l>
		<tr>
			<td>${l.providerId}</td>
			<td>${l.serviceType}</td>
		</tr>
	</#list>
</table>