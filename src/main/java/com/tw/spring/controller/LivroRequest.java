package com.tw.spring.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tw.spring.model.Livro;

import lombok.Data;

@Data
public class LivroRequest {
	
 
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private String titulo;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private String generoLiterario;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private String descricao;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private double preco;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private String autor;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
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




