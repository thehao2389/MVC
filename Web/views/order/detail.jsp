<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>
	<b>Address:</b>${o.address}</p>
<p>
	<b>Tel:</b>${o.tel}</p>
<p>
	<b>Email:</b>${o.email}</p>
<p>
	<b>Status:</b>${o.statusName}</p>
<p>
	<b>Dated:</b>${o.date}</p>

<table>
	<c:forEach var="v" items="${o.details}">
		<tr>
			<td>${v.title}</td>
			<td>${v.price}</td>
			<td>${v.quantity}</td>
			<td><img width="100" src="/MVC/upload/${v.imageUrl}"></td>
		</tr>
	</c:forEach>
</table>