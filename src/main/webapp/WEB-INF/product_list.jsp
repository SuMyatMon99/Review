
<%@ include file="/WEB-INF/common/include.jsp"%>
<style>
	#mainBackgorund{
		background-image: url('/resources/img/dell.jpg');
		background-repeat: no-repeat;
		background-attachment: relative;
  		background-size: cover;
	}
</style>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="mainBackgorund">

    <!-- Main content -->
    <section class="content" style="min-height:500px;">
        <div class="container-fluid" style="padding-top:150px;">
        	<div class="text-center">
        	<div class="row">
        	<div class="col-lg-4"></div>
        	<div class="col-lg-4" style="width:200px; margin-bottom:20px;">
            	<h4 style="color:white;">42 million product reviews from people just like you</h4>
			</div>
        	</div>
        	
</div>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <form action="${pageContext.request.contextPath}/product_list/">
                        <div class="input-group">
                            <input type="search" name="keyword" class="form-control form-control-lg" placeholder="Type your keywords here">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-lg btn-default">
                                    <i class="fa fa-search" style="color:white;"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
  </div>
	<div class="container" style="min-height: 500px;">
		<h3 class="mt-3 mb-3">Recent Reviews</h3>
		<div class="row">
			<div class="col-lg-10">
				<div class="row">
					<c:forEach items="${products}" var="prod" varStatus="row">
					<div class="col-lg-4 col-6">
						<div class="card" style="max-height:250px;">
							<div class="row">
									<img id="productImg" src="/images/${prod.photoPath }"
										class="card-img p-3" alt="..." style="max-height:120px;width:auto;">
									<div class="card-body">
									<a href="/review/${prod.product_id }"><span class="card-title">${prod.product_name }</span></a>
										 <br><strong class="card-text ">Brand    : ${prod.brand.brand_name}</strong>									
										 <br><strong class="card-text ">Reviewer : ${prod.user.username}</strong>									
										<div class="rate">
    											<span class="fa fa-star checked"></span> 
    											<span class="fa fa-star checked"></span>
    											 <span class="fa fa-star checked"></span>
												<span class="fa fa-star"></span>
				 								<span class="fa fa-star"></span>
												<label>${prod.totalRating}</label>
  											</div>
									</div>
									
						
							</div>
						</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-lg-2 mt-1">
			<h4>Most Reviews</h4>
			<div class="row">
		<c:forEach items="${products }" var="p" varStatus="row">
		<div class="col-md-12 col-4">
			<div class="card" style="max-height:100px;margin-bottom:10px;overflow:hidden;">
					<a href="/review/${p.product_id }"> <img alt=".."
					style="max-height:80px;max-width:auto;"	src="/images/${p.photoPath }">
						
					</a>
					<label style="font-size:12px;">${p.product_name }</label>
			</div>
			</div>
		</c:forEach>
	</div>
			</div>
		</div>

</div>
<script type="text/javascript">
			function clearSearch() {
				window.location = "[[@{/product_list}]]";
			}
		</script>
