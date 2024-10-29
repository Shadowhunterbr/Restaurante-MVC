package testes;

import main.Funcionario;
import main.RestauranteDao;

public class TesteCadastraFuncionario {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario (0,"maria","gerente",4000);

		RestauranteDao restauranteDao = new RestauranteDao();
		restauranteDao.cadastraFuncionario(funcionario);
		// TODO Auto-generated method stub

	}

}
