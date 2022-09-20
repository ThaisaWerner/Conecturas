package com.tw.spring.controller.pedido;

import com.tw.spring.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> solicitar(@RequestBody @Valid PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = service.criarPedido(pedidoRequest);
        return ResponseEntity.ok(pedidoResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscaPorId(@PathVariable Long id) {
        PedidoResponse pedidoResponse = service.buscaPorId(id);
        return ResponseEntity.ok(pedidoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoUpdateResponse> atualizar(@PathVariable Long id, @RequestBody PedidoUpdateRequest request) {
        PedidoUpdateResponse response = service.atualizarPedido(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }
}
