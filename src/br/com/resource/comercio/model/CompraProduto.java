package br.com.resource.comercio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@IdClass(CompraProdutoId.class)
public class CompraProduto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="compra_id_fk", nullable=false)
	private Compra compra;
	
	@Id
	@ManyToOne
	@JoinColumn(name="produto_id_fk", nullable=false)
	private Produto produto;
	
	@Id
	@Column(name="qtde_produto", nullable=false)
	private int quantidade;

}
