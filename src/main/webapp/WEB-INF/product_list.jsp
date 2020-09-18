<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop List</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="container">
<h3 style=" color:rgba(246, 75, 8, 0.876);font-style: oblique;"> Shop List</h3>
<div class="row">
<c:forEach items="${products }" var="prod" varStatus="row">
<div class="col-4">
<div class="card">
  <img class="card-img-top" src="./images/${prod.photoPath}" alt="image" width="200">
  <div class="card-body">
    <h5 class="card-title">${prod.product_name }</h5>
    <p class="card-text">Shop : ${prod.shop.shop_name }</p>
    <p class="card-text">Description : ${prod.descr}</p>
    <ul class="nav bg-light">
    <li class="nav-item"><a href="#" class="btn btn-light nav-link">Comment</a></li>
    <li class="nav-item"><a href="#" class="btn btn-light nav-link">Vote</a></li>
    </ul>   
  </div>
</div>
</div>
</c:forEach>
</div>
</div>
</body>
</html>