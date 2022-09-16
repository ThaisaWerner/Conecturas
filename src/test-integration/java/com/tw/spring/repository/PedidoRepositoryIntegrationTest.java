package com.tw.spring.repository;

import com.tw.spring.config.MySqlContainerTest;
import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.model.Livro;
import com.tw.spring.model.Pedido;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class PedidoRepositoryIntegrationTest extends MySqlContainerTest {

    private static final Date DATA_DO_PEDIDO = new Date();

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private ClienteBeneficiarioRepository clienteBeneficiarioRepository;

    private ClienteBeneficiario beneficiarioSalvo;
    private Livro livroSalvo;

    @BeforeEach
    void setUp() {
        Livro livroASerSalvo = new Livro(null, "Clean Code", "Programação",
                "xxxxx", 90.99, "Autor", 13, emptyList());

        ClienteBeneficiario beneficiarioASerSalvo = new ClienteBeneficiario(null, "Claudia",
                "claudia@gamil.com", "xxxx", "Rua 2", "22222222222", emptyList());

        livroSalvo = livrosRepository.save(livroASerSalvo);
        beneficiarioSalvo = clienteBeneficiarioRepository.save(beneficiarioASerSalvo);
    }

    @Test
    void shouldCreateNewPedido() {
        Pedido pedidoASerSalvo = new Pedido(null, "pedido de livroASerSalvo x", DATA_DO_PEDIDO,
                null, beneficiarioSalvo, of(livroSalvo), "solicitado");

        Pedido pedidoSalvo = pedidoRepository.save(pedidoASerSalvo);

        assertThat(pedidoSalvo.getId()).isNotNull();
    }

    @Test
    void shouldRemovePedido() {
        Pedido pedidoASerSalvo = new Pedido(null, "pedido de livroASerSalvo x", DATA_DO_PEDIDO,
                null, beneficiarioSalvo, of(livroSalvo), "solicitado");

        Pedido pedidoSalvo = pedidoRepository.save(pedidoASerSalvo);

        pedidoRepository.delete(pedidoSalvo);

        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(pedidoSalvo.getId());
        assertThat(pedidoEncontrado).isNotPresent();
    }

    @AfterEach
    void tearDown() {
        pedidoRepository.deleteAll();
        livrosRepository.deleteAll();
        clienteBeneficiarioRepository.deleteAll();
    }
}
