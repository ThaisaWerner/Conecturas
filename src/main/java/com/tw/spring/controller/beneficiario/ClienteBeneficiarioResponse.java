package com.tw.spring.controller.beneficiario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClienteBeneficiarioResponse {

    private Long id;
    private String  nome;
    private String  email;
    private String  endereco;
}
