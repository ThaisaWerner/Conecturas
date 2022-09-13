package com.tw.spring.controller.doador;

import javax.validation.constraints.NotBlank;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

<<<<<<< HEAD
import javax.persistence.UniqueConstraint;
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
import javax.validation.constraints.Email;

import com.tw.spring.model.ClienteDoador;

import lombok.Data;

@Data
public class ClienteDoadorRequest {
	
<<<<<<< HEAD
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
=======
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
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
	private String  cpf;
	
	public ClienteDoador convertToModel() {
		return new ClienteDoador(null, this.nome, this.email, this.senha, this.cpf, null);
	}

}
