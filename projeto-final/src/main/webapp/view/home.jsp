<%@page import="model.dto.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
<link rel="stylesheet" href="css/style-home.css" type="text/css">
</head>
<body>
	<%
		if (session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("../index.jsp");
		} else {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			out.println("<h2>Seja Bem Vindo " + usuario.getUsuario() + "</h2><br>");
		}
	%>
	<div class="container">
		<div>
			<h1>Principal - CRUD JSP(Servlet) MVC</h1>
		</div>
		<div>
			<h2><a href="cadastroProduto.jsp">Cadastro de Produto </a></h2>
		</div>
		<div>
			<h2><a href="../Produto/Listar">Listagem de Produtos</a></h2>
		</div>
		<div>
			<h2><a href="exclusaoProduto.jsp">Exclusão de Produto</a></h2>
		</div>
		<div>
			<h2><a href="alteracaoProduto.jsp">Alteração de Produto</a></h2>
		</div>
		<div>
			<h2><a href="pesquisaProduto.jsp">Pesquisa de Produto</a></h2>
		</div>

		<h2>
			<a href="../Logout">Sair</a>
		</h2>
	</div>

</body>
</html>