package testes;

import main.Funcionario;
import main.RestauranteDao;

public class TesteMostraFuncionarioPorID {

public static void main(String[] args) {
		
		RestauranteDao restauranteDao = new RestauranteDao();
		Funcionario funcionario = restauranteDao.mostraFuncionarioPorId(2);
		
		if(funcionario!=null) {
			System.out.println("id Funcionario:" + funcionario.getIdFuncionario());
			System.out.println("Nome Funcionario: " + funcionario.getNome());
			System.out.println("Cargo:" + funcionario.getCargoFuncionario());
			System.out.println("Salario:" + funcionario.getSalario());
		
		} else {
			System.out.println("Funcionario Não Existe!!!");
		}
		
		
		// TODO Auto-generated method stub

	}

}
