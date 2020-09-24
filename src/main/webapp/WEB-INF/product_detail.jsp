<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="bootstrap.jsp"%>

<div class="card m-2 col-5" style="max-height: 300px;">
							<div class="row no-gutters">
								<div class="col-md-4 mt-2">
									<img src="/images/${product.photoPath }" class="card-img"
										alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<div class="row">
											<h3 class="card-title">${product.product_name }</h3>
											<span class="card-text"
												style="max-height: 50px; overflow: hidden; margin-top: 20px; margin-bottom: 20px;">${prod.descr }
											</span> <strong class="card-text">${product.shop.shop_name}</strong>

										</div>

									</div>
									<a href="/product_list/details/" class="orange-text d-flex flex-row-reverse p-2">
						      	<h5 class="waves-effect waves-light">Read more >></h5>
    								</a>
								</div>
							</div>
							
						</div>
</body>
</html>