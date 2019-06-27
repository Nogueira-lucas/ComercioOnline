package br.com.resource.comercio.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compra_id")
	private int id;
	
	@Column(nullable=false)
	private LocalDate dataCompra;
	
	@Column(nullable=false, scale=2, name="valor_total")
	private BigDecimal valor;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;
	
	@OneToMany(mappedBy="compra")
	private List<CompraProduto> compraProdutos = new LinkedList<>();
	
}
