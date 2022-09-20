package com.tw.spring.controller.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

    private String descricao;

    private Long idBeneficiario;

    private List<Long> idLivros;
}
