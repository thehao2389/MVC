<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
	<form method="post" class="form">
		<p>
			<label>Username</label> <input type="text" name="usr">
		</p>

		<p>
			<label>Password</label> <input type="password" name="pwd">
		</p>
		<p>
			<button class="btn btn-primary">Log On</button>
		</p>
	</form>
	<div class="error">${msg}</div>
</body>
</html>