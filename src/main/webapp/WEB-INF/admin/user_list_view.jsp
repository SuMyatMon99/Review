<%@ include file="/WEB-INF/common/include.jsp"%>    
<h3 style="font-style: oblique;">User List</h3>
<table class="table" style=" font-style: oblique;">
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userList }" var="user" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${user.username }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>