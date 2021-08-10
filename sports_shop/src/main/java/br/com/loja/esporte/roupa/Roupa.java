package br.com.loja.esporte.roupa;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;


@Entity
public class Roupa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String cor;
	
	@NotBlank
	private String tamanho;
	
	@PastOrPresent
	LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Deprecated
	public Roupa() {}

	public Roupa(@NotBlank String tipo, @NotBlank String marca, @NotBlank String cor, @NotBlank String tamanho) {
		//super();
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
	
	
}
