<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<style>
	.form-margin{
		margin-left:300px;
	}
</style>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Manage Brand</h1>
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
<div class="container">
<div class="form-margin">
<form:form action="save_brand" class="form-center" method="POST" modelAttribute="brand" style="width:400px; font-style: oblique;">
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Name:</label>
		<form:input path="brand_name" class="form-control" placeholder="Name..." style="font-style: oblique;"/>
</div>
<button type="submit" class="btn btn-secondary form-control">Save</button>
</form:form>
</div>
</div>
</div>
</body>
</html>