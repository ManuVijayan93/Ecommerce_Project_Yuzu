<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>


<script src="<c:url value="/resources/js/controller.js" /> "></script>
</head>
<body>

	<c:url var="url" value="/resources/images/${product.id}.png"></c:url>
	<img src="${url}" style="width: 10%" />
	<br> Product ID : ${product.id }
	<br> Product Name : ${product.name }
	<br> Price : ${product.price }
	<br> Category : ${product.category.name }
	<br> Supplier : ${product.supplier.name }
	<br>


	<div>


		<a href="<c:url value="/getAllProducts"></c:url>">Back</a>
	</div>
</body>
</html>