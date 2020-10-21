<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>User Application</title>
</head>
<body>
	<form method="post" action="addUser">
		<div class="form-group">
			<label for="inputEmail">Email address</label> <input type="email"
				class="form-control" id="inputEmail" name="email" value="${userItem.email}">

		</div>

		<div class="form-group">
			<label for="inputName">Name</label> <input type="text"
				class="form-control" id="inputName" name="name" value="${userItem.name}">

		</div>

		<div class="form-group">
			<label for="inputCity">City</label> <input type="text"
				class="form-control" id="inputCity" name="city"  value="${userItem.city}">

		</div>
		<button type="submit" class="btn btn-primary">Add</button>


	</form>

	<c:if test="${!empty userList}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Email</th>
					<th scope="col">Name</th>
					<th scope="col">City</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.email}</td>
					<td>${user.name}</td>
					<td>${user.city}</td>
					<td><div class="btn-group" role="group"
							aria-label="Basic example">
							<a href="updateUser/${user.email}"><button type="button" class="btn btn-warning">Edit</button></a>
							<a href="deleteUser/${user.email}"><button type="button" class="btn btn-danger">Delete</button></a>
						</div></td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>