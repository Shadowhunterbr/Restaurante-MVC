package testes;

import java.util.List;



import main.Produto;
import main.RestauranteDao;

public class TesteMostraProdutos {

	public static void main(String[] args) {
		
		RestauranteDao restauranteDao = new RestauranteDao();
		List<Produto> produtos = restauranteDao.mostraTodos();	
		
		for(Produto produto:produtos) {
			System.out.println("id produto:" + produto.getIdProduto());
			System.out.println("nome produto: " + produto.getNomeProduto());
			System.out.println("custo produto:" + produto.getPrecoCusto());
			System.out.println("valor produto:" + produto.getPrecoVenda());
			System.out.println("porcentagem venda: " + produto.getProbabilidadeVenda());
			System.out.println("total: " + produto.getProdutoTotalVendido());
			System.out.println();
		}
	
	}

}
