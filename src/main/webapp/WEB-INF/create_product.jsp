<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.tiny.cloud/1/jjx3ynxjpab601a8mlxcqrj4c62hoe238rpf2qkm19s152ow/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/custom.css' />" type="text/css">
<style>
	#btn-custom{
		color:white;
		background-color:#e7ab3c;
	}

</style>

</head>
<body>
<%@ include file="bootstrap.jsp" %>
<div class="container">
<h2 style="margin-top:10px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">Create Post</h2>

<div class="row">

<div class="col-6 auto">
<form:form action="save_product" method="POST" enctype="multipart/form-data" modelAttribute="product" style="width:100%;padding:40px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">
<div class="form-group">
	<label style="font-style: oblique; font-size: 20px;">Name:</label>
	<form:input path="product_name" class="form-control" placeholder="Name..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
<label style="font-style: oblique; font-size: 20px;">Category:</label>
<form:select path="category_id" class="custom-select">
	<c:forEach items="${categories }" var="cat">
	<form:option value="${cat.cat_id }">${cat.cat_name }</form:option>
	</c:forEach>
</form:select>
</div>
<div class="form-group">
	<label style="font-style: oblique; font-size: 20px;">Price:</label>
	<form:input path="price" class="form-control" placeholder="Price..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
	<label style="font-style: oblique; font-size: 20px;">Review :</label>
	<div class="row justify-content-md-center">
    <div class="col-md-12 col-lg-12">
      <div class="form-group">
         <form:textarea id="editor" path="descr" placeholder="Write your isssue"></form:textarea>
      </div>
    </div>
  </div>
</div>
<div class="form-group">
<label style="font-style: oblique; font-size: 20px;">Shop:</label>
<form:select path="shop_id" class="custom-select">
	<c:forEach items="${shops }" var="shop">
	<form:option value="${shop.shop_id }">${shop.shop_name }</form:option>
	</c:forEach>
</form:select>
</div>
<div class="form-group">
<label style="font-style: oblique; font-size: 20px;">Brand:</label>
<form:select path="brand_id" class="custom-select">
	<c:forEach items="${brands }" var="brand">
	<form:option value="${brand.brand_id }">${brand.brand_name }</form:option>
	</c:forEach>
</form:select>
</div>
<div class="from-group">
	<form:input style="font-style: oblique; font-size: 20px;margin:0px 0px 10px;" path="file" type="file" name="file" id="file" onchange="loadFile(event)" class="form-contorl"/>
</div>
<button type="submit" class="btn form-control" id="btn-custom">Post</button>
</form:form>
</div>
<div class="col-4 auto">
	<img id="output" width="100%" style="margin-top:200px;"/>	
</div>
</div>
</div>

<script>
var loadFile = function(event) {
	var image = document.getElementById('output');
	image.src = URL.createObjectURL(event.target.files[0]);
};
</script>
<script>
  tinymce.init({
    selector: 'textarea#editor',
    skin: 'bootstrap',
    plugins: 'lists, link, image, media',
    toolbar: 'h1 h2 bold italic strikethrough blockquote bullist numlist backcolor | link image media | removeformat help',
    menubar: false
  });
</script>
</body>
</html>