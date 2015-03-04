<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
		<%
			String  coll = request.getParameter("collection");
			String _id = request.getParameter("_id");
		%>
		<form action=LoginForm method="post">
			<table border=0>
				<tr>
					<th colspan="2">Login Form</th>
				</tr>
				<tr>
					<td>Enter your UserId:</td>
					<td><input type=text name=userid></td>
				</tr>
				<tr>
					<td>Enter your Password:</td>
					<td><input type=password name=password></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=hidden name=collection value='<%=coll%>'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=hidden name=_id value='<%=_id%>'></td>
				</tr>
				<img src=hsep.png width=500px height=500px/>
				<tr>
					<td><input type=submit value=submit></td>
					<td><input type=reset value=refresh></td>
				</tr>
				<tr>
					<td>New User</td>
					<td><a href = /buy123/RegistrationForm.jsp?collection=<%=coll%>&_id=<%=_id%>>Sign Up</a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>