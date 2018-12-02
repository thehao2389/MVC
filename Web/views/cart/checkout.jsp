<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
	<div class="container">
		<form method="post" class="form">
			<p>
				<label>Email</label> <input type="email" name="email">
			</p>
			<p>
				<label>Tel</label> <input type="tel" name="tel">
			</p>
			<p>
				<label>Address</label> <input type="text" name="address">
			</p>
			<p>
				<button class="btn btn-primary">Order</button>
		</form>
		
		<table class="table table-bordered">
			<c:forEach var="o" items="${list}">
				<tr>
					<td>${o.title}</td>
					<td>${o.quantity}</td>
					<td>${o.price}</td>
					<td><img width="150px" src="/MVC/upload/${o.imageUrl}"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>