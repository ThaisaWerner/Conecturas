package com.tw.spring.controller.doador;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.tw.spring.model.ClienteDoador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDoadorRequest {
	
	@NotBlank(message = "O campo deve ser preenchido")
    @Size(min = 3, max = 60, message = "O nome deve conter entre 3 e 60 caracteres")
	private String  nome;
	
	@NotBlank(message = "O campo deve ser preenchido")
	@Email(message = "Insira um email válido")
	private String  email;
	
	@NotBlank(message = "O campo deve ser preenchido")
	private String  senha;
	
	@NotBlank(message = "O campo deve ser preenchido")
	@CPF(message = "Insira um CPF válido")
	private String  cpf;
	
	public ClienteDoador convertToModel() {
		return new ClienteDoador(null, this.nome, this.email, this.senha, this.cpf, null);
	}

}
