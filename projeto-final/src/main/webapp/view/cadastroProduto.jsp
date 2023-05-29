<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produto</title>
<link href="css/style-cadastroProduto.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
	<h1>Cadastro de Produto</h1>
	<form class="form" action="../Produto/Cadastrar" method="post">
	<div>
		<label>Nome:</label>
		<input class="txt-campo" type="text" name="nome" required>
	</div>
	<div>
		<label>Marca:</label>
		<input class="txt-campo" type="text" name="marca" required>	
	</div>
	<div>
		<label>Descricao:</label>
		<input class="txt-campo" type="text" name="descricao" required>	
	</div>	
	<div>
		<label>Lote:</label>
		<input class="txt-campo" type="text" name="lote" required>	
	</div>
	<div>
		<label>Preço:</label>
		<input class="txt-campo" type="text" name="preco" required>	
	</div>
	<br><br><br>
	<div>
		<input id="btn-enviar" class="botoes" type="submit" value="Enviar">
	</div>
		
		
	</form>
	
	<h3><a href="../view/home.jsp">Página inicial</a></h3>
	</div>
</body>
</html>