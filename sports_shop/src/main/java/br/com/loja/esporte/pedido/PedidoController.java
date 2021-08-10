package br.com.loja.esporte.pedido;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
	@Autowired
	PedidoRepository pedidoRepository;
	/*
	@PostMapping(value = "/pedido")
	@Transactional
	public ResponseEntity<Object> addPedido(@Valid CadastraPedidoRequest cadastraPedidoRequest){
		boolean existsPedido = pedidoRepository.existsByNome(cadastraPedidoRequest.getNome());
		
		if(existsPedido) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar o pedido");
		}
		Pedido pedido = cadastraPedidoRequest.toModel();
		
		pedidoRepository.save(pedido);
		
		return ResponseEntity.created(null).body("Pedido cadastrado com sucesso");
	}
	
	@PutMapping(value = "/pedido{nome}")
	@Transactional
	public ResponseEntity<Object> updatePedido(@Valid CadastraPedidoRequest cadastraPedidoRequest, String nome) {
		Pedido pedido = pedidoRepository.findByNome(nome);
		
		if(pedido.equals(null)) {
			return null;
		}
		
		pedido.setNome(cadastraPedidoRequest.getNome());
		pedido.setMarca(cadastraPedidoRequest.getMarca());
		pedido.setQuantidade(cadastraPedidoRequest.getQuantidade());
		final Pedido updatePedido = pedidoRepository.save(pedido);
		return ResponseEntity.ok(updatePedido);
	}
	
	@DeleteMapping(value="/pedido{nome}")
	@Transactional
	public void deletePedido(String nome){
		Pedido pedido = pedidoRepository.findByNome(nome);
		
		if(pedido.equals(null)) {
			return ;
		}
		
		pedidoRepository.delete(pedido);
		
	}*/
}
