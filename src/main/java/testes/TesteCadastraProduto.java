package testes;

import main.Produto;
import main.RestauranteDao;

public class TesteCadastraProduto {

	public static void main(String[] args) {

		Produto produto = new Produto(0, "onion rings", 20.0, 15.0, 0.15, 0);

		RestauranteDao restauranteDao = new RestauranteDao();
		restauranteDao.cadastra(produto);
		// TODO Auto-generated method stub

	}
}