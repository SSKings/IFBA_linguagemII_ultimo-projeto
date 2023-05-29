<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exclusão de Produto</title>
<link rel="stylesheet" href="css/style-exclusaoProduto.css" type="text/css">
</head>
<body>
	<div class="container">

		<h1>Exclusão de Produto</h1>

		<form class="form" action="../Produto/Excluir" method="POST">
			<div>
				<input class="txt.campo" type="text" name="cod"
					value="<%=request.getParameter("cod") != null ? request.getParameter("cod") : ""%>" 
					placeholder="Digite o ID do produto" required>
			</div>
			<div class="botoes">
				<button id="btn-excluir" type="submit">Excluir</button>
			</div>
		</form>

		<h3>
			<a href='home.jsp'>Página Principal</a>
		</h3>
	</div>
</body>
</html>