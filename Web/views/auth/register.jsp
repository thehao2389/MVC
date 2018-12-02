<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/MVC/css/css.css">
</head>
<body>
	<div class="container">
		<form method="post" class="form">
			<p>
				<label>Username</label> <input type="text" name="usr">
			</p>

			<p>
				<label>Password</label> <input type="password" name="pwd">
			</p>
			<p>
				<label>FullName</label> <input type="text" name="fullName">
			</p>
			<p>
				<label>Email</label> <input type="email" name="email">
			</p>
			<p>
				<label>Gender</label> <select name="gender">
					<option value="0">Male</option>
					<option value="1">Female</option>
					<option value="2">Undefined</option>
				</select>
			</p>
			<p>
				<button class="btn btn-primary">Register</button>
			</p>
		</form>
	</div>
</body>
</html>