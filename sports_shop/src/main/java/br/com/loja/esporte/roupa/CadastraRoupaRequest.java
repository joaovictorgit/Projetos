package br.com.loja.esporte.roupa;

import javax.validation.constraints.NotBlank;


public class CadastraRoupaRequest {
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String cor;
	
	@NotBlank
	private String tamanho;
	
	public CadastraRoupaRequest(@NotBlank String tipo, @NotBlank String marca, @NotBlank String cor, @NotBlank String tamanho) {
		super();
		this.tipo = tipo;
		this.marca = marca;
		this.cor = cor;
		this.tamanho = tamanho;
	}

	

	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getTamanho() {
		return tamanho;
	}



	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	public Roupa toModel() {
		return new Roupa (this.tipo, this.marca, this.cor, this.tamanho);
	}
}
