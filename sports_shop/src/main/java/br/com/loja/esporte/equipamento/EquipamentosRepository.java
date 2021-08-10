package br.com.loja.esporte.equipamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentosRepository extends JpaRepository<Equipamentos, Long>{
	public Equipamentos findByNome(String nome);
	boolean existsByNome(String nome);
}
