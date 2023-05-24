<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">
	
		<p>Welcome, <c:out value="${userName}" /> </p>
		
		<div>
			<a href="/books">Back to dashboard</a>
		</div>
		
		<div>
			<a href="/logout">Logout</a>
		</div>
		
		<h1>Edit Book</h1>
		
		
	<form:form action="/books/edit/${oneBook.id }" method="PuT" modelAttribute="oneBook">
		<form:hidden path="poster" /> <!-- removed the  value="${userId }" since we want the author to be the same as who created. The person who edits this page can't be the author. -->
	<p> 
		<form:label path="title">Title</form:label>
		<form:input path="title" />
		<form:errors path="title"/>
	</p>
	
	<p> 
		<form:label path="author" >Author Name</form:label>
		<form:input path="author" />
		<form:errors path="author"/>
	</p>	
	
	<p> 
		<form:label path="thoughts">My Thoughts</form:label>
		<form:input path="thoughts" />
		<form:errors path="thoughts"/>
	</p>	
	
		<button type="submit" class="success">Edit</button>	
	
	</form:form>
		
	</div>
</body>
</html>