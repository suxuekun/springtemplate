<div id="sidebar">
				<div id="search">
					<input type="text" placeholder="Search here..."/><button type="submit" class="tip-right" title="Search"><i class="fa fa-search"></i></button>
				</div>	
				<ul>
					<li class="submenu active open"><a href="groomer"><i class="fa fa-home"></i><span>groomer</span> <i class="arrow fa fa-chevron-right"></i></a>
						<ul>
							<li
							<% if( String.valueOf(request.getAttribute( "MYPAGE" ) ).indexOf("viewpage")>=0){
								%> class="active" <%}else {%>  <%}  %> 
							>
							<a href="view">view</a></li>
							<li
							<% if( String.valueOf(request.getAttribute( "MYPAGE" ) ).indexOf("addpage")>=0){
								%> class="active" <%}else {%>  <%}  %> 
							>
							<a href="add">add</a></li>
						</ul>
					</li>
				</ul>
			
			</div>