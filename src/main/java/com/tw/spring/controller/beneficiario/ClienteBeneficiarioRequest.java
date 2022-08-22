package com.tw.spring.controller.beneficiario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tw.spring.model.ClienteBeneficiario;
import lombok.Data;

@Data
public class ClienteBeneficiarioRequest {

	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	@Size(min = 3, max = 60)
	private String nome;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
	@Email(message = "Insira um email válido")
    private String email;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
    private String senha;
	
	@NotNull(message = "O campo deve ser preenchido")
    @NotEmpty(message = "O Campo não pode estar vazio")
    @NotBlank(message = "O Campo não pode estar em branco")
    private String endereco;
	
    private String cpf;

    public ClienteBeneficiario convertToModel(){
        return new ClienteBeneficiario(null, this.nome, this.email, this.senha, this.endereco, this.cpf, null);
    }
}
