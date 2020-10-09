	<%@ include file="/WEB-INF/common/include.jsp"%>  
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Manage Review</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">List</li>
            </ol>
           
          </div><!-- /.col -->
        </div><!-- /.row -->
        <div class="row">
        	<div class="col-lg-8">
        		<a href="/admin/product_list" class="btn btn-primary"> < ProductList</a>
        	</div>
        	<div class="col-lg-4 float-sm-right">
        		<form action="/admin/review/search" method="post">
        		<div class="row">
        		<div class="form-group mr-3">
        			<input type="search" class="form-control" name="search" placeholder="Enter the something about this review">
        			</div>
        		<div class="form-group">	
        			<input type="submit" value="Search" class="btn btn-primary">
        			</div>
        		</div>
        		</form>
        	</div>
        </div>
      </div><!-- /.container-fluid -->
    </div>  
	<section class="content">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-7">
					<table class="table"
						style="font-style: oblique;">
						<thead>
							<tr>
								<th>No</th>
								<th>User</th>
								<th>Product Name</th>
								<th>Product's Image</th>
								<th>Comment</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reviews}" var="r" varStatus="row">
								<tr>
									<td>${row.count }</td>
									<td>${r.user.username }</td>
									<td>${r.product.product_name }</td>
									<td><img src="/images/${r.product.photoPath }" width="100" alt="image"></td>
									<td>${r.comment }</td>
									<td><a href="/admin/review/delete/${r.reviewId }"
										class="btn btn-danger">DELETE</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	</div>