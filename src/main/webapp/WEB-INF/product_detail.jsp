<%@ include file="/WEB-INF/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ include file="bootstrap.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.tiny.cloud/1/jjx3ynxjpab601a8mlxcqrj4c62hoe238rpf2qkm19s152ow/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/custom.css' />" type="text/css">

<script type="text/javascript">
	$(document).ready(function(){

		$("#show").click(function(){
			$(".commentBox").slideToggle("slow");
		});
	});	
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

<div class="container">
	<div class="row mt-5 mb-5 text-wrap">
		<div class="col-md-6">
			<img src="/images/${product.photoPath}" class="img" alt="...">
		</div>
		<div class="col-md-6">
			<h3 class="card-title">${product.product_name }</h3>
			<h5>Details :</h5>
			<p class="card-text">${product.descr }</p>
			<span class="h5">Shop Name :</span> <span class="card-text">${product.shop.shop_name}</span>
			<div class="row">
				<div class="col-6">
					<a href="#" id="show" class="btn btn-custom d-block" data-toggle="modal"
						data-target="#exampleModal" data-whatever="@fat">Review</a>

				</div>
				<div class="col-6">
					<a href="#" id="show" class="btn btn-custom d-block" data-toggle="modal"
						data-target="#exampleModal" data-whatever="@getbootstrap">Rating</a>
				</div>
			</div>

			<%-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">New message</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form:form action="/review/create" method="POST" modelAttribute="review">
						<form:input type="hidden" value="${product.product_id }" path="product_id"/>
						<div class="modal-body">
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Recipient:</label>
									<form:input type="text" path="comment" class="form-control" id="recipient-name"/>
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">Message:</label>
									<form:select class="form-select" path="rating" id="message-text">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
									</form:select>
								</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Send
								message</button>
						</div>
						</form:form>
					</div>
				</div>
			</div> --%>
			
		</div>
		<div class="commentBox">
<div class="col-12">
	<c:forEach items="${reviews }" var="r" varStatus="row">
		<div class="card">
			<div class="card-header">
		<label>${r.user.username }</label><br>
		</div>
		<div class="card-body">
		<label>${r.comment } : </label>
		<label>${r.rating } </label><hr><br>
		</div>
		</div>
	</c:forEach>
	<div class="text-center">
	<form action="/review/create" method="post" style="width:90%;">
	<input type="hidden" value="${product.product_id }" name="product_id"/>
  <div class="row justify-content-md-center">
    <div class="col-12 ">
      <div class="form-group">
         <textarea id="editor" name="comment" placeholder="Write your isssue"></textarea>
      </div>
      <button type="submit" class="btn btn-custom d-block">Submit</button>
    </div>
  </div>

				
	</form>
	</div>
		</div>
		</div>
</div>
<div class="row">
	<c:forEach items="${products }" var="p" varStatus="row">
	<div class="card col-md-3">
		<div class="col-10">
			<a href="/review/${p.product_id }"> <img alt=".."
				class="d-block w-100 m-2 card-img" src="/images/${p.photoPath }">
			</a>
		</div>
		</div>
	</c:forEach>
	</div>
</div>