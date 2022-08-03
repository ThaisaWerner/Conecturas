package com.tw.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tw.spring.controller.ClienteDoadorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente_Doador")
@SequenceGenerator(name="seq_cliente_doador",sequenceName = "seq_cliente_doador",allocationSize = 1,initialValue = 1)
public class ClienteDoador implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente_doador")
	private Long id;
	private String  nome;
	private String  email;
	private String  senha;
	private String  cpf;
	
	public ClienteDoador(Object object, String nome2, String email2, String senha2, String cpf2) {
	
	}

	public ClienteDoadorResponse convertToResponse() {
		return ClienteDoadorResponse.builder()
				.id(this.id)
				.nome(this.nome)
				.email(this.email)
				.senha(this.senha)
				.cpf(this.cpf)
				.build();
	}

	}
