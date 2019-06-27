package br.com.resource.comercio.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	private List<Compra> compras = new LinkedList<>();
	
}
