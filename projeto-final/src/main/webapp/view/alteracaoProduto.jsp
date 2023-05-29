<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alteração de Produto</title>
<link rel="stylesheet" href="css/style-alterarProduto.css"
	type="text/css">
</head>
<body>
	<div class="container">
		<h1>Alteração de Produto</h1>

		<form class="form" action="../Produto/Alterar" method="POST">
			<div>
				<label>Cod: </label> <input class="txt-campo" type="text" name="cod"
					value="<%=request.getParameter("cod") != null ? request.getParameter("cod") : ""%>" required>
			</div>

			<div>
				<label>Nome: </label> <input class="txt-campo" type="text"
					name="nome"
					value="<%=request.getParameter("nome") != null ? request.getParameter("nome") : ""%>" required>
			</div>

			<div>
				<label>Marca: </label> <input class="txt-campo" type="text"
					name="marca"
					value="<%=request.getParameter("marca") != null ? request.getParameter("marca") : ""%>" required>
			</div>

			<div>
				<label>Descrição: </label> <input class="txt-campo" type="text"
					name="descricao"
					value="<%=request.getParameter("descricao") != null ? request.getParameter("descricao") : ""%>" required>
			</div>

			<div>
				<label>Lote: </label> <input class="txt-campo" type="text"
					name="lote"
					value="<%=request.getParameter("lote") != null ? request.getParameter("lote") : ""%>" required>
			</div>

			<div>
				<label>Preço: </label> <input class="txt-campo" type="text"
					name="preco"
					value="<%=request.getParameter("preco") != null ? request.getParameter("preco") : ""%>"required>
			</div>

			<br>
			<div class="botoes">
				<button id="btn-alterar" type="submit">Alterar</button>
			</div>

		</form>

		<h3>
			<a href='../view/home.jsp'>Principal</a>
		</h3>
	</div>
</body>
</html>