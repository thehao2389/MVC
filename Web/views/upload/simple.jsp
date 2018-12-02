<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<tpl:layout title="Upload Simple">
	<jsp:attribute name="content">
<form method="post" class="form" enctype="multipart/form-data">
		<p>
			<label>Choose Image</label> <input type="file" name="f">
		</p>
		<p>
			<button class="btn btn-primary">Upload</button>
		</p>
	</form>
	<img width="100"
			src="${pageContext.request.contextPath}/upload/${url}">
</jsp:attribute>
	
</tpl:layout>