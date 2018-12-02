<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="o" items="${list}">
	<div class="col-3">
		<div class="item">
			<img src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
			<div class="info">${o.title}</div>
			<a href="${pageContext.request.contextPath}/home/detail.html?id=${o.id}">${o.title}</a>
		</div>
	</div>
</c:forEach>