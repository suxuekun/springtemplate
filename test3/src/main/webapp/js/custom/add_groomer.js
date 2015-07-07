$(document).ready(function() {
	var ajax_run=false
		/*Ajax submit form*/
	$('#addgroomer').on('submit',(function(e){

		e.preventDefault();
		var canUpload = true;
		console.log($('#title').val());
		
		if ($('#title').val() == null || $('#title').val().trim().length < 1) {
			canUpload = false;
		} 

		if(canUpload && ajax_run==false){
			
			ajax_run=true;
			ajaxSubmit(this,function(data) {
					location.replace("edit?id=" + data);
				});
			/*ajax ends*/
			
		}else{
			alert("need a title");
		}
		
		
	}));/* form submit end */
	
	
	
});