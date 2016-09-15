<html>
	<head>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
	</head>
	<body>
		
		<div class="col-md-offset-5">
		<ul class="pagination pagination-md" id="pagination">
 			<#list list as l>
 				<li id="${l}" name="${l}" class="pageNo" value="${l}"><a onclick = "getPageDetails()" >${l}</a></li>
 			</#list>	
 		</ul>
 		</div>
 		<div id="viewInfo"></div>
 		<script>
		 	function getPageDetails(){
			
				$('.pageNo').click(function(){
					var pageNumber = $(this).attr('id');
					$.ajax({
						type : 'GET',
						url : '/hhs/rest/pagination/'+pageNumber+'/',
						dataType: 'json',
						success : function(data){
							$('#viewInfo').find('tbody').html("");
							console.log("length of the income set is ......"+data.length);
							for(var i=0; i<data.length; i++){
							$('#viewInfo').find('tbody').append(
								 "<tr class='table'>"+
								"<td>"+(i+1)+"</th>"+
								"<td>"+data[i].id+"</td>"+
								"<td>"+data[i].providerName+"</td>"+
								"<td>"+data[i].mobileNumber+"</td>"+
								"<td>"+data[i].emailId+"</td>"+
								"<td>"+data[i].location+"</td>"+
								"<td>"+data[i].city+"</td>"+
								"<td>"+data[i].status+"</td>"+
								 "</tr>");
								
							}
						$('#viewInfo').append("</tbody>"+"</table>");
						}
					});
				});
			}
		</script>
	</body>
</html>