package com.tw.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livro")
@SequenceGenerator(name="seq_livros",sequenceName = "seq_livros",allocationSize = 1,initialValue = 1)
public class Livro implements Serializable {

				
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_livros")
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "generoLiterario")
	private String generoLiterario;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private double preco;
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "classificacaoEtaria")
	private int classificacaoEtaria;

	@ManyToMany(mappedBy = "livros")
	List<Pedido> pedidos;

}
