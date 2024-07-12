<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${success}</h1>
<h1>${already}</h1>
<h1>${mess}</h1>
	<div align="center">
		<form action="login1" method="post">
			<h1>
				<input type="text" required="required" name="userName" placeholder="Enter Your UserName">
				<br><br>
				<input type="password" name="password" required="required"
					placeholder="Enter Your Password">
					<br><br>
				<button type="submit">Login</button>
				<a href="regsiter">Register</a>
			</h1>
		</form>
	</div>
	
</body>
</html>