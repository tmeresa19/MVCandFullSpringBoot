<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Donation List</h1>
	<a href="/donations/new">Add a new donation</a>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation Name</th>
				<th>Donor</th>
				<th>Quantity</th>
				<th colspan = "2">Actions</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="eachDonation" items="${donationList }">
				<tr>
					<td> <c:out value="${eachDonation.id }" /> </td>
					<td> <a href="/donations/${eachDonation.id }"><c:out value="${eachDonation.donationName }" /></a> </td>
					<td> <c:out value="${eachDonation.donor }" /> </td>
					<td> <c:out value="${eachDonation.quantity }" /> </td>
					<td> <a href="/donations/edit/${eachDonation.id }">Edit</a> </td>
					<!-- to delete, we need to use a normal form(not form:form as we are not doing data binding -->
					
					<td> 
						
						<form action="/donations/${eachDonation.id }" method="POST">
							<input type="hidden" name="_method" value="DELETE" /> <!-- to cast from POST to DELETE method, we use hidden input. -->
							<button type="submit">Delete</button>
						
						</form>
					
					</td>
				</tr>
						
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>