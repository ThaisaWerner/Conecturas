package com.tw.spring.controller.doador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

import com.tw.spring.model.ClienteDoador;

import lombok.Data;

@Data
public class ClienteDoadorRequest {
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	@Size(min = 3, max = 60)
	private String  nome;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	@Email(message = "Insira um email válido")
	private String  email;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	private String  senha;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	@CPF(message = "Insira o CPF no formato xxx.xxx.xxx-xx")
	private String  cpf;
	
	public ClienteDoador convertToModel() {
		return new ClienteDoador(null, this.nome, this.email, this.senha, this.cpf);
	}

}
