package br.com.loja.esporte.pedido;




import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	public Pedido findByNome(String nome);
	boolean existsByNome(String nome);
}
