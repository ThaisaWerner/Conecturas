package com.tw.spring.repository;

import com.tw.spring.config.MySqlContainerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PedidoRepositoryIntegrationTest extends MySqlContainerTest {

    @Autowired
    private PedidoRepository repository;

    @Test
    void shouldCreateNewPedido() {

    }
}
