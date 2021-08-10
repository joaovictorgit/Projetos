package br.com.loja.esporte.carrinho;

//import javax.transaction.Transactional;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class CarrinhoController {
	
	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	/*@PostMapping(value = "/carrinho")
	@Transactional
	public ResponseEntity<Object> addCarrinho(@RequestBody @Valid CadastraCarrinhoRequest cadastraCarrinhoRequest){
		boolean existsCarrinho = carrinhoRepository.existsByNome(cadastraCarrinhoRequest.getNome());
		
		if(existsCarrinho) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao adicionar ao carrinho");
		}
		
		Carrinho carrinho = cadastraCarrinhoRequest.toModel();
		
		carrinhoRepository.save(carrinho);
		
		return ResponseEntity.created(null).body("Adicionado ao carrinho com sucesso");
	}
	
	@PutMapping(value = "/carrinho{nome}")
	@Transactional
	public ResponseEntity<Object> updateCarrinho(@RequestBody @Valid CadastraCarrinhoRequest cadastraCarrinhoRequest, String nome){
		Carrinho carrinho = carrinhoRepository.findByNome(nome);
		
		if(carrinho.equals(null)) {
			return null;
		}
		
		carrinho.setNome(cadastraCarrinhoRequest.getNome());
		carrinho.setMarca(cadastraCarrinhoRequest.getMarca());
		carrinho.setEndereco(cadastraCarrinhoRequest.getEndereco());
		
		final Carrinho updateCarrinho = carrinhoRepository.save(carrinho);
		return ResponseEntity.ok(updateCarrinho);
		
	}
	@DeleteMapping(value="/carrinho{nome}")
	@Transactional
	public void deleteCarrinho(String nome){
		Carrinho carrinho = carrinhoRepository.findByNome(nome);
		
		if(carrinho.equals(null)) {
			return ;
		}
		
		carrinhoRepository.delete(carrinho);
		
	}*/
	@RequestMapping("/listarCarrinho")
	public ModelAndView listarPedidos() {
		ModelAndView mv  = new ModelAndView("index");
		Iterable<Carrinho> eventos = carrinhoRepository.findAll();
		
		mv.addObject("eventos", eventos);
		
		return mv;
	}
	
	@RequestMapping("/carrinho")
	public String addformPedido(Model model) {
		Carrinho carrinho= new Carrinho();
		model.addAttribute("carrinho", carrinho);
		return "new_carrinho";
	}
	
	@PostMapping(value = "pedido")
	public String addPedido(Carrinho carrinho) {
		boolean existsNome = carrinhoRepository.existsByNome(carrinho.getNome());
		if(existsNome) {
			deleteCarrinho(carrinho.getNome());
		}
		carrinhoRepository.save(carrinho);
		return "redirect:/carrinho";
	}
	
	@RequestMapping("/edit/{nome}")
	public ModelAndView updateCarrinho(@PathVariable("nome") String nome) {
		ModelAndView mv = new ModelAndView("edit");
		Carrinho carrinho = carrinhoRepository.findByNome(nome);
		mv.addObject("carrinhos",carrinho);
		return mv;
	}
	
	@RequestMapping("/delete/{nome}")
	public String deleteCarrinho(@PathVariable("nome") String nome) {
		Carrinho carrinho = carrinhoRepository.findByNome(nome);
		carrinhoRepository.delete(carrinho);
		return "redirect:/listarCarrinho";
	}
}
