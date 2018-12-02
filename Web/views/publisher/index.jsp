<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Publisher</title>
</head>
<body>
	<a href="/MVC/publisher/add.html">Add</a>
	<form method="post">
		<table>
			<tr>
				<td><button>Delete</button></td>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="o" items="${list}">

				<tr>
					<td><input type="checkbox" value="${o.id}" name="del"></td>
					<td>${o.id}</td>
					<td>${o.name}</td>
					<td><a href="/MVC/publisher/edit.html?id=${o.id}"> <img
							src="/MVC/images/edit.png" alt="Edit">
					</a></td>

					<td><a href="/MVC/publisher/del.html?id=${o.id}"> <img
							src="/MVC/images/trash.png" alt="Edit">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>