package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDao {

	public void cadastra(Produto produto) {

		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO produtos(nome_produto,custo_produto,preco_produto,porcentagem_compra) VALUES(?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNomeProduto());
			preparador.setDouble(2, produto.getPrecoCusto());
			preparador.setDouble(3, produto.getPrecoVenda());
			preparador.setDouble(4, produto.getProbabilidadeVenda());

			preparador.execute();

			preparador.close();

			System.out.println("PRODUTO CADASTRADO COM SUCESSO!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Produto> mostraTodos() {

		Connection con = Conexao.obterConexao();
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Produto produto = new Produto();
				produto.setIdProduto(resultado.getInt("id_produto"));
				produto.setNomeProduto(resultado.getString("nome_produto"));
				produto.setPrecoCusto(resultado.getDouble("custo_produto"));
				produto.setPrecoVenda(resultado.getDouble("preco_produto"));
				produto.setProbabilidadeVenda(resultado.getDouble("porcentagem_compra"));
				produto.setQuantidadeVendida(resultado.getInt("quantidade_vendida"));
				produto.setProdutoTotalVendido(resultado.getDouble("produto_total_vendido"));

				produtos.add(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public List<Funcionario> mostraTodosFuncionarios() {
		Connection con = Conexao.obterConexao();
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM funcionarios";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultado.getInt("id_funcionario"));
				funcionario.setNome(resultado.getString("nome_funcionario"));
				funcionario.setCargoFuncionario(resultado.getString("cargo_funcionario"));
				funcionario.setSalario(resultado.getDouble("salario_funcionario"));

				funcionarios.add(funcionario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;

	}

////////// teste

	public Restaurante mostraTotalVendas() {
		Connection con = Conexao.obterConexao();
		Restaurante restaurante = null;
		String sql = "SELECT SUM((preco_produto * quantidade_vendida)) AS total_venda_bruta FROM produtos;";
		String sql2 = "UPDATE vendas SET total_venda_bruta=? WHERE id_venda=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.isPoolable();

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				restaurante = new Restaurante();
				restaurante.setTotalVendas(resultado.getDouble("total_venda_bruta"));

				PreparedStatement preparador2 = con.prepareStatement(sql2);
				preparador2.setDouble(1, restaurante.getTotalVendas());
				preparador2.setInt(2, 1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurante;

	}

//////
	public Produto mostraPorId(int idProduto) {

		Connection con = Conexao.obterConexao();
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id_produto=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idProduto);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				produto = new Produto();
				produto.setIdProduto(resultado.getInt("id_produto"));
				produto.setNomeProduto(resultado.getString("nome_produto"));
				produto.setPrecoCusto(resultado.getDouble("custo_produto"));
				produto.setPrecoVenda(resultado.getDouble("preco_produto"));
				produto.setProbabilidadeVenda(resultado.getDouble("porcentagem_compra"));
				produto.setQuantidadeVendida(resultado.getInt("quantidade_vendida"));
				produto.setProdutoTotalVendido(resultado.getDouble("produto_total_vendido"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}

	public void alteraProduto(Produto produto) {
		Connection con = Conexao.obterConexao();
		String sql = ("UPDATE produtos SET nome_produto=?,preco_produto=?,custo_produto=?,porcentagem_compra=? WHERE id_produto=?");

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNomeProduto());
			preparador.setDouble(2, produto.getPrecoVenda());
			preparador.setDouble(3, produto.getPrecoCusto());
			preparador.setDouble(4, produto.getProbabilidadeVenda());
			preparador.setInt(5, produto.getIdProduto());

			preparador.execute();
			preparador.close();

			System.out.println("Produto Atualizado");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarVenda(Produto produto, Restaurante restaurante) {
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE produtos SET quantidade_vendida=?, produto_total_vendido=? WHERE nome_produto=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, produto.getQuantidadeVendida());
			preparador.setDouble(2, produto.getProdutoTotalVendido());
			preparador.setString(3, produto.getNomeProduto());

			preparador.executeUpdate();
			preparador.close();

			System.out.println("Produto Atualizado");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirProduto(int idProduto) {

		Connection con = Conexao.obterConexao();

		String sql = "DELETE FROM produtos WHERE id_produto=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idProduto);

			preparador.execute();
			preparador.close();

			System.out.println("Produto Excluído Com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cadastraFuncionario(Funcionario funcionario) {
		Connection con = Conexao.obterConexao();
		String sql = "INSERT INTO funcionarios (nome_funcionario,cargo_funcionario,salario_funcionario) VALUES(?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, funcionario.getNome());
			preparador.setString(2, funcionario.getCargoFuncionario());
			preparador.setDouble(3, funcionario.getSalario());

			preparador.execute();

			preparador.close();

			System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Funcionario mostraFuncionarioPorId(int idFuncionario) {

		Connection con = Conexao.obterConexao();
		Funcionario funcionario = null;
		String sql = "SELECT * FROM funcionarios WHERE id_funcionario=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idFuncionario);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultado.getInt("id_funcionario"));
				funcionario.setNome(resultado.getString("nome_funcionario"));
				funcionario.setCargoFuncionario(resultado.getString("cargo_funcionario"));
				funcionario.setSalario(resultado.getDouble("salario_funcionario"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;
	}

	public void excluirFuncionario(int idFuncionario) {

		Connection con = Conexao.obterConexao();

		String sql = "DELETE FROM funcionarios WHERE id_funcionario=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idFuncionario);

			preparador.execute();
			preparador.close();

			System.out.println("Funcionario Excluído Com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alteraFuncionario(Funcionario funcionario) {

		Connection con = Conexao.obterConexao();
		String sql = ("UPDATE funcionarios SET nome_funcionario=?, cargo_funcionario=?, salario_funcionario=?  WHERE id_funcionario=?");

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, funcionario.getNome());
			preparador.setString(2, funcionario.getCargoFuncionario());
			preparador.setDouble(3, funcionario.getSalario());
			preparador.setInt(4, funcionario.getIdFuncionario());

			preparador.execute();
			preparador.close();

			System.out.println("Funcionario Alterado Com Sucesso!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Funcionario autentica(String login, String senha) {

		Connection con = Conexao.obterConexao();
		Funcionario funcionario = null;
		String sql = "SELECT * FROM funcionarios WHERE login=? and senha=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, senha);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultado.getInt("id_funcionario"));
				funcionario.setNome(resultado.getString("nome_funcionario"));
				funcionario.setCargoFuncionario(resultado.getString("cargo_funcionario"));
				funcionario.setSalario(resultado.getDouble("salario_funcionario"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;

	}

}
