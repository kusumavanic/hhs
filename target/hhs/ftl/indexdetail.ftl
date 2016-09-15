<table class="table-hover">
	<tr>
		<th>ProviderName</th>
		<th>Status</th>
	</tr>
	<#list list as l>
		<tr>
			<td>${l.providerName}</td>
			<td>${l.status}</td>
		</tr>
	</#list>
</table>