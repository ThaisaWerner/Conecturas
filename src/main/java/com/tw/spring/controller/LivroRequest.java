package com.tw.spring.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tw.spring.model.Livro;

import lombok.Data;

@Data
public class LivroRequest {
	
 
	@NotBlank(message = "O campo deve ser preenchido")
	private String titulo;
	
	@NotBlank(message = "O campo deve ser preenchido")
	private String generoLiterario;
	
	@NotBlank(message = "O campo deve ser preenchido")
	private String descricao;
	
	@NotNull(message = "O campo deve ser preenchido")
	private Double preco;
	
	@NotBlank(message = "O campo deve ser preenchido")
	private String autor;
	
	@NotNull(message = "O campo deve ser preenchido")
	private Integer classificacaoEtaria;

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




