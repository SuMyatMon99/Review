<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.tiny.cloud/1/jjx3ynxjpab601a8mlxcqrj4c62hoe238rpf2qkm19s152ow/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/custom.css' />" type="text/css">
<style>
	#profilemain{
		margin-top:100px;
	}
	.hidden{
		display:none;
	}
	
</style>
<script>
	$(document).ready(function(){
		$("#file").change(function(){
			var formData = new FormData();
	        formData.append('file', $('input[type=file]')[0].files[0]);
	        formData.append('username',$('#username').val());
		 $.ajax({
             url : '/profile/update',
             data : formData,
             processData : false,
             contentType : false,
             type : 'POST',
             success : function(data) {
                 alert("Successfully upload profile.");
             },
             error : function(err) {
                 alert("Failed to upload.");
             }
         });
		
	});
	});
</script>
</head>
<body>
<%@ include file="bootstrap.jsp"%>
<div class="container" id="profilemain">
	<div class="row">
		<div class="col-3" >
			<form action="/profile/update" method="post" enctype="multipart/form-data" id="myform">
				<input type="hidden" id="username" name="username" value="${user.username }">
				<input type="file" name="file" id="file"/>
			</form>
			<img style="border-radius:50%;" width="200" class="border-circle" src="/images/${user.photoPath }" alt="">	
		</div>
		<div class="col-4">
			<div class="row">
				<h1>${user.username }</h1>
			</div>
			<div class="row">	
				<h2>Min Ko.</h2>
			</div>
			<div class="row">	
				<h5 class="col-2">12333</h5>
				<span class="col-3"> IMPACT </span>
				<span><strong>0  </strong>FOLLOWER</span>
			</div>
		</div>
	</div>
</div>
</body>
</html>