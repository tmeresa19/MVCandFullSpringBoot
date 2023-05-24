<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Create Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body class="bg-dark text-light">
	<div class="container mt-5">

		<p>
			Welcome,
			<c:out value="${userName}" />
		</p>

		<div>
			<a href="/logout">Logout</a>
		</div>

		<h1>Create a Book</h1>


		<form:form action="/books/new" method="POST" modelAttribute="newBook">
			<form:hidden path="poster" value="${userId }" />
			<!--We need to get the value of the author from the session(not by adding HttpSession Session since we don't need that as session exists in every page of a logged user . That means, I am able to access to userId variable(exact same name as what's been used in the user controller's /register route method as we created the session there) -->

			<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title" class="text-danger" />
			</div>

				<div class="form-group">
				<form:label path="author">Author</form:label>
				<form:input path="author" class="form-control"/>
				<form:errors path="author" class="text-danger" />
			</div>

			<div class="form-group">
				<form:label path="thoughts">My Thoughts</form:label>
				<form:input path="thoughts" class="form-control"/>
				<form:errors path="thoughts" class="text-danger" />
			</div>
			
				<div class="form-group">
			<label for="gender">Gender:</label>
			<form:select path="gender" class="form-control">
				<form:option value="">Select Gender</form:option>
				<form:option value="male">Male</form:option>
				<form:option value="female">Female</form:option>
				<form:option value="other">Other</form:option>
			</form:select>
		</div>
		
			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>

	</div>
</body>
</html>