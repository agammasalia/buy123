<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<center>
		<center>Product Detail</center>
		Welcome <%= session.getAttribute("FirstName") + " " + session.getAttribute("LastName") %>
		<table style="padding-top:20px;">
			<tr><td style="width=100px;">Brand</td><td><%= session.getAttribute("Brand")%></td></tr>
			<tr><td>Model</td><td><%= session.getAttribute("Model")%></td></tr>
			<tr><td>Price</td><td><%= session.getAttribute("Price")%></td></tr>
			<tr><td>Stock</td><td><%= session.getAttribute("Stock")%></td></tr>
		</table>
		<a href="CreditDetail.jsp">Buy Now</a>
	</center>
</body>
</html>