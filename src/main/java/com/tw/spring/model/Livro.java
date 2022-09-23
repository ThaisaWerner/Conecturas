package com.tw.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.tw.spring.controller.livro.LivroResponse;
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
	
	@Column(name = "genero_literario")
	private String generoLiterario;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "classificacao_etaria")
	private int classificacaoEtaria;

	@ManyToMany(mappedBy = "livros")
	private List<Pedido> pedidos;

	public LivroResponse converterParaResponse() {
		return LivroResponse.builder()
				.id(this.id)
				.titulo(this.titulo)
				.generoLiterario(this.generoLiterario)
				.descricao(this.descricao)
				.preco(this.preco)
				.autor(this.autor)
				.classificacaoEtaria(this.classificacaoEtaria)
				.build();
	}
}
