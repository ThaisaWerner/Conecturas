package com.tw.spring.repository;

import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
