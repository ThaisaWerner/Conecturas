package com.tw.spring.controller.pedido;

import com.tw.spring.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoResponse {
    private String nomeDoBeneficiario;
    private List<String> livros;
    private Long numeroDoPedido;
}
