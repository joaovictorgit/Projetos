package br.com.loja.esporte.suplemento;

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
public class SuplementoController {
	long lastID;
	@Autowired
	SuplementoRepository suplementosRepository;
	
	@RequestMapping(value = "/suplemento")
	public String sup() {
		return "cadastrarSuplemento";
	}
	
	@PostMapping(value = "/suplemento")
	
	public String addSuplemento(Suplemento suplemento){
		boolean existsSuplemento = suplementosRepository.existsByNome(suplemento.getNome());
		
		if(existsSuplemento) {
			deleteSuplemento(suplemento.getNome());
		}
		
		
		suplementosRepository.save(suplemento);
		
		return "redirect:/listarSuplementos";
		
	}
	
	@RequestMapping(value = "/listarSuplementos")
	public ModelAndView listarSuplementos() {
		ModelAndView mv  = new ModelAndView("listarSuplementos");
		Iterable<Suplemento> suplementos = suplementosRepository.findAll();
		
		mv.addObject("suplementos", suplementos);
		
		return mv;
	}
	
	@RequestMapping(value = "/editarSuplementos/{nome}")
	public ModelAndView buildUpdateSuplementos(@PathVariable("nome") String nome) {
		ModelAndView mv = new ModelAndView("editarSuplementos");
		Suplemento suplemento = suplementosRepository.findByNome(nome);
		mv.addObject("suplemento",suplemento);
		return mv;
	}
	@RequestMapping(value = "/suplementoAtt")
	public String updateSuplementos(Suplemento sup) {
		
		return "redirect:/listarSuplementos";
	}
	
	@RequestMapping("/deleteSuplementos/{nome}")
	public String deleteSuplemento(@PathVariable("nome") String nome) {
		Suplemento suplemento = suplementosRepository.findByNome(nome);
		suplementosRepository.delete(suplemento);
		return "redirect:/listarSuplementos";
	}
}