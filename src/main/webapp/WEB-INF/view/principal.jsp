<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="style.css">

<title>Menu Principal</title>
</head>
<body>

	Seja bem-vindo(a) ${funcionarioAutenticado.nome}

	<a
		href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair
			do sistema</button></a>

	<h1>Mostra Todos os Alunos</h1>

	<a
		href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=cadastraproduto"><button>Cadastrar
			produtos</button></a>
	<br>
	<br>
	<a
		href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=cadastrafuncionario"><button>Cadastrar
			Funcionario</button></a>
	<a
		href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=mostratodosfuncionarios"><button>todos
			Funcionarios</button></a>

	<br>
	<br>
	<a href="chamadaservlet?acao=simularvendas"><button type="submit"
			id="button2">Simular venda</button></a>
	<br>
	<br>
	<%
	String mensagem = (String) request.getAttribute("mensagemErro");
	if (mensagem != null) {
	%>
	<p><%=mensagem%></p>
	<%
	} else {
	Double totalVendas = (Double) request.getAttribute("totalVendas");
	if (totalVendas != null) {
	%>
	<p>
		Total de Vendas:
		<%=totalVendas%></p>
	<%
	}
	}
	%>
	<table border="1" style="width: 20%">
		<thead>
			<tr style="background-color: black; color: white">
				<th>Total Vendas</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>R$ ${totalVendas}</td>

			</tr>
		</tbody>
	</table>

	<br>
	<br>
	<c:if test="${not empty produtos}">
		<table border="1" style="width: 90%">
			<thead>
				<tr style="background-color: black; color: white">
					<th>Id</th>
					<th>Nome produto</th>
					<th>custo</th>
					<th>valor</th>
					<th>Probabilidade de venda</th>
					<th>quantidade vendida</th>
					<th>valor vendido</th>
					<th>alterar produto</th>
					<th colspan="2">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produto" items="${produtos}">
					<tr>
						<td>${produto.idProduto}</td>
						<td>${produto.nomeProduto}</td>
						<td>R$ ${produto.precoCusto}</td>
						<td>R$ ${produto.precoVenda}</td>
						<td>${produto.probabilidadeVenda}</td>
						<td>${produto.quantidadeVendida}</td>
						<td>R$ ${produto.produtoTotalVendido}</td>
						<td><a
							href="chamadaservlet?acao=alteraproduto&idProduto=${produto.idProduto}">Alterar</a></td>
						<td><a
							href="chamadaservlet?acao=exclui&idProduto=${produto.idProduto}">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty produtos}">
		<h2>Nenhum Aluno Cadastrado no Sistema!!!!</h2>
	</c:if>



</body>
</html>








