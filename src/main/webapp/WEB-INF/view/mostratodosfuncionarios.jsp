
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="style.css">
<title>Todos funcionarios</title>

</head>
<body>

    Seja bem-vindo(a) ${funcionarioAutenticado.nome}
    
    <a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=logout"><button>sair do sistema</button></a>
    
    <h1>Mostra Todos os funcionarios</h1>
    
    <a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal"><button>Produtos</button></a>
    <br><br>
    <a href="http://localhost:8080/restauranteWeb2/chamadaservlet?acao=cadastrafuncionario"><button>Cadastrar Funcionario</button></a>
    <br><br>
    
    <c:if test="${not empty funcionarios}">
        <table border="1" style="width: 90%">
            <thead>
                <tr style="background-color: black;color:white">
                    <th>Id </th>
                    <th>Nome Funcionario</th>
                    <th>cargo</th>
                    <th>Salario</th>
                    <th>alterar</th>
                    <th colspan="2">excluir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="funcionario" items="${funcionarios}">
                    <tr>
                        <td>${funcionario.idFuncionario}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.cargoFuncionario}</td>
                        <td>R$ ${funcionario.salario}</td>
                        <td><a href="chamadaservlet?acao=alterafuncionario&idFuncionario=${funcionario.idFuncionario}">Alterar</a></td>
                        <td><a href="chamadaservlet?acao=excluifuncionario&idFuncionario=${funcionario.idFuncionario}">Excluir</a></td>
                    </tr>
                </c:forEach>        
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty funcionarios}">
        <h2>Nenhum funcionario Cadastrado no Sistema!!!!</h2>
    </c:if>
    
</body>
</html>