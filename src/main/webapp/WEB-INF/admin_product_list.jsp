	<%@ include file="/WEB-INF/common/include.jsp"%>    
	<section class="content">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<a href="/admin/product_list">ProductList</a>
					<h3 style="color: rgba(246, 75, 8, 0.876); font-style: oblique;">
						Shop List</h3>
					<table class="table"
						style="color: rgba(246, 75, 8, 0.876); font-style: oblique;">
						<thead>
							<tr>
								<th>No</th>
								<th>User</th>
								<th>Product Name</th>
								<th>Description</th>
								<th>PhotoPath</th>
								<th>Date</th>
								<th>Category</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products }" var="shop" varStatus="row">
								<tr>
									<td>${row.count }</td>
									<td>${shop.user.username }</td>
									<td>${shop.product_name }</td>
									<td>${shop.descr }</td>
									<td>${shop.photoPath }</td>
									<td>${shop.date }</td>
									<td>${shop.category.cat_name }</td>
									<td><a href="/admin/product_delete/${shop.product_id }"
										class="btn btn-danger">DELETE</a><a
										href="/admin/product_edit/${shop.product_id }"
										class="btn btn-primary">EDIT</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>