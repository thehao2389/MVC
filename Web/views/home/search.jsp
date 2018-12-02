<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<tpl:layout title="Search">
	<jsp:attribute name="content">

		<jsp:include page="/views/home/formsearch.jsp" />
			
			<c:forEach var="o" items="${list}">
				<div class="col-3">
					<div class="item">
						<img alt="${o.title}" src="/MVC/upload/${o.imageUrl}">
						<div class="info">${o.title}</div>
						<a href="/MVC/home/detail.html?id=${o.id}">${o.title}</a>
					</div>
				</div>
			</c:forEach>
			</jsp:attribute>
</tpl:layout>
