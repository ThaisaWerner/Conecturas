package com.tw.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Pedido")
@SequenceGenerator(name="seq_pedidos",sequenceName = "seq_pedidos",allocationSize = 1,initialValue = 1)
public class Pedido implements Serializable {

	 
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pedidos")
	private Long id;
	
	private Integer total;
			
	private String descricao;
	 
    private Date hora;
    
    private String formaPagamento;
	
    
    private Long idClienteDoador;
    
    private Long idClienteBeneficiario;
			
}
