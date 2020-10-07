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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.hidden{
		display:none;
	}
	#btn{
		position:absolute;
		float:right;
		margin-left:-110px;
		margin-top:10px;
	}
	#img{
		border-radius:50%;
		width:400px;
		height:200px;
	}
	
</style>
<script>
	$(document).ready(function(){
		$("#btn").click(function(){
			$(".hidden").click();
		});
		
		$(".hidden").change(function(){
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
		<div class="col-lg-3" >
			<form action="/profile/update" method="post" enctype="multipart/form-data" id="myform">
				<input type="hidden" id="username" name="username" value="${user.username }">
				<input type="file" name="file" class="hidden"/>
			</form>
			<img src="/images/${user.photoPath }" alt="" id="img">
			<button type="submit" id="btn" class="btn"><i class="fa fa-camera" aria-hidden="true" id="icon"></i></button>	
		</div>
		<div class="col-lg-4">
			<div class="row">
				<h1>${user.username }</h1>
			</div>
			<div class="row">	
				<h2>Min Ko.</h2>
			</div>
			<div class="row">	
				<h5 class="col-lg-2">12333</h5>
				<span class="col-lg-3"> IMPACT </span>
				<span><strong>0  </strong>FOLLOWER</span>
			</div>
		</div>
	</div>
</div>
</body>
</html>