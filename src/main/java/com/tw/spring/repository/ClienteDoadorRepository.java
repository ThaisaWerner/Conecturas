package com.tw.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tw.spring.model.ClienteDoador;

@Repository
public interface ClienteDoadorRepository extends JpaRepository<ClienteDoador, Long>{
	
	Optional<ClienteDoador> findByEmail(String email);
	
}
