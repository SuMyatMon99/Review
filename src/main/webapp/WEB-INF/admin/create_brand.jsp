
<%@ include file="/WEB-INF/common/include.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6 col-6">
            <h1 class="m-0">Manage Brand</h1>
          </div><!-- /.col -->
          <div class="col-sm-6 col-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Create</li>
            </ol>
          </div><!-- /.col -->
                    <a href="/brand/brand_list" class="btn btn-primary mt-4 ml-4">Brand List</a>
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
<div class="container">
<div class="col-lg-6">
<form:form action="save_brand" class="form-center" method="POST" modelAttribute="brand" style="font-style: oblique;">
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Name:</label>
		<form:input path="brand_name" class="form-control" placeholder="Name..." style="font-style: oblique;"/>
</div>
<button type="submit" class="btn btn-secondary form-control">Save</button>
</form:form>
</div>
</div>
</div>