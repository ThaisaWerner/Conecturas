package com.tw.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@SequenceGenerator(name = "seq_pedidos", sequenceName = "seq_pedidos", allocationSize = 1, initialValue = 1)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidos")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    @ManyToOne
    @JoinColumn(name = "id_clienteDoador")
    private ClienteDoador clienteDoador;

    @ManyToOne
    @JoinColumn(name = "id_clienteBeneficiario")
    private ClienteBeneficiario clienteBeneficiario;

}
