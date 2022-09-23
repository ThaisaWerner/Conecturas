package com.tw.spring.controller.livro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivroResponse {

    private Long id;

    private String titulo;

    private String generoLiterario;

    private String descricao;

    private Double preco;

    private String autor;

    private Integer classificacaoEtaria;
}
