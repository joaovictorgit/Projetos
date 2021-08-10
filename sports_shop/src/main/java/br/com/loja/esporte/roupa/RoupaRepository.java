package br.com.loja.esporte.roupa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoupaRepository extends JpaRepository<Roupa, Long>{
	public Roupa findByTipo(String tipo);
	boolean existsByTipo(String tipo);
}