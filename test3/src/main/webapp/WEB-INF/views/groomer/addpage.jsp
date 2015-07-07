<%@include file = "/WEB-INF/views/include/header.jsp" %>
<div id="content">
				<div id="content-header" class="mini">
					<h1>Groomer add</h1>

				</div>
				<div id="breadcrumb">
					<a href="#" title="Go to Home" class="tip-bottom"><i class="fa fa-home"></i> Home</a>
					<a href="#" class="current">Groomer</a>
				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="fa fa-align-justify"></i></span>
								<h5>add new item</h5>
								<span title="edit information" class="label label-info tip-right" style="float:left;">
									<i class="fa fa-info"></i>
								</span>
							</div>
							<div class="widget-content">
								<form id="addgroomer" action="ajax_add_min" enctype="multipart/form-data" class="form-horizontal" method="POST">
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">title</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<input id="title" name="title" type="text" value="" style="width:200px" maxlength="30"/>
										</div>
										<br>
									</div>
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label"></div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<button id="addsubmit" type="submit" class="btn btn-primary btn-sm">Next</button>
										</div>
										<br>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
<script src="${ WEBAPPS }/js/custom/add_groomer.js"></script>
<%@include file = "/WEB-INF/views/include/footer.jsp" %>