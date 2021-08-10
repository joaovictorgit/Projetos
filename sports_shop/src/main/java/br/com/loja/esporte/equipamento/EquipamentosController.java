package br.com.loja.esporte.equipamento;

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
public class EquipamentosController {
	@Autowired
	EquipamentosRepository equipamentosRepository;
	
	@RequestMapping(value = "/equipamento")
	public String equipamento() {
		return "cadastrarEquipamento";
	}
	
	@PostMapping(value = "/equipamento")
	
	public String addEquipamento(Equipamentos equipamentos){
		boolean existsEquipamento = equipamentosRepository.existsByNome(equipamentos.getNome());
		
		if(existsEquipamento) {
			deleteEquipamento(equipamentos.getNome());
		}
		
		
		equipamentosRepository.save(equipamentos);
		
		return "redirect:/listarEquipamentos";
		
	}
	
	@RequestMapping(value = "/listarEquipamentos")
	public ModelAndView listarEquipamentos() {
		ModelAndView mv  = new ModelAndView("listarEquipamentos");
		Iterable<Equipamentos> equipamentos = equipamentosRepository.findAll();
		
		mv.addObject("equipamentos", equipamentos);
		
		return mv;
	}
	
	@RequestMapping(value = "/editarEquipamentos/{nome}")
	public ModelAndView buildUpdateEquipamentos(@PathVariable("nome") String nome) {
		ModelAndView mv = new ModelAndView("editarEquipamentos");
		Equipamentos equipamento = equipamentosRepository.findByNome(nome);
		mv.addObject("equipamento",equipamento);
		return mv;
	}
	@RequestMapping(value = "/equipamentoAtt")
	public String updateSuplementos(Equipamentos equipamento) {
		
		return "redirect:/listarEquipamentos";
	}
	
	@RequestMapping("/deleteEquipamentos/{nome}")
	public String deleteEquipamento(@PathVariable("nome") String nome) {
		Equipamentos equipamento = equipamentosRepository.findByNome(nome);
		equipamentosRepository.delete(equipamento);
		return "redirect:/listarEquipamentos";
	}
}
