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
<title>Product List</title>
<style>


#card-footer {
	width: 100%;
	margin-bottom: 0px;
	text-align: center;
}

//
rating
	* {
	margin: 0;
	padding: 0;
}

.rate {
	float: left;
	height: 46px;
	padding: 0 10px;
}

.rate:not(:checked)>input {
	position: absolute;
	top: -9999px;
}

.rate:not(:checked)>label {
	float: right;
	width: 1em;
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 30px;
	color: #ccc;
}

.rate:not(:checked)>label:before {
	content: '* ';
}

.rate>input:checked ~ label {
	color: #ffc700;
}

.rate:not(:checked)>label:hover, .rate:not(:checked)>label:hover ~ label
	{
	color: #deb217;
}

.rate>input:checked+label:hover, .rate>input:checked+label:hover ~ label,
	.rate>input:checked ~ label:hover, .rate>input:checked ~ label:hover ~
	label, .rate>label:hover ~ input:checked ~ label {
	color: #c59b08;
}
//
end

 

rating
</style>
</head>
<body>

	<div class="container-fluid">
	
	<div class="container">
            <div class="inner-header">
                <div class="row">
                    <div class="col-lg-2 col-md-2">
                        
                        </div>
                    <div class="col-lg-7 col-md-7">
                         <form class="form-inline my-2 my-lg-0" th:action="@{/}">
      <input class="form-control mr-sm-2" type="search" name="keyword" id="keyword" th:value="${keyword }" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
                    </div>
                    <div class="col-lg-3 text-right col-md-3">
                        
                    </div>
                </div>
            </div>
        </div>
				<h2>Recent Reviews</h2>

			<div class="container" style="min-height:300px;">
			<div class="row">
			<div class="col-9">
				<div class="row">
					<c:forEach items="${products}" var="prod" varStatus="row">
						<div class="card m-2 col-5" style="max-height: 300px;">
							<div class="row no-gutters">
								<div class="col-md-4 mt-2">
									<img src="/images/${prod.photoPath }" class="card-img"
										alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<div class="row">
											<h3 class="card-title">${prod.product_name }</h3>
											<span class="card-text"
												style="max-height: 50px; overflow: hidden; margin-top: 20px; margin-bottom: 20px;">${prod.descr }
											</span> <strong class="card-text">${prod.shop.shop_name}</strong>

										</div>

									</div>
									<a href="/product/${prod.product_id }" class="orange-text d-flex flex-row-reverse p-2">
						      	<h5 class="waves-effect waves-light">Read more >></h5>
    								</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-3">
					<c:forEach items="${products}" var="prod" varStatus="row">
						<div class="card" style="max-height:200px; margin:10px;">
									<img src="/images/${prod.photoPath }" class="card-img-top" 
										alt="..." style="max-height:150px; max-weight:auto;">
										
									<div class="card-body">		
											<a href="#" class="card-title">
											${prod.product_name }
											</a> 
									</div>
								</div>

					</c:forEach>
					</div>
					</div>
			</div>
			</div>
		<script type="text/javascript">
			function clearSearch() {
				window.location = "[[@{/product_list}]]";
			}
		</script>
		
</body>
</html>