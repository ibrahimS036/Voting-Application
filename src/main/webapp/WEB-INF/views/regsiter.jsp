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
		<form action="register" method="post">
			<h1>
				<input type="text" required="required" name="userName"
					placeholder="Enter Your UserName"> <br> <br> <input
					type="password" name="password" required="required"
					placeholder="Enter Your Password"> <br> <br> <input
					type="email" name="email" placeholder="Enter Your Email"
					required="required"> <br>
				<br> <input type="number" name="phoneNumber"
					required="required" placeholder="Enter Your Phone Number">
					<br><br>
				<button type="submit">register</button>
				<a href="login">login</a>
			</h1>
		</form>
	</div>
</body>
</html>