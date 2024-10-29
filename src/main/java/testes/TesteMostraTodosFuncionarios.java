package testes;

import java.util.List;

import main.Funcionario;
import main.RestauranteDao;

public class TesteMostraTodosFuncionarios {

	public static void main(String[] args) {
		
		RestauranteDao restauranteDao = new RestauranteDao();
		List<Funcionario> funcionarios = restauranteDao.mostraTodosFuncionarios();	
		
		for(Funcionario funcionario:funcionarios) {
			System.out.println("id produto:" + funcionario.getIdFuncionario());
			System.out.println("nome funcionario: " + funcionario.getNome());
			System.out.println("cargo:" + funcionario.getCargoFuncionario());
			System.out.println("Salario:" + funcionario.getSalario());
			System.out.println();
		}
	
	}

}
