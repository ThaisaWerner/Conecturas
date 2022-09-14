package com.tw.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tw.spring.controller.doador.ClienteDoadorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_doador")
@SequenceGenerator(name="seq_cliente_doador",sequenceName = "seq_cliente_doador",allocationSize = 1,initialValue = 1)
public class ClienteDoador implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente_doador")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String  nome;
	
	@Column(name = "email", nullable = false, unique = true)
	private String  email;
	
	@Column(name = "senha", nullable = false)
	private String  senha;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String  cpf;

	@OneToMany(mappedBy = "clienteDoador")
	private List<Pedido> pedidos;

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
