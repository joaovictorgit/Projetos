package br.com.loja.esporte.tenis;

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
public class TenisController {
	@Autowired
	TenisRepository tenisRepository;
	
	@RequestMapping(value = "/tenis")
	public String tenis() {
		return "cadastrarTenis";
	}
	
	@PostMapping(value = "/tenis")
	
	public String addTenis(Tenis tenis){
		boolean existsTenis = tenisRepository.existsByTipo(tenis.getTipo());
		
		if(existsTenis) {
			deleteTenis(tenis.getTipo());
		}
		
		
		tenisRepository.save(tenis);
		
		return "redirect:/listarTenis";
		
	}
	
	@RequestMapping(value = "/listarTenis")
	public ModelAndView listarTenis() {
		ModelAndView mv  = new ModelAndView("listarTenis");
		Iterable<Tenis> tenis = tenisRepository.findAll();
		
		mv.addObject("tenis", tenis);
		
		return mv;
	}
	
	@RequestMapping(value = "/editarTenis/{tipo}")
	public ModelAndView buildUpdateTenis(@PathVariable("tipo") String tipo) {
		ModelAndView mv = new ModelAndView("editarTenis");
		Tenis tenis = tenisRepository.findByTipo(tipo);
		mv.addObject("tenis",tenis);
		return mv;
	}
	
	@RequestMapping(value = "/tenisAtt")
	public String updateRoupas(Tenis tenis) {
		
		return "redirect:/listarTenis";
	}
	
	@RequestMapping("/deleteTenis/{tipo}")
	public String deleteTenis(@PathVariable("tipo") String tipo) {
		Tenis tenis = tenisRepository.findByTipo(tipo);
		tenisRepository.delete(tenis);
		return "redirect:/listarTenis";
	}
}