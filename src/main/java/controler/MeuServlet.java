package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.Funcionario;
import main.Produto;
import main.Restaurante;
import main.RestauranteDao;
import testes.TesteMostraTotalVendas;

@WebServlet("/chamadaservlet")
public class MeuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao") == null ? "login" : request.getParameter("acao");

		HttpSession sessao = request.getSession();

		boolean funcionarioAutenticado = sessao.getAttribute("funcionarioAutenticado") == null;
		boolean paginaProtegida = !(acao.equals("login"));

		if (funcionarioAutenticado && paginaProtegida) {
			response.sendRedirect("http://localhost:8080/restauranteWeb2");
			return;
		}

// boolean paginaNaoProtegida = acao.equals("login"); o inverso
// boolean alunoAutenticado =  sessao.getAttribute("alunoAutenticado") !=null; o inverso
// verifica se o aluno esta autenticado
// if(request.getParameter("acao")==null) {
// acao = "login";
// }else {
// acao = request.getParameter("acao");
// }
//
		if (acao.equals("login")) {
			response.sendRedirect("http://localhost:8080/restauranteWeb2");
		} else if (acao.equals("cadastraproduto")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastraproduto.jsp");
			rd.forward(request, response);
		} else if (acao.equals("cadastrafuncionario")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastrafuncionario.jsp");
			rd.forward(request, response);

		} else if (acao.equals("principal")) {

			RestauranteDao restauranteDao = new RestauranteDao();
			List<Produto> produtos = restauranteDao.mostraTodos();
			Restaurante restaurante = restauranteDao.mostraTotalVendas();

			if (restaurante != null) {
				// Passa o total de vendas como atributo
				request.setAttribute("totalVendas", restaurante.getTotalVendas());
				System.out.println("Total de vendas no Servlet: " + restaurante.getTotalVendas());
			} else {
				request.setAttribute("mensagemErro", "Vendas não encontradas!");
			}

			request.setAttribute("produtos", produtos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/principal.jsp");
			rd.forward(request, response);

		} else if (acao.equals("mostratodosfuncionarios")) {

			RestauranteDao restauranteDao = new RestauranteDao();
			List<Funcionario> funcionarios = restauranteDao.mostraTodosFuncionarios();

			request.setAttribute("funcionarios", funcionarios);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodosfuncionarios.jsp");
			rd.forward(request, response);
		} else if (acao.equals("exclui")) {

			int idProduto = Integer.valueOf(request.getParameter("idProduto"));// atenção aqui

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.excluirProduto(idProduto);

			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");

		} else if (acao.equals("alteraproduto")) {

			int idProduto = Integer.valueOf(request.getParameter("idProduto"));

			RestauranteDao restauranteDao = new RestauranteDao();
			Produto produto = restauranteDao.mostraPorId(idProduto);

			request.setAttribute("produto", produto);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alteraproduto.jsp");
			rd.forward(request, response);

		} else if (acao.equals("logout")) {
			sessao.invalidate();
			response.sendRedirect("http://localhost:8080/restauranteWeb2");

		} else if (acao.equals("excluifuncionario")) {

			int idFuncionario = Integer.valueOf(request.getParameter("idFuncionario"));// atenção aqui

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.excluirFuncionario(idFuncionario);

			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");

		} else if (acao.equals("alterafuncionario")) {

			int idFuncionario = Integer.valueOf(request.getParameter("idFuncionario"));

			RestauranteDao restauranteDao = new RestauranteDao();
			Funcionario funcionario = restauranteDao.mostraFuncionarioPorId(idFuncionario);

			request.setAttribute("funcionario", funcionario);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alterafuncionario.jsp");
			rd.forward(request, response);

		} else if (acao.equals("logout")) {
			sessao.invalidate();
			response.sendRedirect("http://localhost:8080/restauranteWeb2");

		} else if (acao.equals("simularvendas")) {
			Restaurante restaurante = new Restaurante();
			restaurante.simula1();
			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("login")) {

			String login = request.getParameter("txtlogin");
			String senha = request.getParameter("txtsenha");

			RestauranteDao restauranteDao = new RestauranteDao();
			Funcionario funcionario = restauranteDao.autentica(login, senha);

			if (funcionario != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("funcionarioAutenticado", funcionario);
				response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");
			} else {
				response.sendRedirect("http://localhost:8080/restauranteWeb2");
			}

		} else if (acao.equals("cadastraproduto")) {
			String nomeProduto = request.getParameter("txtnomeproduto");// atenção aqui
			double precoVenda = Double.valueOf(request.getParameter("txtprecovenda"));
			double precoCusto = Double.valueOf(request.getParameter("txtprecocusto"));
			double probabilidadeVenda = Double.valueOf(request.getParameter("txtprobabilidade"));

			Produto produto = new Produto(nomeProduto, precoVenda, precoCusto, probabilidadeVenda, 0);

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.cadastra(produto);

			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");

		} else if (acao.equals("cadastrafuncionario")) {
			String nome = request.getParameter("txtnomefuncionario");// atenção aqui
			String cargo = request.getParameter("txtcargo");
			double salario = Double.valueOf(request.getParameter("txtsalario"));

			Funcionario funcionario = new Funcionario(nome, cargo, salario);

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.cadastraFuncionario(funcionario);

			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");

		} else if (acao.equals("alteraproduto")) {
			int idProduto = Integer.valueOf(request.getParameter("txtidproduto"));
			String nomeProduto = request.getParameter("txtnomeproduto");
			double precoVenda = Double.valueOf(request.getParameter("txtprecovenda"));
			double precoCusto = Double.valueOf(request.getParameter("txtprecocusto"));
			double probabilidadeVenda = Double.valueOf(request.getParameter("txtprobabilidade"));

			Produto produto = new Produto(idProduto, nomeProduto, precoVenda, precoCusto, probabilidadeVenda, 0);

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.alteraProduto(produto);
			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");
		} else if (acao.equals("alterafuncionario")) {
			int idFuncionario = Integer.valueOf(request.getParameter("txtidfuncionario"));
			String nome = request.getParameter("txtnomefuncionario");
			String cargo = request.getParameter("txtcargo");
			double salario = Double.valueOf(request.getParameter("txtsalario"));

			Funcionario funcionario = new Funcionario(idFuncionario, nome, cargo, salario);

			RestauranteDao restauranteDao = new RestauranteDao();
			restauranteDao.alteraFuncionario(funcionario);
			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=mostratodosfuncionarios");
		} else if (acao.equals("simularvendas")) {
			Restaurante restaurante = new Restaurante();
			restaurante.simula1();
			response.sendRedirect("http://localhost:8080/restauranteWeb2/chamadaservlet?acao=principal");
		}

	}

}
