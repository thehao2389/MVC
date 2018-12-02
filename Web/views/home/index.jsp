<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="frm" uri="form"%>
<tpl:layout title="Homepage Mini Shop">
	<jsp:attribute name="content">
	<p>Số trang:${total}</p>
					<p>Phân trang:${n}</p>
	
					<jsp:include page="/views/home/formsearch.jsp" />
<frm:pagination url="/MVC/home.html" n="${n}" />

					<jsp:include page="/views/home/products.jsp"/>
				
	</jsp:attribute>
</tpl:layout>
