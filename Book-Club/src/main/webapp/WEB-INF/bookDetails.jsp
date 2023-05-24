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
<title>Book Details Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container mt-5">

		<p>
			<c:out value="${oneBook.poster.userName }" />
			read
			<c:out value="${oneBook.title }" />
			by
			<c:out value="${oneBook.author}" />
		</p>

		<p>
			Here are
			<c:out value="${oneBook.poster.userName }" />
			's thoughts: I love the book.........
		</p>

		<c:choose>
			<c:when test="${eachBook.poster.id == userId}">
				<!--  -->

				<!-- ===============================================EDIT======================================================================== -->
				<a href="/books/edit/${eachBook.id }">Edit</a>

				<!-- ===========================================DELETE ==================================================================== -->

				<form action="/books/${eachBook.id }" method="POST">
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="btn btn-danger">Delete</button>
				</form>
			</c:when>

			<c:otherwise>

			</c:otherwise>

		</c:choose>


	</div>
</body>
</html>