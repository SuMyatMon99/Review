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
<h2 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;">Add Location</h2>
<form:form action="/save_location" method="POST" modelAttribute="location" style="width:300px; color:rgba(246, 75, 8, 0.876);font-style: oblique;">
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Name:</label>
		<form:input path="name" class="form-control" placeholder="Name..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Address:</label>
		<form:input path="address" class="form-control" placeholder="Address..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Latitudes:</label>
		<form:input path="lat" class="form-control" placeholder="Latitudes..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Longitudes:</label>
		<form:input path="lng" class="form-control" placeholder="Longitudes..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<div class="form-group">
		<label style="font-style: oblique; font-size: 20px;">Type:</label>
		<form:input path="type" class="form-control" placeholder="Type..." style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"/>
</div>
<form:errors path="name" cssClass="error"></form:errors>
<button type="submit" class="btn btn-secondary">Save</button>
</form:form>
</div>
</body>
</html>