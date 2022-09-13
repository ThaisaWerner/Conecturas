package com.tw.spring.controller.beneficiario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

<<<<<<< HEAD
import org.hibernate.validator.constraints.br.CPF;

=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
import com.tw.spring.model.ClienteBeneficiario;
import lombok.Data;

@Data
public class ClienteBeneficiarioRequest {

<<<<<<< HEAD
	@NotBlank(message = "O campo deve ser preenchido")
    @Size(min = 3, max = 60, message = "O nome deve conter entre 3 e 60 caracteres")
	private String nome;
	
	@NotBlank(message = "O campo deve ser preenchido")
	@Email(message = "Insira um email válido")
    private String email;
	
	@NotBlank(message = "O campo deve ser preenchido")
    private String senha;
	
	@NotBlank(message = "O campo deve ser preenchido")
    private String endereco;
	
	@NotBlank(message = "O campo deve ser preenchido")
	@CPF(message = "Insira um CPF válido")
=======
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
	
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
    private String cpf;

    public ClienteBeneficiario convertToModel(){
        return new ClienteBeneficiario(null, this.nome, this.email, this.senha, this.endereco, this.cpf, null);
    }
}
