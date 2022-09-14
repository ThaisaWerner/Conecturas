package com.tw.spring.service;
import com.tw.spring.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;
    private PedidoService service;

    @BeforeEach
    void setUp() {
        service = new PedidoService(repository);
    }

}