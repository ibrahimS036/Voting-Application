<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>${add}</h1>
		<form action="admincheck" method="post">
			<h1>
				<input type="text" required="required" name="userName" placeholder="Enter Your UserName">
				<br>
				<input type="password" name="password" required="required"
					placeholder="Enter Your Password">
					<br>
				<button type="submit">Login</button>
				<a href="/">home</a>
			</h1>
		</form>
	</div>
</body>
</html>