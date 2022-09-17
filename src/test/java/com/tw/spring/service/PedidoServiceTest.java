package com.tw.spring.service;

import com.tw.spring.controller.pedido.PedidoRequest;
import com.tw.spring.controller.pedido.PedidoResponse;
import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.model.Livro;
import com.tw.spring.model.Pedido;
import com.tw.spring.repository.ClienteBeneficiarioRepository;
import com.tw.spring.repository.ClienteDoadorRepository;
import com.tw.spring.repository.LivrosRepository;
import com.tw.spring.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private LivrosRepository livroRepository;
    @Mock
    private ClienteDoadorRepository doadorRepository;
    @Mock
    private ClienteBeneficiarioRepository beneficiarioRepository;
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        pedidoService = new PedidoService(pedidoRepository, livroRepository, doadorRepository, beneficiarioRepository);
    }

    @Test
    void shouldSavePedido() {
        Date dataDoPedido = new Date();
        Livro livro = new Livro(333L, "Clean Code", "Programação",
                "xxxxx", 90.99, "Autor", 13, emptyList());

        ClienteBeneficiario beneficiario = new ClienteBeneficiario(1111L, "Claudia",
                "claudia@gamil.com", "xxxx", "Rua 2", "22222222222", emptyList());

        Pedido pedidoASerSalvo = new Pedido(null, "pedido de livro x", dataDoPedido,
                null, beneficiario, List.of(livro), "solicitado");
        Pedido pedidoSalvo = new Pedido(2222L, "pedido de livro x", dataDoPedido,
                null, beneficiario, List.of(livro), "solicitado");


        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoSalvo);
        when(beneficiarioRepository.findById(anyLong())).thenReturn(Optional.of(beneficiario));
        when(livroRepository.findAllById(anyList())).thenReturn(List.of(livro));


        PedidoRequest request = new PedidoRequest("pedido de livro x", 1111L, List.of(333L));

        PedidoResponse pedidoCriado = pedidoService.criarPedido(request);
        PedidoResponse pedidoEsperado = new PedidoResponse(2222L);

        assertThat(pedidoCriado).isEqualTo(pedidoEsperado);
        verify(beneficiarioRepository).findById(1111L);
        verify(livroRepository).findAllById(List.of(333L));
        verify(pedidoRepository).save(any(Pedido.class));
    }

    @Test
    void shouldRemovePedido() {
        Pedido pedidoSalvo = new Pedido(2222L, "pedido de livro x", null,
                null, null, null, "solicitado");

        when(pedidoRepository.findById(anyLong())).thenReturn(Optional.of(pedidoSalvo));

        pedidoService.excluirPedido(2222L);

        verify(pedidoRepository).delete(pedidoSalvo);
    }
    @Test
    void shouldThowDefaultExceptionWhenTryToRemoveNonExistentPedido() {
        when(pedidoRepository.findById(anyLong())).thenReturn(empty());

        assertThatThrownBy(() -> pedidoService.excluirPedido(2222L))
                .isInstanceOf(DefaultException.class)
                .hasMessageContaining("Pedido não encontrado");

        verify(pedidoRepository, never()).delete(any(Pedido.class));
    }
    @Test
    void shouldThowDefaultExceptionWhenTryToRemovePedidoWithStatusDifferentThanSolicitado() {
        Pedido pedidoSalvo = new Pedido(2222L, "pedido de livro x", null,
                null, null, null, "doado");

        when(pedidoRepository.findById(anyLong())).thenReturn(Optional.of(pedidoSalvo));

        assertThatThrownBy(() -> pedidoService.excluirPedido(2222L))
                .isInstanceOf(DefaultException.class)
                .hasMessageContaining("Pedido não pode ser excluido pois o status é diferente de solicitado");

        verify(pedidoRepository, never()).delete(any(Pedido.class));
    }
}