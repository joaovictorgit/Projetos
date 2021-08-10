package br.com.loja.esporte.roupa;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoupaController {
	@Autowired
	RoupaRepository roupaRepository;
	
	@RequestMapping(value = "/roupa")
	public String roupa() {
		return "cadastrarRoupa";
	}
	
	@PostMapping(value = "/roupa")
	//@Transactional
	//@ResponseBody
	public String addRoupa(/*@Valid CadastraRoupaRequest cadastraRoupaRequest*/ Roupa roupa){
		boolean existsRoupa = roupaRepository.existsByTipo(roupa.getTipo());
		
		if(existsRoupa) {
			//return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar a roupa");
			deleteRoupa(roupa.getTipo());
		}
		//Roupa roupas = cadastraRoupaRequest.toModel();
		
		roupaRepository.save(roupa);
		
		//return ResponseEntity.created(null).body("roupa cadastrada com sucesso");
		return "redirect:/listarRoupas";
		
	}
	
	@RequestMapping(value = "/listarRoupas")
	public ModelAndView listarRoupas() {
		ModelAndView mv  = new ModelAndView("listarRoupas");
		Iterable<Roupa> roupas = roupaRepository.findAll();
		
		mv.addObject("roupas", roupas);
		
		return mv;
	}
	
	@RequestMapping(value = "/editarRoupas/{tipo}")
	public ModelAndView buildUpdateRoupas(@PathVariable("tipo") String tipo) {
		ModelAndView mv = new ModelAndView("editarRoupas");
		Roupa roupa= roupaRepository.findByTipo(tipo);
		mv.addObject("roupa",roupa);
		return mv;
	}
	
	@RequestMapping(value = "/roupaAtt")
	public String updateRoupas(Roupa roupa) {
		
		return "redirect:/listarRoupas";
	}
	
	@RequestMapping("/deleteRoupas/{tipo}")
	public String deleteRoupa(@PathVariable("tipo") String tipo) {
		Roupa roupa= roupaRepository.findByTipo(tipo);
		roupaRepository.delete(roupa);
		return "redirect:/listarRoupas";
	}
}