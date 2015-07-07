
$(document)
		.ready(
				function() {		
					
					var ajax_run = false;
					
					var iconUrl = $('#pageIcon').html();
					console.log(iconUrl);
					if(iconUrl.trim()!="")
					{
						
						$('#iconReview').attr({
							src : iconUrl
						});
						
						$('#iconReview').show();
					}

					$("#uploadIcon")
					.change(
							function() {
								if (this.files && this.files[0]) {
									
										var reader = new FileReader();

										reader.onload = function(e) {
											$("#iconReview")
													.attr(
															{
																src : e.target.result,
																height : "15px",
																width : "15px",
																alt : $("#uploadIcon").val().replace(/^.*[\\\/]/,"")
															});
											$("#iconReview").show();

										};

										reader.readAsDataURL(this.files[0]);
									
									
								}
							});
					
					/*generate position button and events end*/


					/*Ajax submit form*/
					$('#updatePage').on('submit',(function(e){

						e.preventDefault();
						var canUpload = true;

						console.log($('#title').val() + "aabc");
						if ($('#title').val() == null || $('#title').val().trim().length < 1) {
							canUpload = false;
						} 

						if(canUpload && ajax_run==false){
							
							ajax_run=true;
							$.ajax({
								type : 'POST',
								url : 'upload',
								data : new FormData(this),
								dataType : 'html',
								contentType: false,       // The content type used when sending data to the server.
								cache: false,             // To unable request pages to be cached
								processData:false,  
								success : function(data) {
									location.replace("view");
//	
//									alertNotification(data);
									alert('success');
									location.replace("edit?id="+$('#pageIdIn').val());
	
								},
								
								complete:function(data) {
									console.log(data);
									ajax_run=false;
								}
							});
							/*ajax ends*/
							
						}
						
						
					}));

});