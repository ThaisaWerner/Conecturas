package com.tw.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.tw.spring.controller.pedido.PedidoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.stream.Collectors.toList;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@NamedEntityGraph(name = "Pedido.livros",
        attributeNodes = @NamedAttributeNode("livros"))
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1, initialValue = 1)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
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

    @ManyToMany
    @JoinTable(name = "item_pedido",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_livro"))
    private List<Livro> livros;

    @Column
    private String status;

    public PedidoResponse convertToResponse() {
        return PedidoResponse.builder()
                .numeroDoPedido(this.id)
                .nomeDoBeneficiario(this.clienteBeneficiario.getNome())
                .livros(this.getLivros().stream().map(Livro::getTitulo).collect(toList()))
                .build();
    }
}
