	<%@ include file="/WEB-INF/common/include.jsp"%>  
	<style>
	.btn-right{
		float:right;
		margin-right:100px;
	}
	</style>
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Manage Product</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/product_list">Home</a></li>
              <li class="breadcrumb-item active">List</li>
            </ol>
           
          </div><!-- /.col -->
        </div><!-- /.row -->
                      <a href="/create_product" class="btn btn-primary btn-right">Create Product</a>
  
      </div><!-- /.container-fluid -->
    </div>  
	<section class="content">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<table class="table"
						style="margin-top:40px; font-style: oblique;">
						<thead>
							<tr>
								<th>No</th>
								<th>User</th>
								<th>Product Name</th>
								<th>Image</th>
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
									<td><img src="/images/${shop.photoPath }" width="100" alt="image"></td>
									<td>${shop.date }</td>
									<td>${shop.category.cat_name }</td>
									<td><a href="/admin/product_delete/${shop.product_id }"
										class="btn btn-danger">DELETE</a><a href="/admin/${shop.product_id }"
										class="btn btn-warning">Details</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	</div>