<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" class="form">
		<input type="hidden" name="id" value="${o.id}">
		<div>
			<label>Name</label> <input type="text" name="name" value="${o.name}">
		</div>
		<div>
			<button class="btn btn-primary">Save</button>
		</div>
	</form>
</body>
</html>