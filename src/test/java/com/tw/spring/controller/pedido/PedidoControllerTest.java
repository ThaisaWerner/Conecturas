package com.tw.spring.controller.pedido;

import com.tw.spring.controller.pedido.PedidoController;
import com.tw.spring.controller.pedido.PedidoRequest;
import com.tw.spring.controller.pedido.PedidoResponse;
import com.tw.spring.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    private PedidoController controller;
    @Mock
    private PedidoService service;

    @BeforeEach
    void setUp() {
        controller = new PedidoController(service);
    }

    @Test
    void shouldSavePedido() {
        PedidoRequest request = new PedidoRequest("descricao", 1L, singletonList(2L));

        when(service.criarPedido(any(PedidoRequest.class))).thenReturn(new PedidoResponse("João", List.of("A Casa do Dragão"), 3L));

        ResponseEntity<PedidoResponse> pedidoSalvo = controller.solicitar(request);
        ResponseEntity<PedidoResponse> pedidoEsperado = new ResponseEntity<>(new PedidoResponse("João", List.of("A Casa do Dragão"),3L), OK);

        assertThat(pedidoSalvo).isEqualTo(pedidoEsperado);
        verify(service).criarPedido(request);
    }

    @Test
    void shouldRemovePedido() {
        doNothing().when(service).excluirPedido(anyLong());

        ResponseEntity<?> respostaAtual = controller.excluir(1L);
        ResponseEntity<?> respostaEsperada = ResponseEntity.noContent().build();

        assertThat(respostaAtual).isEqualTo(respostaEsperada);
        verify(service).excluirPedido(1L);
    }
}