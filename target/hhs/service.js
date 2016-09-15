$(document).ready(function(){
								
		var query_id=0;
		$.ajax(
		{
			
				type:"POST",
				url:"/hhs/rest/pagination/service",
								
				contentType:"application/json",
				success:function(data){
				data:JSON.stringify(data),			 
				console.log(data);
											 
				var count=data.count;
				query_id=data.query_id;
				if(count>6)
				{
						var buttons=Math.ceil(count/6.0);
						console.log(count+" "+query_id+" "+buttons);
						$('#searchDisplayButtons').html("");
						var i;
						for(i=0;i<buttons;i++)
						{
							$("#searchDisplayButtons").append("<li style='display:inline' value="+i+"><a>"+(i+1)+"</a></li>");
						}
						$("#searchDisplayButtons li:first").addClass("active");
															
						$.ajax({
							type:"GET",
							url:"/hhs/rest/pagination/serviceType?query_id="+query_id+"&start=0&offset=6",
							success:function(data)
							{
								console.log(data);
								$('#listDisplay').html(data);
							}
																
							});
														 
							$('#searchDisplayButtons').on("click","li",function(){
							$('#searchDisplayButtons li').removeClass("active");
							$(this).addClass("active");
							var pageNumber=$(this).val();
							if(pageNumber!=0)
							{
								pageNumber=pageNumber*6;
							}
							$.ajax({
								type:"GET",
								url:"/hhs/rest/pagination/serviceType?query_id="+query_id+"&start="+pageNumber+"&offset=6",
								success:function(data)
								{
									console.log(data);
									$('#listDisplay').html(data);
								}
																
								});
															
																
						});
																		
																		
					}else{$('#searchDisplayButtons').html("");
					$.ajax({
						type:"GET",
						url:"/hhs/rest/pagination/serviceType?query_id="+query_id+"&start=0&offset=6",
						success:function(data)
						{
							console.log(data);
							$('#listDisplay').html(data);
							}
						});
											
						}
											
				}
			}); 
	}
);


