package com.tw.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Table(name = "Pedido")
@Data
@SequenceGenerator(name="seq_pedidos",sequenceName = "seq_pedidos",allocationSize = 1,initialValue = 1)
public class Pedido implements Serializable {

	 
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pedidos")
	private Long id;
	
	@Column(name = "total")
	private Integer total;
			
	@Column(name = "descricao")
	private String descricao;
	 
	@Column(name = "hora")
	private Date hora;
    
	@Column(name = "formaPagamento")
    private String formaPagamento;
	
	@OneToOne
	@JoinColumn(name = "id_clienteDoador")
	private ClienteDoador clienteDoador;
	
	@OneToOne
	@JoinColumn(name = "id_clienteBeneficiario")
	private ClienteBeneficiario clienteBeneficiario;
	
   // private Long idClienteDoador; //
    
   // private Long idClienteBeneficiario;//
	
	
			
}
