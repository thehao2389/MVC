<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<input type="hidden" name="id" value="${o.id}">
		<p>
			<label>Name</label> <input type="text" name="name" value="${o.name}">
		</p>
		<p>
			<button>Save</button>
		</p>
	</form>
	<p>${msg}</p>
</body>
</html>