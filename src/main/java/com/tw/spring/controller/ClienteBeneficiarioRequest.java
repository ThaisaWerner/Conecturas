package com.tw.spring.controller;

import com.tw.spring.model.ClienteBeneficiario;
import lombok.Data;

@Data
public class ClienteBeneficiarioRequest {

    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cpf;

    public ClienteBeneficiario convertToModel(){
        return new ClienteBeneficiario(null, this.nome, this.email, this.senha, this.endereco, this.cpf);
    }
}
