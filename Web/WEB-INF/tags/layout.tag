<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="content" required="true" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand">Mini Shop</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">

				<frm:menu list="${categories}" />
				<%-- <ul>
					<c:forEach var="o" items="${categories}">
						<c:if test="${o.parentId==0}">
							<li>${o.name}
								<ul>
									<c:forEach var="c" items="${categories}">
										<c:if test="${c.parentId==o.id}">
											<li>${c.name}</li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:if>

					</c:forEach>
				</ul> --%>

			</div>
			<div class="col-9">
				<jsp:invoke fragment="content" />
			</div>
		</div>
	</div>
</body>
</html>
