package main;

public class Principal {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        // Adicionando produtos ao cardápio
        //restaurante.adicionarProduto(new Produto("Hambúrguer", 30.0, 15.0, 0.7));
        //restaurante.adicionarProduto(new Produto("Salmão", 70.0, 35.0, 0.3));
      //  Produto produto = new Produto(0,"Salmão",50.0,25.0,0.70,0);
		
	//	RestauranteDao restauranteDao = new RestauranteDao();
	//	restauranteDao.cadastra(produto);
        // Adicionando funcionários
        //restaurante.adicionarFuncionario(new Funcionario("João", "garçom" ,2000));
        //restaurante.adicionarFuncionario(new Funcionario("Maria","gerente",2500));
        Produto produto = new Produto();
        // Simulando um mês de operação
        restaurante.simula1();

        // Exibindo resultados
        System.out.println("Total de Vendas: " + restaurante.getTotalVendas());
        System.out.println("Total de Lucro: " + restaurante.getTotalLucro());
        System.out.println("Total de Salários: " + restaurante.getTotalSalarios());
        System.out.println("Lucro Líquido: " + restaurante.getLucroLiquido());
        System.out.println("Clientes Atendidos: " + restaurante.getClientesAtendidos());
        System.out.println("itens Vendidos: " + produto.getProdutoTotalVendido());
        System.out.println("Salmões Vendidos: " + produto.getQuantidadeVendida());
   
    }	
}