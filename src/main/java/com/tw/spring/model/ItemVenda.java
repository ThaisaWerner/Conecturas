package com.tw.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_itemvenda")
	private Long id;
	
	private Long idLivro ;
	private Long idPedido ;
	
 

	

}
