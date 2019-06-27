package br.com.resource.comercio.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CompraProdutoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int compra;
	private int produto;
	private int quantidade;
	
	public CompraProdutoId() {}
	
	public CompraProdutoId(int compra, int produto, int quantidade) {
		super();
		this.compra = compra;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
