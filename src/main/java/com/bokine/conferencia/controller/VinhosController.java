package com.bokine.conferencia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bokine.conferencia.model.Produto;
import com.bokine.conferencia.model.TipoVinho;
import com.bokine.conferencia.repository.Conferencias;

@Controller
@RequestMapping("/conferencia")
public class VinhosController {
	
	@Autowired
	private Conferencias conferencias;
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		conferencias.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Produto removido com sucesso!");
		
		return "redirect:/conferencia";
	}
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("conferencia/lista-conferencia");
		modelAndView.addObject("produtos", conferencias.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("conferencia/cadastro-conferencia");
		
		modelAndView.addObject(produto);
		modelAndView.addObject("tipos", TipoVinho.values());
		modelAndView.addObject("produtos", conferencias.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		conferencias.save(produto);
		
		return new ModelAndView("redirect:/conferencia/novo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(conferencias.findOne(id));
	}
}
