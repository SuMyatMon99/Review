<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Manage Category</h1>
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
    <!-- /.content-header -->
<div class="container">
<table class="table" style=" color:gray;font-style: oblique;">
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categories }" var="cat" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${cat.cat_name }</td>
				<td><a href="/category/category_delete/${cat.cat_id}" class="btn btn-danger">DELETE</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</body>
</html>