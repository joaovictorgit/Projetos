package br.com.loja.esporte.carrinho;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	@Size(max = 30)
	private String endereco;
	
	@PastOrPresent
	LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Deprecated
	public Carrinho() {}

	public Carrinho(@NotBlank String nome, @NotBlank String marca, @NotBlank @Size(max = 30) String endereco) {
		//super();
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
	
	
	
}
