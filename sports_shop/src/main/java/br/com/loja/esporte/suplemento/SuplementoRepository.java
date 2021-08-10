package br.com.loja.esporte.suplemento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SuplementoRepository extends JpaRepository<Suplemento, Long>{
	//public Optional<Suplemento> findByMarca(String marca);
	//boolean existsByMarca(String marca);
	public Suplemento findByNome(String nome);
	public Suplemento getByNome(String nome);
	boolean existsByNome(String nome);
}