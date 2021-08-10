package br.com.loja.esporte.suplemento;

import javax.validation.constraints.NotBlank;



public class CadastraSuplementosRequest {
	@NotBlank
	private String nome;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String quantidade;

	public CadastraSuplementosRequest(@NotBlank String nome, @NotBlank String marca, @NotBlank String quantidade) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public Suplemento toModel() {
		return new Suplemento(this.nome, this.marca, this.quantidade);
	}
	
}
