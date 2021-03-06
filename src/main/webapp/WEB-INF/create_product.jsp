
<%@ include file="/WEB-INF/common/include.jsp"%>
<div class="container">
	<h2 style="margin-top: 10px; font-style: oblique;">Create Post</h2>

	<div class="row">
		<div class="col-lg-4 auto">
			<img id="output" />
		</div>
		<div class="col-lg-6 auto">
			<form:form action="save_product" method="POST"
				enctype="multipart/form-data" modelAttribute="product"
				id="mycreatePost">
				<div class="form-group">
					<label>Name:</label>
					<form:input path="product_name" class="form-control"
						placeholder="Name..." style="font-style: oblique;" />
				</div>
				<div class="form-group">
					<label>Category:</label>
					<form:select path="category_id" class="custom-select">
						<c:forEach items="${categories }" var="cat">
							<form:option value="${cat.cat_id }">${cat.cat_name }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label>Price:</label>
					<form:input path="price" class="form-control"
						placeholder="Price..."
						style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;" />
				</div>
				<div class="form-group">
					<label>Review :</label>
					<div class="row justify-content-md-center">
						<div class="col-md-12 col-lg-12">
							<div class="form-group">
								<form:textarea id="editor" path="descr"
									placeholder="Write your isssue"></form:textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label>Shop:</label>
					<form:select path="shop_id" class="custom-select">
						<c:forEach items="${shops }" var="shop">
							<form:option value="${shop.shop_id }">${shop.shop_name }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label>Brand:</label>
					<form:select path="brand_id" class="custom-select">
						<c:forEach items="${brands }" var="brand">
							<form:option value="${brand.brand_id }">${brand.brand_name }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="from-group">
					<form:input path="file" type="file" name="file" id="file"
						onchange="loadFile(event)" class="form-contorl" />
				</div>
				<button type="submit" class="btn form-control" id="btn-custom">Post</button>
			</form:form>
		</div>

	</div>
</div>

<script>
	var loadFile = function(event) {
		var image = document.getElementById('output');
		image.src = URL.createObjectURL(event.target.files[0]);
	};
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
