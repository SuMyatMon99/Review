<%@ include file="/WEB-INF/common/include.jsp"%>    
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6 col-6">
            <h1 class="m-0">Manage Shop</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">List</li>
            </ol>
          </div><!-- /.col -->
          <div class="col-lg-8 mt-4">
        		<a href="/shop/create_shop" class="btn btn-primary"> Create Shop</a>
        	</div>
        	<div class="col-lg-4 float-sm-right mt-4">
        		<form action="/shop/search" method="post">
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
        </div><!-- /.row -->
        
      </div><!-- /.container-fluid -->
    </div>
<div class="col-md-12 col-6">
<div class="text-center">
<table class="table" style=" color:gray;font-style: oblique;">
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Address</th>
			<th>Lat</th>
			<th>Lng</th>
			<th>Type</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${shops }" var="shop" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${shop.shop_name }</td>
				<td>${shop.address }</td>
				<td>${shop.lat }</td>
				<td>${shop.lng }</td>
				<td>${shop.type }</td>
				<td><a href="/shop/shop_delete/${shop.shop_id }" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</div>