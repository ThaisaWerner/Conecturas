package com.tw.spring.repository;

import com.tw.spring.model.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.*;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Override
    @EntityGraph(value = "Pedido.livros", type = FETCH)
    Optional<Pedido> findById(Long id);
}
