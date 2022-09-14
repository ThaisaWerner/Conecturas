package com.tw.spring.service;

import com.tw.spring.model.Pedido;
import com.tw.spring.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido salvar() {
        return null;
    }
}
