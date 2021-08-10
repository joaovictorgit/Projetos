package br.com.loja.esporte.equipamento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraEquipamentosRequest {
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(max = 100)
	private String descricao;

	public CadastraEquipamentosRequest(@NotBlank String nome, @NotBlank @Size(max = 100) String descricao) {
		super();
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
	
	public Equipamentos toModel() {
		return new Equipamentos(this.nome, this.descricao);
	}
}
