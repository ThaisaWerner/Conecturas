package com.tw.spring.controller.doador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClienteDoadorResponse {
	private Long id;
	private String  nome;
	private String  email;
	private String  senha;
	private String  cpf;
	

}
