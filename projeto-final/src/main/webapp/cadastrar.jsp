<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar</title>
<link href="view/css/style-cadastrar.css" rel="stylesheet"
	type="text/css">
</head>
<body>

	<div class="container">
		<div><h1>Cadastre e acesse.</h1></div>

		<div>
			<form class="form" action="Cadastrar" method="post">
		
				<div class="txt-campo">
					<input type="text" name="email" placeholder="E-mail" required>
				</div>

				<div class="txt-campo">
					<input type="text" name="usuario" placeholder="Usuário" required>
				</div>

				<div class="txt-campo">
					<input type="password" name="senha" placeholder="Senha" required>
				</div>

				<div class="botoes">
					<input id="btn-enviar" type="submit" value="Enviar"> 
					<a href="index.jsp"><input id="btn-fazer-login" type="button" value="Fazer Login"></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>