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
<div class="container" id="profilemain">
<div>
			<form action="/profile/update" method="post" enctype="multipart/form-data" id="myform">
				<input type="hidden" id="username" name="username" value="${user.username }">
				<input type="file" name="file" class="hidden"/>
			</form>
				
		</div>
	<div class="row">
		<div class="col-lg-4 col-6">
		<img src="/images/${user.photoPath }" alt="" id="img">
			<button type="submit" id="btn" class="btn"><i class="fa fa-camera" aria-hidden="true" id="icon"></i></button>
		</div>
		<div class="col-lg-6 col-6">
			<div class="row">
				<h1>${user.username }</h1>
			</div>
			<div class="row">	
				<h2>Min Ko.</h2>
			</div>
			<div class="row">	
				<h5 class="col-lg-2">12333</h5>
				<span class="col-lg-3"> IMPACT </span>
				<span class="col-lg-3">FOLLOWER</span>
			</div>
		</div>
	</div>
</div>
