<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tpl:layout title="Upload Multiple">
	<jsp:attribute name="content">
<form method="post" class="form" enctype="multipart/form-data">
		<p>
			<label>Choose Image</label> <input type="file" name="f"
					multiple="multiple">
		</p>
		<p>
			<button class="btn btn-primary">Upload</button>
		</p>
	</form>
	<c:forEach var="url" items="${list}">
			<img width="150"
				src="${pageContext.request.contextPath}/upload/${url}">
		</c:forEach>
</jsp:attribute>

</tpl:layout>