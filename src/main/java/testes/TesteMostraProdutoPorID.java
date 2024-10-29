package testes;

import main.Produto;
import main.RestauranteDao;

public class TesteMostraProdutoPorID {

	public static void main(String[] args) {
		
		RestauranteDao restauranteDao = new RestauranteDao();
		Produto produto = restauranteDao.mostraPorId(2);
		
		if(produto!=null) {
			System.out.println("id produto:" + produto.getIdProduto());
			System.out.println("nome produto: " + produto.getNomeProduto());
			System.out.println("custo produto:" + produto.getPrecoCusto());
			System.out.println("valor produto:" + produto.getPrecoVenda());
			System.out.println("porcentagem venda: " + produto.getProbabilidadeVenda());
			System.out.println("quantidade Vendida: " + produto.getQuantidadeVendida());
			System.out.println("Venda total: " + produto.getProdutoTotalVendido());
			System.out.println();
		} else {
			System.out.println("Produto Não Existe!!!");
		}
		
		
		// TODO Auto-generated method stub

	}

}
