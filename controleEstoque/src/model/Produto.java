package model;

public class Produto {
	
	private String categoria;
	private String nome;
	private String  valor;
	private String quantidade;
	private String fabricante;
	private String descricao;
	private long id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String string) {
		this.valor = string;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String string) {
		this.quantidade = string;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Produto [categoria=" + categoria + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", fabricante=" + fabricante + ", descricao=" + descricao + ", id=" + id + "]";
	}
	
	

}
