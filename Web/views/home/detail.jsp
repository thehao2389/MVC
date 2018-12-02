<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<tpl:layout title="${o.title}">
	<jsp:attribute name="content">
	<jsp:include page="/views/home/formsearch.jsp" />
		<div class="col-4">
			<img src="/MVC/upload/${o.imageUrl}">
		</div>
		<div class="col-8">
			<h2>${o.title}</h2>
			<p>
				<b>Price:</b> <span>${o.price}</span>
			</p>
			<p>
				<b>Description:</b><span>${o.description}</span>
			</p>
			<form method="post" action="/MVC/cart.html">
				<input type="hidden" value="${o.id}" name="id"> <input
					type="number" name="quantity" value="1">
				<button class="btn btn-primary">Add to Cart</button>
			</form>
		</div>
	</jsp:attribute>
</tpl:layout>