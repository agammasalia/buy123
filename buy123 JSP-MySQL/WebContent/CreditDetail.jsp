<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit Card</title>
</head>
<body>
	<center>
		<form action=CreditDetail method="post">
			<table border=0>
				<tr>
					<th colspan="2">Enter Credit Detail</th>
				</tr>
				<tr>
					<td>Name on Card:</td>
					<td><input type=text name=name></td>
				</tr>
				<tr>
					<td>Card Number:</td>
					<td><input type=text name=card></td>
				</tr>
				<tr>
					<td>Security Number:</td>
					<td><input type=text name=security></td>
				</tr>
				<tr>
					<td>Expiration Date:</td>
					<td><input type=text name=expiration></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=submit value=submit><input type=reset value=reset></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>