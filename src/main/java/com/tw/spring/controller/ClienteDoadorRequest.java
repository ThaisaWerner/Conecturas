package com.tw.spring.controller;

import com.tw.spring.model.ClienteDoador;

import lombok.Data;

@Data
public class ClienteDoadorRequest {
	private String  nome;
	private String  email;
	private String  senha;
	private String  cpf;
	
	public ClienteDoador convertToModel() {
		return new ClienteDoador(null, this.nome, this.email, this.senha, this.cpf);
	}

}
