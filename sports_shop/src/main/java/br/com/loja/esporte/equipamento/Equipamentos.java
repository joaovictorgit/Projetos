package br.com.loja.esporte.equipamento;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Equipamentos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(max = 100)
	private String descricao;
	
	@PastOrPresent
	LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Deprecated
	public Equipamentos() {}

	public Equipamentos(@NotBlank String nome, @NotBlank @Size(max = 100) String descricao) {
		//super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
