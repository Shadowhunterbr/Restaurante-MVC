<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
<title>Cadastro de produtos</title>
</head>
<body>

	Seja bem-vindo(a) ${funcionarioAutenticado.nome}
	<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair do sistema</button></a>

<h1>Cadastro de produtos</h1>

	<form method="post" action="chamadaservlet">
		Nome Produto: <input type="text" name="txtnomeproduto" size="80" autocomplete="off" required><br><br>
		custo: <input type="text" name="txtprecocusto" size="5" autocomplete="off" required>
		valor: <input type="text" name="txtprecovenda" size="5" autocomplete="off" required>
		Porcentagem de venda: <input type="text" name="txtprobabilidade" size="5" autocomplete="off" required>
<br><br>
		
		<input type="hidden" name="acao" value="cadastraproduto">
		<input type="submit" value="Cadastrar Produto">	
	</form>

</body>
</html>