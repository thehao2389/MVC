<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tpl:layout title="${o.name}">

	<jsp:attribute name="content">
		<div class="page-header">
		${o.name}
		</div>
		<jsp:include page="/views/home/products.jsp"/>
	</jsp:attribute>
</tpl:layout>