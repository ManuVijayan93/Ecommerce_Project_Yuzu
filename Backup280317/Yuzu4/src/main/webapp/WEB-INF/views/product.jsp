<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>


	<div>

		<div>




			<center>
				<h2>
					<center>
						<h1>List of Products</h1>

						<a href="manage_product_create" class="btn btn-primary"
							role="button">Add Product</a>
				</h2>
			</center>




			<hr>

			<table border="2" class="table table-striped table-hover">

				<thead>
					<tr>
						<td>Product Image</td>
						<td>ID</td>
						<td>Name</td>
						<td>Price</td>
						<td>Description</td>
						<td>Category Name</td>
						<td>Supplier Name</td>
						<td>Action</td>
					</tr>

				</thead>

				<c:forEach var="product" items="${productList}">
					<tr>


						<td><c:url value="/resources/images/${product.id}.png"
								var="src" /> <img src="${src }" style="width: 70px"
							align="middle" /></td>


						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.description}</td>
						<td>${product.category.name}</td>
						<td>${product.supplier.name}</td>

						<td><a
							href="<c:url value="/manage_product_edit/${product.id}"/>">Edit
								<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="/manage_product_delete/${product.id}"/>">
								<span class="glyphicon glyphicon-trash"></span>delete
						</a></td>

					</tr>
				</c:forEach>


			</table>
</body>
</html>