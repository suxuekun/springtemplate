/**
 * JS for Pages
 */

$(document)
		.ready(
				function() {
					console.log("load data table");

					var ajax_run=false;
					var oTable = $('.data-table').DataTable({
						"bSort" : false,
						"bServerSide" : true,
						"sDom" : '<""l>t<"F"p>',
						"bJQueryUI" : true,
						"bSearchable" : false,
						"sPaginationType" : "full_numbers",
						"sAjaxSource" : "ajax_list",
						
					});
					
					$(document).on('dblclick', '.data-table tbody tr',
							function() {
								var id = this.id;
								var url = "edit?id=" + id;
								$(location).attr('href', url);
							});

					$(document).on('click', '.data-table tbody tr', function() {
						if ($(this).hasClass('checked')) {
							$(this).removeClass('checked');
						} else {
							$(this).addClass('checked');
						}
					});

					
					$('#deleterow').click(function() { 
						
						bootbox.confirm("delete?", function(result) {

								if (result == true && ajax_run==false) {
									var idSting = listId(oTable);
									
									// console.log("idSting:"+idSting);
									if (idSting != null) {
										
										ajax_run=true;
										
										var ob = {
											'id' : idSting
										};
										
										$.ajax({
													type : 'POST',
													url : 'remove',
													data : ob,
													dataType : 'html',
													success : function(data) {
														//alert(data);
														//alertNotification(data);
													},
													complete : function(xhr,status) {
														console.log('complete in');
														oTable.ajax.reload();
														ajax_run=false;
														console.log('complete out');
													}
												});

									}
	
								}
							});/*bootbox ends*/

					});
					
					
					
					
//					function searchLatestContent  ()
//					{
//						
//						oTable = null;
//						
//						oTable = $('.data-table').DataTable(
//						{
//							"bDestroy": true
//							, "bSort" : true
//							, "bServerSide": true
//							, "sDom": '<""l>t<"F"p>'
//							, "bJQueryUI": true
//							, "bAutoWidth": false
//							, "bSearchable": false
//							, "sPaginationType": "full_numbers"
//							, "sAjaxSource": "ajax_list"
//							, "columnDefs": [
//								               {
//								                   "targets": [0],
//								                   "visible": false
//								               }
//								           ]
//							,
//							"language":  {
//				        	    "emptyTable":     $("#emptyTable").html(),
//				        	    "lengthMenu":     $("#lengthMenu").html(),
//				        	    "loadingRecords": $("#loadingRecords").html(),
//				        	    "processing":     $("#processing").html(),
//				        	    "zeroRecords":    $("#zeroRecords").html(),
//				        	    "paginate": {
//				        	        "first":      $("#firstDatatable").html(),
//				        	        "last":       $("#lastDatatable").html(),
//				        	        "next":       $("#nextDatatable").html(),
//				        	        "previous":   $("#prevDatatable").html()
//				        	    }
//				        	}
//						});
//						
//						$('select[name=dataTable_length]').select2();
//						
//					};
					
					

					function listId(ObjectTable) {
						var artmp = [];
						var selectedRows = ObjectTable.$('tr.checked');
						var url = "";
						if (selectedRows.length <= 0) {
							alert("no row selected");
							return null;
						} else {
							for (var j = 0; j < selectedRows.length; j++) {
								artmp[j] = selectedRows[0].id;//ObjectTable.row(selectedRows[j]).data()[0];//
							}
							console.log(artmp[j]);

							for (var i = 0; i < artmp.length; i++) {

								if (i == 0)
									url = artmp[0];

								if (i > 0) {
									url = url + "," + artmp[i];
								}
							}


							
							return url;

						}
					}
				});
