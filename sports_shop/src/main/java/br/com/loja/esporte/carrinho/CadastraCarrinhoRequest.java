package br.com.loja.esporte.carrinho;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraCarrinhoRequest {
	@NotBlank
	private String nome;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	@Size(max = 30)
	private String endereco;

	public CadastraCarrinhoRequest(@NotBlank String nome, @NotBlank String marca,
			@NotBlank @Size(max = 30) String endereco) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Carrinho toModel() {
		return new Carrinho(this.nome, this.marca, this.endereco);
	}
	
}
