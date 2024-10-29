package testes;

import main.Restaurante;
import main.RestauranteDao;

public class TesteMostraTotalVendas {

	public static void main(String[] args) {
		
		RestauranteDao restauranteDao = new RestauranteDao();
		Restaurante restaurante = restauranteDao.mostraTotalVendas();
		
		if(restaurante!=null) {
			System.out.println("vendas " + restaurante.getTotalVendas());
			
		// TODO Auto-generated method stub
			
		} else {
			System.out.println("Produto Não Existe!!!");
		}

	}

}
