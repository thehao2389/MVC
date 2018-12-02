<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="tpl" uri="/WEB-INF/tpl"%>
<%@taglib prefix="frm" uri="form"%>
<tpl:layout title="Add New Product">
	<jsp:attribute name="content">
	<jsp:include page="/views/home/formsearch.jsp" />
		<form class="form" method="post" enctype="multipart/form-data">
			<p>
			<label>Category</label>
			<frm:select name="categoryId" list="${categories}" />
			</p>
			<p>
			<label>Publisher</label>
			<frm:select name="publisherId" list="${publishers}" />
			</p>
			<p>
			<label>Author</label>
			<frm:select name="authorId" list="${authors}" />
			</p>
			<p>
			<label>ISBN</label>
			<input type="number" name="isbn">
			</p>
			<p>
			<label>Title</label>
			<input type="text" name="title">
			</p>
			<p>
			<label>Pages</label>
			<input type="number" name="pages">
			</p>
			<p>
			<label>Year</label>
			<input type="number" name="year">
			</p>
			<p>
			<label>Weight</label>
			<input type="text" name="weight">
			</p>
			<p>
			<label>Size</label>
			<input type="text" name="size">
			</p>
			<p>
			<label>Content</label>
			<textarea name="content"></textarea>
			</p>
			<p>
			<label>Description</label>
			<textarea name="description"></textarea>
			</p>
			<p>
			<label>Image</label>
			<input type="file" name="f">
			</p>
			<p>
			<label>Price</label>
			<input type="number" name="price">
			</p>
			<p>
		<button class="btn btn-primary">Save</button>
			</p>
		</form>
		<p class="error">${msg}</p>
	</jsp:attribute>
</tpl:layout>