package br.com.resource.comercio.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Produto {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="produto_id")
	private int id;
	
	@Column(name="nomeProduto", nullable=false)
	private String nome;
	
	@Column(name="valorProduto", nullable=false)
	private BigDecimal valor;
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagemProduto;	
	
	@OneToMany(mappedBy="produto")
	private List<CompraProduto> compraProdutos = new LinkedList<>();
	
}
