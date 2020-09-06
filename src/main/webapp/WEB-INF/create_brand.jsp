<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="container">
<h2 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;">Add Brand</h2>
<form:form action="save_brand" method="POST" modelAttribute="brand" style="width:300px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Name:</label>
		<form:input path="brand_name" class="form-control" placeholder="Name..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<button type="submit" class="btn btn-secondary">Save</button>
</form:form>
</div>
</body>
</html>