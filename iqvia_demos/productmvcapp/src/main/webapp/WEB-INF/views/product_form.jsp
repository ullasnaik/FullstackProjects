<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<h2>New Product</h2>

	<form action="addProduct" method="post">

		<div>
			Product Code : <input type="text" name="prodCode">
		</div>
		<div>
			Name : <input type="text" name="name">
		</div>
		<div>
			Price : <input type="text" name="price">
		</div>
		<div>
			Category : <select name="category">
				<option>electronics</option>
				<option>apparel</option>
			</select>
		</div>

		<div>
			<input type="submit" value="Add Product">
		</div>

	</form>

	<div>
		<c:if test="${!empty products}">


			<table>
				<thead>
					<tr>
						<td>Code</td>
						<td>name</td>
						<td>price</td>
						<td>category</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach items="${products}" var="prod">

					<tr>
						<td>${prod.prodCode }</td>
						<td>${prod["name"]}</td>
						<td>${prod.price}</td>
						<td>${prod.category}</td>
						<td><a href="deleteProduct?prodCode=${prod.prodCode}">Delete</a>
					</tr>

				</c:forEach>
			</table>

		</c:if>
		
		<c:if test="${empty products}">
			<h4>No Products in Database</h4>
		</c:if>

	</div>


</body>
</html>