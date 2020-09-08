<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
<!-- <h1>My First Google Map</h1>

<div id="googleMap" style="width:100%;height:400px;"></div>
<script>
function call_student(){
	$.ajax({
	      type: 'GET',
	      contentType : "application/json",
	      url: "/locations",
	     
	      success: function(resultData) { 
	    	  
	    	  resultData.forEach(function(std,i){
	    		  $("#std_table").append(
	    				'<tr>'
	    					+'<td>'+std.name+'</td>'
	    					+'<td>'+std.address+'</td>'
	    					+'<td><a  onclick="deleteStudent('+std.id+')">Del</a></td>'
	    				+'</tr>'
	    		  );
	    		  var mapProp= {
	    		    	    center:new google.maps.LatLng(std.lat,std.lng),
	    		    	    zoom:5,
	    		    	  };
	    		    	  var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	    		  
	    	  });
	      }
	});
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcO8M0vmasl_A0umgcrxwmCAo-8eXDUuE&callback=myMap"></script>
 -->
</body>
</html>