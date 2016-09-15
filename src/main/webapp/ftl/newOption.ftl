<html>
	<body>
	<div class="form-group">
	<label><b>ServiceType</b></label>
	<select class="selectpicker" multiple style="width:150px" name="serviceType" required>
		<#list list as l>
		<option name="${l.catogeory}" value="${l.catogeory}">${l.catogeory}</option>
		</#list>
   </select></div>
	</body>
</html>