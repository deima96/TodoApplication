<%@ include file="common/Header.jspf" %>
<%@ include file="common/Navigation.jspf" %>	

<html>
<head>
	<title>My html title - jsp</title>
</head>
<body>
	<div class="container text-center mt-5">
		<h2>Welcome ${name}</h2>
	
		<p><a href="list-todos" class="text-decoration-none icon-link icon-link-hover" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">Manage</a> your Todos</p>
	</div>
	
</body>
</html>