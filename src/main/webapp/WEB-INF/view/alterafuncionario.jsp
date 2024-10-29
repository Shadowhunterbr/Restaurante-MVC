<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
<title>Alteração Dados Funcionarios</title>
</head>
<body>
	
	Seja bem-vindo(a) ${funcionarioAutenticado.nome}
	<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair do sistema</button></a>
	<!--  -->
	<br><br>
	<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=mostratodosfuncionarios"><button>todos Funcionarios</button></a>
	<br>
	<h1>Alteração dados Funcionarios</h1>
	
	
	<form method="post" action="chamadaservlet">
		Id: <input type="text" name="txtidfuncionario" size="5" value="${funcionario.idFuncionario }" readonly>
		Nome Funcionario: <input type="text" name="txtnomefuncionario" size="35" value="${funcionario.nome} " autocomplete="off" required><br><br>
		Cargo: <input type="text" name="txtcargo" value="${funcionario.cargoFuncionario}" size="20" autocomplete="off" required>
		Salario: <input type="text" name="txtsalario" value="${funcionario.salario}" size="5" autocomplete="off" required>

<br><br>
		
		
		<input type="hidden" name="acao" value="alterafuncionario">
		<input type="submit" value="Alterar Dados Funcionario">	
	</form>

</body>
</html>

