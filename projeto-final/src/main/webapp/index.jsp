<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela de Login</title>
<link href="view/css/style-index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div>
			<h1>Faça Login</h1>
		</div>

		<div>
			<form class="form" action="Login" method="post">
				<div class="txt-campo">
					<input type="text" name="usuario" placeholder="Usuario/Email" required>
				</div>
				
				<div class="txt-campo">
					<input type="password" name="senha" placeholder="Senha" required>
				</div>

				<div class="botoes">
					<input id="btn-login" type="submit" value="Log in"> 
					<a href="cadastrar.jsp"><input id="btn-cadastrar" type="button" value="Cadastrar"></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>