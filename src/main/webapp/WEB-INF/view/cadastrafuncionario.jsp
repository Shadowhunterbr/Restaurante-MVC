<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
<title> Cadastro de funcionario</title>
</head>
<body>

	Seja bem-vindo(a) ${funcionarioAutenticado.nome}
	
	<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair do sistema</button></a>
<br><br>
<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=mostratodosfuncionarios"><button>todos Funcionarios</button></a>
	<br>

<h1>Cadastro de funcionarios</h1>


	<form method="post" action="chamadaservlet">
		Nome funcionario: <input type="text" name="txtnomefuncionario" size="50" autocomplete="off" required><br><br>
		cargo: <input type="text" name="txtcargo" size="20" autocomplete="off" required>
		salario: <input type="text" name="txtsalario" size="5" autocomplete="off" required>
<br><br>
		
		<input type="hidden" name="acao" value="cadastrafuncionario">
		<input type="submit" value="Cadastrar funcionario">	
	</form>

</body>
</html>