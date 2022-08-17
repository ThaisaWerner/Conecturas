package com.tw.spring.model;

import javax.persistence.*;

import com.tw.spring.controller.beneficiario.ClienteBeneficiarioResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente_Beneficiario")
@SequenceGenerator(name="seq_cliente_beneficiario",sequenceName = "seq_cliente_beneficiario",allocationSize = 1,initialValue = 1)
public class ClienteBeneficiario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente_beneficiario")
	private Long id;
	private String  nome;
	private String  email;
	private String  senha;
	private String  endereco;
	private String  cpf;

	public ClienteBeneficiarioResponse convertToResponse(){
		return ClienteBeneficiarioResponse.builder()
				.id(this.id)
				.nome(this.nome)
				.email(this.email)
				.endereco(this.endereco)
				.build();
	}

}
