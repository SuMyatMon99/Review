<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location List</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="container">
<h3 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"> Location List</h3>
<table class="table" style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;">
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Address</th>
			<th>Latitudes</th>
			<th>Longitudes</th>
			<th>Type</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${locations }" var="loc" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${loc.name }</td>
				<td>${loc.address }</td>
				<td>${loc.lat }</td>
				<td>${loc.lng }</td>
				<td>${loc.type }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>