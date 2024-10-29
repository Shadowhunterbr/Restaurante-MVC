package testes;

import main.Produto;
import main.RestauranteDao;

public class TesteAlteraProduto {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Produto produto = new Produto(3,"batata frita Mc cain",50.0,25.0,0.50,0);
		
		RestauranteDao restauranteDao = new RestauranteDao();
		restauranteDao.alteraProduto(produto);
		
	}

}
