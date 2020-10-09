
<%@ include file="/WEB-INF/common/include.jsp"%>    
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6 col-6">
            <h1 class="m-0">Manage Category</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/category/category_list">Home</a></li>
              <li class="breadcrumb-item active">List</li>
            </ol>
          </div><!-- /.col -->
          <div class="col-lg-8 mt-4">
        		<a href="/category/create_category" class="btn btn-primary"> Create Category</a>
        	</div>
        	<div class="col-lg-4 float-sm-right mt-4">
        		<form action="/category/search" method="post">
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