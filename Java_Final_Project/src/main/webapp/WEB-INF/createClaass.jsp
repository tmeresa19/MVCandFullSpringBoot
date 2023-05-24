This is a JSP (JavaServer Pages) file that contains HTML code along with JSP tags and Spring tags. It is used to create
a form for creating a new course with various input fields such as name, days of the week, price, time, and description.
The JSP tags are used to dynamically generate HTML content based on the data passed from the server-side. The Spring
tags are used to bind the form data to a model attribute and to display any validation errors. The file also includes
links to external CSS and JavaScript files for styling and functionality.
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!-- c:out ; c:forEach etc. -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- Formatting (dates) -->
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<!-- form:form -->
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

				<!-- for rendering errors on PUT routes -->
				<%@ page isErrorPage="true" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<title>Donation Page</title>
						<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
						<link rel="stylesheet" href="/css/main.css">
						<!-- change to match your file/naming structure -->
						<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
						<script type="text/javascript" src="/js/app.js"></script>
						<!-- change to match your file/naming structure -->
					</head>

					<body class="bg-dark text-light">
						<div class="container mt-5">


							<div>
								<a href="/claasses">Back to dashboard</a>
							</div>

							<div>
								<a href="/logout">Logout</a>
							</div>

							<h1>Create a Course</h1>


							<form:form action="/claasses/new" method="POST" modelAttribute="newClaass">
								<form:hidden path="instructor" value="${userId }" />

								<div class="form-group mb-3">
									<form:label path="claassName">Name</form:label>
									<form:input path="claassName" />
									<form:errors path="claassName" class="text-danger" />
								</div>

								<div class="form-group mb-3">
									<form:label path="weekDay">Days of Week</form:label>
									<form:input path="weekDay" />
									<form:errors path="weekDay" class="text-danger" />
								</div>

								<div class="form-group mb-3">
									<form:label path="price">Drop-in Price</form:label>
									<form:input type="number" path="price" />
									<form:errors path="price" class="text-danger" />
								</div>

								<div class="form-group mb-3">
									<form:label path="time">Time</form:label>
									<form:input path="time" type="time" step="300" pattern="^([01]\d|2[0-3]):([0-5]\d)$" />
									<form:errors path="time" class="text-danger" />
								</div>

								<div class="form-group mb-3">
									<form:label path="description">Description</form:label>
									<form:input path="description" />
									<form:errors path="description" class="text-danger" />
								</div>

								<button type="submit" class="btn btn-primary mb-3">Submit</button>

							</form:form>

						</div>
					</body>

					</html>