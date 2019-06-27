package br.com.resource.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.resource.comercio.model.Produto;
import br.com.resource.dao.Dao;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private Dao dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("produtos", dao.buscaTodos(Produto.class));
		model.addAttribute("produto", new Produto());
		return "produto";
	}

	@RequestMapping("/salvar")
	public String salvar(@ModelAttribute Produto produto,
						 @RequestParam(required=false, value="imagem")MultipartFile imagemProduto,
						 RedirectAttributes redirectAtt) throws IOException {
		byte[] bImagem;
		
		try {
			if(imagemProduto != null && imagemProduto.getSize() > 0) {
				bImagem = imagemProduto.getBytes();
				produto.setImagemProduto(bImagem);
			}
			
			if(produto.getId()==0) {
				dao.salvar(produto);
				redirectAtt.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
			}else {
				dao.altera(produto);
				redirectAtt.addFlashAttribute("mensagem", "Produto alterado com sucesso!");
			}
			
		}catch(Exception ex) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro grave");
		}
		
		return "redirect:/produto";
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable(name="id") int id,
						 RedirectAttributes redirectAtt) {
		try {
			Produto produto = dao.buscarPorId(id, Produto.class);
			dao.excluir(produto);
			redirectAtt.addFlashAttribute("mensagem", "Produto excluido com sucesso!");
		}catch(Exception ex) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro grave");
		}
		return "redirect:/produto";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable(name="id") int id, 
						  Model model,
						  RedirectAttributes redirectAtt) {
		try {
			Produto produto = dao.buscarPorId(id, Produto.class);
			byte[] baseEncode64 = Base64.getEncoder().encode(produto.getImagemProduto());
			String baseEncoded64 = new String(baseEncode64, "UTF-8");
			
			model.addAttribute("produtos", dao.buscaTodos(Produto.class));
			model.addAttribute("produto", produto);
			model.addAttribute("imagemProduto", baseEncoded64);

		}catch(UnsupportedEncodingException ex) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro Grave: "+ex.getMessage());
		}
		return "produto";
	}
	
	@RequestMapping("/cancelar")
	public String cancelar() {
		return "redirect:/produto";
	}
	
	@RequestMapping("/voltar")
	public String voltar() {
		return "redirect:/";
	}
}
