package com.tw.spring.controller;

import com.tw.spring.model.Livro;

import lombok.Data;

@Data
public class LivroRequest {
	
 
	private Long id;
	private String titulo;
	private String generoLiterario;
	private String descricao;
	private double preco;
	private String autor;
	private int classificacaoEtaria;

	public Livro converterClasse() {
		
		return Livro.builder().titulo(this.titulo)
					          // .id(1L)
				              .generoLiterario(this.generoLiterario)
				              .descricao(this.descricao)
				              .preco(this.preco)
				              .autor(this.autor)
				              .classificacaoEtaria(this.classificacaoEtaria)
				              .build();
		
		
	}
        

}




