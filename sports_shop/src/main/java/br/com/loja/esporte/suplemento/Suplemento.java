package br.com.loja.esporte.suplemento;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;


@Entity
public class Suplemento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String quantidade;
	
	@PastOrPresent
	LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Deprecated
	public Suplemento() {}

	public Suplemento(@NotBlank String nome, @NotBlank String marca, @NotBlank String quantidade) {
		//super();
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
	
}
