package br.com.loja.esporte.carrinho;

import org.springframework.data.jpa.repository.JpaRepository;


//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	public Carrinho findByNome(String nome);
	boolean existsByNome(String nome);
}
