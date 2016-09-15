$(document).ready(function(){
		var id=$("#id").val();
		var catogeory=$("#catogeory").val();
		console.log(id);
		console.log(catogeory);
		
		var query_id=0;
		$.ajax(
		{
			
				type:"POST",
				url:"/hhs/rest/pagination/sentRequestProvider?id="+id+"&catogeory="+catogeory,
								
				contentType:"application/json",
				success:function(data){
				data:JSON.stringify(data),			 
				console.log(data);
											 
				var count=data.count;
				query_id=data.query_id;
				console.log(query_id);
				if(count>4)
				{
						var buttons=Math.ceil(count/4.0);
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
							url:"/hhs/rest/pagination/sentRequest?id="+id+"&query_id="+query_id+"&start=0&offset=4",
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
								pageNumber=pageNumber*4;
							}
							$.ajax({
								type:"GET",
								url:"/hhs/rest/pagination/sentRequest?id="+id+"&query_id="+query_id+"&start="+pageNumber+"&offset=4",
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
						url:"/hhs/rest/pagination/sentRequest?id="+id+"&query_id="+query_id+"&start=0&offset=4",
						success:function(data)
						{
							console.log(data);
							$('#listDisplay').html(data);
							}
						});
											
						}
											
				}
			}); 

		$('#searchButton').click(function(){
			var search=$('#srch-term').val();
			var catogeory=$('#catogeory').val();
			var id=$("#id").val();
			console.log(search);
			var check=true;
			if(search==''||search==' '||search==null)
			{
				check=false;
				alert("please provide text");
			}
			if(check==true)
			{
				console.log(search);
				$.ajax({
					type:'GET',
					url:'/hhs/rest/search/'+catogeory+'/'+search,
					dataType:'json',
					success:function(data){
						data:JSON.stringify(data),			 
						console.log(data);
						
						
						query_id=data.query_id;
						var count=data.count;
						query_id=data.query_id;
						if(count>5)
						{
								var buttons=Math.ceil(count/5.0);
							
								console.log("count "+count+" query"+query_id+" buttons"+buttons);
								$('#searchDisplayButtons').html("");
								var i;
								for(i=0;i<buttons;i++)
								{
									$("#searchDisplayButtons").append("<li style='display:inline' value="+i+"><a>"+(i+1)+"</a></li>");
								}
								$("#searchDisplayButtons li:first").addClass("active");
								console.log(query_id);	
								
								
								$.ajax({
									type:"GET",
									url:"/hhs/rest/search/request/providers?query_id="+query_id+"&start=0&offset=5&id="+id,
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
										pageNumber=pageNumber*5;
									}
									$.ajax({
										type:"GET",
										url:"/hhs/rest/search/request/providers?query_id="+query_id+"&start="+pageNumber+"&offset=5&id="+id,
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
								url:"/hhs/rest/search/request/providers?query_id="+query_id+"&start=0&offset=5&id="+id,
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

		});
		
	}
);


