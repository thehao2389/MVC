<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<div>
			<label>Name</label> <input type="text" name="name">
		</div>
		<div>
			<label>Parent</label> <select name="parent">
				<c:forEach var="o" items="${parents}">
					<option value="${o.id}">${o.name}</option>
				</c:forEach>
			</select>
			<frm:select name="parent" list="${parents}" />
			
		</div>

		<div>
			<button>Save</button>
		</div>
	</form>
	<p>${msg}</p>
</body>
</html>