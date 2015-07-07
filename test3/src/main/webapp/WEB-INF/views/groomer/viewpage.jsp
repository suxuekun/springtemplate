<%@include file = "/WEB-INF/views/include/header.jsp" %>


<div id="alertDel" style="display: none;">delete?</div>
			<div id="content">
				<div id="content-header">
					<h1>Groomer view</h1>
					<div class="btn-group">
						<a id="add-btn" href="add" class="btn btn-large tip-bottom" title="add"><i class="fa fa-plus"></i></a>
						<a href="#" id="deleterow" class="btn btn-large tip-bottom" title="del" ><i class="fa fa-times"></i></a>
					</div>

				</div>
				<div id="breadcrumb">
					<a href="#" title="Go to Home" class="tip-bottom"><i class="fa fa-home"></i> Home</a>
					<a href="#" class="current">Groomer</a>
				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="fa fa-th"></i>
									</span>
									<h5>Dynamic table</h5>
								</div>
								<div class="widget-content nopadding">
									<table id ="dataTable" class="table table-bordered table-striped table-hover data-table" style="text-align: center">
										<thead>
										<tr>
											<th width="20%">title</th>
											<th width="20%">type</th>
											<th width="20%">quote</th>
											<th width="20%">author</th>
											<th width="20%">logo</th>
										</tr>
										</thead>
										
										<tbody>
											<tr>
												<td colspan="5" class="dataTables_empty">loading...</td>
											</tr>
										</tbody>
									</table> 
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
<script src="${ WEBAPPS }/js/custom/view_list.js"></script>
<%@include file = "/WEB-INF/views/include/footer.jsp" %>