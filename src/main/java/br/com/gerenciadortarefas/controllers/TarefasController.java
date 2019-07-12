package br.com.gerenciadortarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciadortarefas.models.Tarefa;
import br.com.gerenciadortarefas.repositories.RepositorioTarefa;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {
	
	@Autowired
	private RepositorioTarefa repositorioTarefa;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefas/listar");
		mv.addObject("tarefas", repositorioTarefa.findAll());
		return mv;	
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefas/inserir");
		mv.addObject("tarefa", new Tarefa());
		return mv;	
	}
	
	@PostMapping("/inserir")
	public String inserir(Tarefa tarefa) {
		repositorioTarefa.save(tarefa);
		return "redirect:/tarefas/listar";
		
	}
}
