<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="margin-top:30px;">
		<form action="vote" method="post">
	<h1>
			<label>Candidate 1</label> <input type="radio" name="candidates"
				value="Candidate 1"><br><br> <label>Candidate 2</label> <input
				type="radio" name="candidates" value="Candidate 2"> <br><br><label>Candidate 3
				</label> <input type="radio" name="candidates" value="Candidate 3"><br><br> <label>Candidate 4
				</label><input type="radio" name="candidates" value="Candidate 4"><br><br>
				<button type="submit">Vote</button>
				<a href="logout">logout</a>
		</h1>
		</form>
	</div>
</body>
</html>