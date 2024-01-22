<%@ include file="common/Header.jspf" %>
<%@ include file="common/Navigation.jspf" %>	

<div class="container">
		<h1>Todo List</h1>
		<table class="table">
			<thead>
				<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it done?</th>
				<th>
				<th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done }</td>
						<td><a href="delete-todo?id=${todo.id }" class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id }" class="btn btn-success">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="add-todos" class="btn btn-success">Add Todo</a>
</div>
	
<%@ include file="common/Footer.jspf" %>
