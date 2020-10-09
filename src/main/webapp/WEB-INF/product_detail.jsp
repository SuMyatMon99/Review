<%@ include file="/WEB-INF/common/include.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		$("#show").click(function() {
			$(".commentBox").slideToggle("slow");
		});

	});
</script>
<script>
	tinymce
			.init({
				selector : 'textarea#editor',
				skin : 'bootstrap',
				plugins : 'lists, link, image, media',
				toolbar : 'h1 h2 bold italic strikethrough blockquote bullist numlist backcolor | link image media | removeformat help',
				menubar : false
			});
</script>

<div class="container">
	<div class="row mt-5 mb-5 text-wrap">
	<div class="col-lg-1"></div>
	<div class="col-lg-9">
		<div class="col-lg-6 col-12">
			<img src="/images/${product.photoPath}" class="img" alt="...">
		</div>
		<div class="col-lg-6 col-12">
			<h3 class="card-title">${product.product_name }</h3>
			<span class="h5 mt-5">Shop Name :</span> <span class="card-text mt-5">${product.shop.shop_name}</span><br>
			<h6 class="h5">
				Rating :<span class="fa fa-star checked"></span> <span
					class="fa fa-star checked"></span> <span class="fa fa-star checked"></span>
				<span class="fa fa-star"></span> <span class="fa fa-star"></span><label>${product.totalRating}</label>
			</h6>

		</div>
		<div class="col-lg-12 col-12">
			<h4>Details:</h4>
			<p class="card-text text-justify">${product.descr }</p>
			<div class="row">
				<div class="col-6">
					<a href="#" id="show" class="btn btn-custom d-block"
						data-toggle="modal" data-whatever="@fat">Review</a>

				</div>
				<div class="col-6">
					<a href="#" id="show" class="btn btn-custom d-block"
						data-toggle="modal" data-target="#exampleModal"
						data-whatever="@getbootstrap">Rating</a>
				</div>
			</div>

			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">New message</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="/review/create" method="POST">
							<input type="hidden" value="${product.product_id }"
								name="product_id" />
							<div class="modal-body">
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Recipient:</label>
									<input type="text" name="comment" class="form-control"
										id="recipient-name" />
								</div>
								<div class="form-group">
										 <div class="rate">
    										<input type="radio" id="star5" name="rating" value="5" />
    											<label for="star5" title="text">5 stars</label>
    										<input type="radio" id="star4" name="rating" value="4" />
    											<label for="star4" title="text">4 stars</label>
    										<input type="radio" id="star3" name="rating" value="3" />
    											<label for="star3" title="text">3 stars</label>
    										<input type="radio" id="star2" name="rating" value="2" />
    											<label for="star2" title="text">2 stars</label>
    										<input type="radio" id="star1" name="rating" value="1" />
    											<label for="star1" title="text">1 star</label>
  											</div>
									</div>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Send
									message</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
		<div class="commentBox col-lg-12 col-12">
			<div class="col-lg-12 col-12">
				<c:forEach items="${reviews }" var="r" varStatus="row">
					<div class="card">
						<div class="card-header">
							<img src="/images/${r.user.photoPath }" class="rounded-circle" alt="...." width="100">
							<label>${r.user.username }</label><br>
						</div>
						<div class="card-body">
							<label>${r.comment } : </label> <label>${r.rating } </label>
							<hr>
							<br>
						</div>
					</div>
				</c:forEach>
				<div class="col-lg-12">
					<form action="/review/create" method="post">
						<div class="col-lg-6">
							<input type="hidden" value="${product.product_id }"
								name="product_id" />
						</div>
							<div class="form-group">							
							<div class="col-lg-12">
								<textarea id="editor" name="comment"
									placeholder="Write your isssue"></textarea>
						</div>
						</div>
						<div class="form-group">
										 <div class="rate">
    										<input type="radio" id="star5" name="rating" value="5" />
    											<label for="star5" title="text">5 stars</label>
    										<input type="radio" id="star4" name="rating" value="4" />
    											<label for="star4" title="text">4 stars</label>
    										<input type="radio" id="star3" name="rating" value="3" />
    											<label for="star3" title="text">3 stars</label>
    										<input type="radio" id="star2" name="rating" value="2" />
    											<label for="star2" title="text">2 stars</label>
    										<input type="radio" id="star1" name="rating" value="1" />
    											<label for="star1" title="text">1 star</label>
  											</div>
									</div>
								<button type="submit" class="btn btn-custom d-block">Submit</button>


					</form>
				</div>
			</div>
		</div>
		</div>
		<div class="col-lg-2 mt-1">
			<h4>Related Reviews</h4>
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
