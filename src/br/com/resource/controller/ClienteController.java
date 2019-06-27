package br.com.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.resource.comercio.model.Cliente;
import br.com.resource.dao.Dao;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private Dao dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("clientes", dao.buscaTodos(Cliente.class));
		model.addAttribute("cliente", new Cliente());
		return "cliente";
	}
	
	@RequestMapping("/salvar")
	public String salvar(Cliente cliente,
						 RedirectAttributes redirectAttr) {
		try {
			if(cliente.getId() == 0) {
				dao.salvar(cliente);
				redirectAttr.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
			}else {
				dao.altera(cliente);
				redirectAttr.addFlashAttribute("mensagem", "Cliente atualizado com sucesso!");
			}
		}catch(Exception ex) {
			redirectAttr.addFlashAttribute("mensagemErro", "Erro grave: "+ex.getMessage());
		}
		return "redirect:/cliente";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable(name="id")int id,
						  Model model,
						  RedirectAttributes redirectAtt) {
		try {
			model.addAttribute("clientes", dao.buscaTodos(Cliente.class));
			model.addAttribute("cliente", dao.buscarPorId(id, Cliente.class));
		}catch(Exception ex){
			redirectAtt.addFlashAttribute("mensagemErro", "Erro grave:"+ex.getMessage());
		}
		return "cliente";
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable(name="id")int id, 
						  Model model,
						  RedirectAttributes redirectAtt) {
		try {
			Cliente cliente = dao.buscarPorId(id, Cliente.class);
			dao.excluir(cliente);
			redirectAtt.addFlashAttribute("mensagem", "Cliente excluído com sucecsso!");
		}catch(Exception ex) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro grave: "+ex.getMessage());
		}
		return "redirect:/cliente";
	}
	
	@RequestMapping("/cancelar")
	public String cancelar() {
		return "redirect:/cliente";
	}
	
	@RequestMapping("/voltar")
	public String voltar() {
		return "redirect:/";
	}
}
