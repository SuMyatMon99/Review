<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="container">
<h2 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;">Add Category</h2>
<form:form action="save_category" method="POST" modelAttribute="category" style="width:300px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Category:</label>
		<form:input path="cat_name" class="form-control" placeholder="Category..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<button type="submit" class="btn btn-secondary">Save</button>
</form:form>
</div>
</body>
</html>