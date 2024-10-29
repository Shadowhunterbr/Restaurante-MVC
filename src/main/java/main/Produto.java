package main;

public class Produto {

	public Produto(String nomeProduto, double precoVenda, double precoCusto, double probabilidadeVenda,
			int quantidadeVendida) {
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.precoCusto = precoCusto;
		this.probabilidadeVenda = probabilidadeVenda;
		this.quantidadeVendida = quantidadeVendida;
		this.produtoTotalVendido = this.calcularVendaProduto();
	}

	public Produto(int idProduto, String nomeProduto, double precoVenda, double precoCusto, double probabilidadeVenda,
			int quantidadeVendida) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.precoCusto = precoCusto;
		this.probabilidadeVenda = probabilidadeVenda;
		this.quantidadeVendida = quantidadeVendida;
		this.produtoTotalVendido = this.calcularVendaProduto();
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	private int idProduto;
	private String nomeProduto;
	private double precoVenda;
	private double precoCusto;
	private double probabilidadeVenda;
	private int quantidadeVendida;
	private double produtoTotalVendido;

	// public void incrementarQuantidadeVendida() {
	// this.quantidadeVendida++;
	// }

	public double calcularVendaProduto() {
		return (this.precoVenda * this.quantidadeVendida);
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public double getLucro() {
		return precoVenda - precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public double getProbabilidadeVenda() {
		return probabilidadeVenda;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getProdutoTotalVendido() {
		return produtoTotalVendido;
	}

	public void setProdutoTotalVendido(double produtoTotalVendido) {
		this.produtoTotalVendido = produtoTotalVendido;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public void setProbabilidadeVenda(double probabilidadeVenda) {
		this.probabilidadeVenda = probabilidadeVenda;
	}
}