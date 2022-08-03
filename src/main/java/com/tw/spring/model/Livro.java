package com.tw.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Builder
@Table(name = "Livros")
@SequenceGenerator(name="seq_livros",sequenceName = "seq_livros",allocationSize = 1,initialValue = 1)
public class Livro implements Serializable {

				
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_livros")
	private Long id;
	
	private String titulo;
	
	private String generoLiterario;
	
	private String descricao;
	
	private double preco;
	
	private String autor;
	
	private int classificacaoEtaria;

	public Livro()	{
		
	}
}
