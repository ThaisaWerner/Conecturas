package com.tw.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tw.spring.controller.ClienteBeneficiarioResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente_Beneficiario")
public class ClienteBeneficiario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String  nome;
	private String  email;
	private String  senha;
	private String  endereco;
	private String  cpf;

	public ClienteBeneficiario(Object object, String nome2, String email2, String senha2, String endereco2,
			String cpf2) {
		// TODO Auto-generated constructor stub
	}

	public ClienteBeneficiarioResponse convertToResponse(){
		return ClienteBeneficiarioResponse.builder()
				.id(this.id)
				.nome(this.nome)
				.email(this.email)
				.endereco(this.endereco)
				.build();
	}



}
