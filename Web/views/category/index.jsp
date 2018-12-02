<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/MVC/category/add.html">Add</a>
	<table>
		<tr>
			<th>CategoryID</th>
			<th>CategoryName</th>
			<th>ParentId</th>
		</tr>

		<c:forEach var="o" items="${list}">

			<tr>
				<td>${o.id}</td>
				<td>${o.name}</td>
				<td>${o.parentName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>