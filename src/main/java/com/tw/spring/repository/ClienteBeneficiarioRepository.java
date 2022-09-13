package com.tw.spring.repository;

import com.tw.spring.model.ClienteBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteBeneficiarioRepository extends JpaRepository<ClienteBeneficiario, Long> {
}
