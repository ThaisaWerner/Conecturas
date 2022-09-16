package com.tw.spring.controller.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoUpdateRequest {

    private String status;
    private Long idClienteDoador;
}
