<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tpl:layout title="Your Cart">
	<jsp:attribute name="content">
<a href="${pageContext.request.contextPath}/home.html">Tiếp Tục Mua
		Hàng</a>
		
	<table class="table table-bordered">
		<c:forEach var="o" items="${list}">
			<tr data-id="${o.productId}">
				<td>${o.title}</td>
				<td><input type="number" class="qty" value="${o.quantity}"></td>
				<td>${o.price}</td>
				<td><img width="150px"
						src="${pageContext.request.contextPath}/upload/${o.imageUrl}"></td>
			</tr>
		</c:forEach>
	</table>
	<p class="center">
		<a href="${pageContext.request.contextPath}/cart/checkout.html"
				class="btn btn-primary">Check Out</a>
	</p>
	<script type="text/javascript">
		var qties = document.getElementsByClassName('qty');
		for (var i = qties.length - 1; i >= 0; i--) {
			qties[i].onchange = function() {
				var qty = this.value;
				var id = this.parentNode.parentNode.getAttribute('data-id');
				//AJAX SEND
				var xhr = new XMLHttpRequest();

				xhr.open('POST',
						'${pageContext.request.contextPath}/cart/edit.html');
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				var data='id=' + id +'&qty='+qty;
				xhr.send(data);
				xhr.onload = function() {
					if(xhr.response!='1'){
						alert ("Error");
					}
					//alert(xhr.response)
				}
			}
		}
	</script>

</jsp:attribute>

</tpl:layout>
