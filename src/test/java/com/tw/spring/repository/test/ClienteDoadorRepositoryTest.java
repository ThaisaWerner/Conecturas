package com.tw.spring.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;

@SpringBootTest
class ClienteDoadorRepositoryTest {
	
	@Autowired
	private ClienteDoadorRepository repositoryDoador;
	
	@Test
	void testFindById() {
		
		ClienteDoador clienteDoador = new ClienteDoador(212L, "Jade",
				"jade@gmail.com", "1234", "089.190.109-43");
		repositoryDoador.save(clienteDoador);
		
		Optional<ClienteDoador> actualResult = repositoryDoador.findById(212L);
				
		assertThat(actualResult.getId).isEqualTo(212L);
	}

}
