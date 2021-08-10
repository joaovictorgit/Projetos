package br.com.loja.esporte.tenis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenisRepository extends JpaRepository<Tenis, Long>{
	public Tenis findByTipo(String tipo);
	boolean existsByTipo(String tipo);
}