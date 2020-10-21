<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Data Entry</title>
</head>
<body>
<form action="saveCustomer" method="post">
<table>
<tr>
<td><label>Customer Number</label></td>
<td><input type="text" name="custno"/></td>
</tr>
<tr>
<td><label>Customer Name</label></td>
<td><input type="text" name="custname"/></td>
</tr>
<tr>
<tr>
<td><label>Order Value</label></td>
<td><input type="text" name="ordervalue"/></td>
</tr>
<tr>
<td><input type="submit" value="Add Customer" ></td>
</tr>
</table>
</form>

	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
<table border="1">
<tr>
<td>Customer Number</td>
<td>Customer Name</td>
<td>Order Value</td>
<td>Customer Created Time</td>
</tr>
<c:forEach items="${custList}" var="customer"> 
 <form action="deleteCustomer" method="get"> 
<tr>
<td><input type="text" name="custno" value="${customer.custno}"/></td>
<td>${customer.custname}</td>
<td>${customer.ordervalue}</td>
<td>${customer.createdAt}</td>
<td><input type="submit" value="delete"/></td>
</tr>
</form>
</c:forEach>
</table>
</body>
</html>