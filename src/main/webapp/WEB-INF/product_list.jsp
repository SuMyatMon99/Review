
<%@ include file="/WEB-INF/common/include.jsp"%>
	<h2>Recent Reviews</h2>
	<div class="container" style="min-height: 300px;">
		<div class="row">
			<div class="col-9">
				<div class="row">
					<c:forEach items="${products}" var="prod" varStatus="row">
						<div class="card m-2 col-5" style="max-height: 300px auto;">
							<div class="row no-gutters">
								<div class="col-md-4 mt-2">
									<img src="/images/${prod.photoPath }" class="card-img"
										alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h3 class="card-title">${prod.product_name }</h3>
									</div>
									<div class="row">
										<span class="card-text"
											style="max-height: 50px; overflow: hidden; margin-top: 20px; margin-bottom: 20px;">${prod.descr }
										</span><br> <strong class="card-text">${prod.shop.shop_name}</strong>
									</div>
									<a href="/review/${prod.product_id }"
										class="orange-text d-flex flex-row-reverse p-2"> <span
										class="h5 waves-effect waves-light">Read more >></span>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-3">
				<c:forEach items="${products}" var="prod" varStatus="row">
					<div class="card" style="max-height: 200px; margin: 10px;">
						<a href="/product/${prod.product_id }" class="card-title"> <img
							src="/images/${prod.photoPath }" class="card-img-top" alt="..."
							style="max-height: 150px; max-weight: auto;"> <span
							class="card-text">${prod.product_name }</span>

						</a>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>

<script type="text/javascript">
			function clearSearch() {
				window.location = "[[@{/product_list}]]";
			}
		</script>
