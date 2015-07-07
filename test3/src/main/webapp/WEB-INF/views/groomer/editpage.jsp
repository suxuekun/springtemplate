<%@ page pageEncoding="UTF-8"%>
<%@include file = "/WEB-INF/views/include/header.jsp" %>

			<div id="pageIcon" style="display: none">${logo}</div>
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
								<h5>edit</h5>
								<span title="edit information" class="label label-info tip-right" style="float:left;">
									<i class="fa fa-info"></i>
								</span>
							</div>
							<div class="widget-content">
							
								<form id="updatePage" action="" class="form-horizontal" enctype="multipart/form-data" method="POST">
								    <input id="pageIdIn" name="pageIdIn" type="hidden" value="${pageId}"/>
								    
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">title</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<input id="title" name="title" type="text" value="${title}" style="width:200px" maxlength="30"/>
										</div>
										<br>
									</div>
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">type</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<input id="type" name="type" type="text" value="${type}" style="width:200px" maxlength="30"/>
										</div>
										<br>
									</div>
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">quote</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<input id="quote" name="quote" type="text" value="${quote}" style="width:200px" maxlength="30"/>
										</div>
										<br>
									</div>
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">author</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<input id="author" name="author" type="text" value="${author}" style="width:200px" maxlength="30"/>
										</div>
										<br>
									</div>
									
									<div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label">logo</div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<img id="iconReview" name="iconReview" alt="Cover Image" src="" height="15px" width="15px" style="display: none">
											<input type="file" id="uploadIcon" name="uploadIcon" accept="image/x-icon" style="margin-top: 8px;" />
										</div>
										
									</div>									
								    <div class="form-group">
										<div class="col-sm-3 col-md-3 col-lg-2 control-label"></div>
										<div class="col-sm-9 col-md-9 col-lg-10">
											<button id="authenChangeSubmit" type="submit" class="btn btn-primary btn-sm">Save</button>
										</div>
										<br>
									</div>
								</form>
							</div>
						</div>
					
					</div>
					
				</div>

			</div>
<script src="${ WEBAPPS }/js/custom/edit_list.js"></script>
<%@include file = "/WEB-INF/views/include/footer.jsp" %>