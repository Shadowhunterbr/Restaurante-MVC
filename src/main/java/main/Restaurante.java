package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Restaurante {
    private List<Produto> cardapio;
    private List<Funcionario> funcionarios;
    private double totalVendas;
    private double totalLucro;
    private double totalSalarios;
    private int clientesAtendidos;
    private int produtosVendidos;
//jjj
    public Restaurante() {
        this.cardapio = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.totalVendas = 0;
        this.totalLucro = 0;
        this.totalSalarios = 0;
        this.clientesAtendidos = 0;
        this.produtosVendidos = 0;
    }

    public void adicionarProduto(Produto produto) {
        cardapio.add(produto);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        totalSalarios += funcionario.getSalario();
    }

    public void carregarProdutos() {
        Connection con = Conexao.obterConexao();
        String sql = "SELECT nome_produto, preco_produto, custo_produto, porcentagem_compra, quantidade_vendida, produto_total_vendido FROM produtos";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet rs = preparador.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setPrecoVenda(rs.getDouble("preco_produto"));
                produto.setPrecoCusto(rs.getDouble("custo_produto"));
                produto.setProbabilidadeVenda(rs.getDouble("porcentagem_compra"));
                produto.setQuantidadeVendida(rs.getInt("quantidade_vendida"));
                produto.setProdutoTotalVendido(rs.getDouble("produto_total_vendido"));
                cardapio.add(produto);
            }

            rs.close();
            preparador.close();

            System.out.println("Produtos carregados do banco de dados");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void simularVenda(int itens, boolean fimDeSemana) {
        Random random = new Random();
        Set<Produto> produtosVendidos = new HashSet<>();
        
        for (int i = 0; i < itens; i++) {
            double randomValue = random.nextDouble();
            double cumulativeProbability = 0.0;
            for (Produto produto : cardapio) {
                cumulativeProbability += produto.getProbabilidadeVenda();
                if (randomValue < cumulativeProbability) {
                    totalVendas += produto.getPrecoVenda();
                    totalLucro += produto.getLucro();

                    // Incrementa a quantidade vendida
                    int novoValor = produto.getQuantidadeVendida() + 1;
                    produto.setQuantidadeVendida(novoValor);
                    double novoValor2 = produto.getPrecoVenda() * novoValor;
                    produto.setProdutoTotalVendido(novoValor2);
                    // Adiciona o produto ao conjunto de produtos vendidos
                    produtosVendidos.add(produto);
              
                    

                    break;
                }
            }
        }
        
        // Atualiza a venda no banco de dados após o loop
        for (Produto produto : produtosVendidos) {
            atualizarVenda(produto);
        }
    }
	public void simula1() {
    	
    	 carregarProdutos();
    	
    	for(int dia = 1; dia <= 1; dia++){
    		   if (dia % 7 == 6 || dia % 7 == 0) { // Sábado ou Domingo
    			   simularVenda(aleatorio(100 ,110), true);
               } else {
            	   simularVenda(aleatorio(100, 110), false);
               }
           }
       }

 
    public void simularMes() {
      
        carregarProdutos();
        
        for (int dia = 1; dia <= 30; dia++) {
            if (dia % 7 == 6 || dia % 7 == 0) { // Sábado ou Domingo
            	simularVenda(aleatorio(70, 130), true);
            } else {
            	simularVenda(aleatorio(50, 70), false);
            }
        }
    }

    public void atualizarVenda(Produto produto) {
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
            System.out.println(totalVendas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  

    public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	public void setTotalLucro(double totalLucro) {
		this.totalLucro = totalLucro;
	}

	public void setTotalSalarios(double totalSalarios) {
		this.totalSalarios = totalSalarios;
	}

	public void setProdutosVendidos(int produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}

	public double getTotalVendas() {
        return totalVendas;
    }

    public double getTotalLucro() {
        return totalLucro;
    }

    public double getTotalSalarios() {
        return totalSalarios;
    }

    public double getLucroLiquido() {
        return totalLucro - totalSalarios;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

  

	public int getProdutosVendidos() {
        return produtosVendidos;
    }

    private int aleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}