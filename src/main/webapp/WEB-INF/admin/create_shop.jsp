<%@ include file="/WEB-INF/common/include.jsp"%>
<style>
	.form-margin{
		margin-left:300px;
	}
</style>
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
              <li class="breadcrumb-item active">Create</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
<div class="form-margin">
<form:form action="save_shop" method="POST" modelAttribute="shop" style="width:400px;font-style: oblique;">
<div class="form-group">
	<form:input path="shop_name" class="form-control" placeholder="Enter the shop's name..." style="font-style: oblique;"/>
</div>
<div class="form-group">
		<form:input path="address" class="form-control" placeholder="Enter the address..." style="font-style: oblique;"/>
</div>
<div class="form-group">
		<form:input path="lat" class="form-control" placeholder="Enter the latitudes..." style="font-style: oblique;"/>
</div>
<div class="form-group">
		<form:input path="lng" class="form-control" placeholder="Enter the longitudes..." style="font-style: oblique;"/>
</div>
<div class="form-group">
		<form:input path="type" class="form-control" placeholder="Enter the type..." style="font-style: oblique;"/>
</div>
<button type="submit" class="btn btn-secondary form-control">Save</button>
</form:form>
</div>
</div>