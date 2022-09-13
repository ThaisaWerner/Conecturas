package com.tw.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.tw.spring.controller.doador.ClienteDoadorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_doador")
<<<<<<< HEAD
//, uniqueConstraints = {@UniqueConstraint(name = "UniqueCpf", columnNames = "cpf"), 
		//@UniqueConstraint(name = "UniqueEmail", columnNames = "email")})
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
@SequenceGenerator(name="seq_cliente_doador",sequenceName = "seq_cliente_doador",allocationSize = 1,initialValue = 1)
public class ClienteDoador implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente_doador")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String  nome;
	
<<<<<<< HEAD
	@Column(name = "email", nullable = false, unique = true)
=======
	@Column(name = "email", nullable = false)
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
	private String  email;
	
	@Column(name = "senha", nullable = false)
	private String  senha;
	
<<<<<<< HEAD
	@Column(name = "cpf", nullable = false, unique = true)
=======
	@Column(name = "cpf", nullable = false)
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
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
