<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<%
		String html = (String)request.getAttribute("html");
		out.print(html);
	%>	
</body>
</html>