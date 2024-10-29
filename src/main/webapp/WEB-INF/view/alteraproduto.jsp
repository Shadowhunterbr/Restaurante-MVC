<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
<title>Alteração Dados Produtos</title>
</head>
<body>
	
	Seja bem-vindo(a) ${funcionarioAutenticado.nome}
	<a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair do sistema</button></a>
	<!--  -->
	<h1>Alteração dados produtos</h1>
	

	<form method="post" action="chamadaservlet">
		Id: <input type="text" name="txtidproduto" size="5" value="${produto.idProduto }" readonly>
		Nome produto: <input type="text" name="txtnomeproduto" size="65" value="${produto.nomeProduto} " autocomplete="off" required><br><br>
		custo: <input type="text" name="txtprecocusto" value="${produto.precoCusto}" size="5" autocomplete="off" required>
		valor: <input type="text" name="txtprecovenda" value="${produto.precoVenda}" size="5" autocomplete="off" required>
		Probabilidade de venda: <input type="text" name="txtprobabilidade" value="${produto.probabilidadeVenda}" size="5" autocomplete="off" required>
<br><br>
		
		Quantidade Vendida: <input type="text" name="txtquantidadevendida" value="${produto.quantidadeVendida}" size="5" readonly>
		Total vendido: <input type="text" name="txtprodutototalvendido" value="${produto.produtoTotalVendido}" size="30" readonly><br><br>
		
		<input type="hidden" name="acao" value="alteraproduto">
		<input type="submit" value="Alterar Dados Produto">	
	</form>

</body>
</html>

