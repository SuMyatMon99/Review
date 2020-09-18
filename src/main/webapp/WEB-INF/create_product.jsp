<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<%@ include file="bootstrap.jsp" %>
<div class="container">
<h2 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;">Add Product</h2>
<form:form action="save_product" method="POST" enctype="multipart/form-data" modelAttribute="product" style="width:300px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">
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
	<label style="font-style: oblique; font-size: 20px;">File to upload</label>
	<form:input path="file" type="file" name="file" />
</div>
<button type="submit" class="btn btn-secondary">Save</button>
</form:form>
</div>
</body>
</html>