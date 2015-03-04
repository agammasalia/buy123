<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%
		String  coll = request.getParameter("collection");
		String _id = request.getParameter("_id");
	%>
	<center>
		<form action=RegistrationForm method="post">
			<table border=0>
				<tr>
					<th colspan="2">Registration Form</th>
				</tr>
				<tr>
					<td>Enter First Name</td>
					<td><input type=text name=firstname></td>
				</tr>
				<tr>
					<td>Enter Last Name</td>
					<td><input type=text name=lastname></td>
				</tr>
				<tr>
					<td>Enter User ID</td>
					<td><input type=text name=userid></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type=password name=password></td>
				</tr>
				<tr>
					<td>Enter E-Mail</td>
					<td><input type=text name=email></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=hidden name=collection value='<%=coll%>'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=hidden name=_id value='<%=_id%>'></td>
				</tr>
				<tr>
					<td><input type=submit value=Register></td>
					<td><input type=reset value=Reset></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>