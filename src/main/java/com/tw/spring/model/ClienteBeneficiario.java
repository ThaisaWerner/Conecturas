package com.tw.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tw.spring.controller.beneficiario.ClienteBeneficiarioResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_beneficiario")
@SequenceGenerator(name="seq_cliente_beneficiario",sequenceName = "seq_cliente_beneficiario",allocationSize = 1,initialValue = 1)
public class ClienteBeneficiario {
		
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente_beneficiario")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String  nome;
	
	@Column(name = "email", nullable = false, unique = true)
	private String  email;
	
	@Column(name = "senha", nullable = false)
	private String  senha;
	
	@Column(name = "endereco", nullable = false)
	private String  endereco;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String  cpf;

	@OneToMany(mappedBy = "clienteBeneficiario")
	private List<Pedido> pedidos;

	public ClienteBeneficiarioResponse convertToResponse(){
		return ClienteBeneficiarioResponse.builder()
				.id(this.id)
				.nome(this.nome)
				.email(this.email)
				.endereco(this.endereco)
				.build();
	}

}
