<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop List</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Manage Shop</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">List</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
<div class="container">
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
</body>
</html>