package com.tw.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "ItemVenda")
@SequenceGenerator(name="seq_itemvenda",sequenceName = "seq_itemvenda",allocationSize = 1,initialValue = 1)
public class ItemVenda implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_itemvenda")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;
	
	//private Long idLivro ; //
	//private Long idPedido ;//
	
 

	

}
