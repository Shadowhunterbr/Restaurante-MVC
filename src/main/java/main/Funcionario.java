package main;

public class Funcionario {
	private int idFuncionario;
    private String nome;
    private String cargoFuncionario;
    private double salario;
	private String login;
	private String senha;
	

    public Funcionario(int idFuncionario,String nome, String cargoFuncionario, double salario) {
    	this.idFuncionario = idFuncionario;
    	this.nome = nome;
        this.salario = salario;
        this.cargoFuncionario = cargoFuncionario;
    }
    
    public Funcionario(String nome, String cargoFuncionario, double salario) {
    	this.nome = nome;
        this.salario = salario;
        this.cargoFuncionario = cargoFuncionario;
    }
    
    
    
    
    public Funcionario() {
		// TODO Auto-generated constructor stub
	}



	public int getIdFuncionario() {
		return idFuncionario;
	}



	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}



	public String getCargoFuncionario() {
		return cargoFuncionario;
	}


	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}


	public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}