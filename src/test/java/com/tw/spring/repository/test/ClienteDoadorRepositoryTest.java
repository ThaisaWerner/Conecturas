package com.tw.spring.repository.test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.tw.spring.controller.doador.ClienteDoadorController;
import com.tw.spring.controller.doador.ClienteDoadorRequest;
import com.tw.spring.controller.doador.ClienteDoadorResponse;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;
import com.tw.spring.service.ClienteDoadorService;

@ExtendWith(MockitoExtension.class)
class ClienteDoadorRepositoryTest {
	
	private ClienteDoadorRepository repositoryDoador;
	@Mock
	private ClienteDoadorService serviceDoador;
	
	@Mock
	private ClienteDoadorController controllerDoador;

	@BeforeEach
	void setUp() {
		serviceDoador = new ClienteDoadorService(repositoryDoador);
	}
	
	@Test
	void testBuscarPorIdOuFalhar() {
		
		ClienteDoadorRequest requestDoador = new ClienteDoadorRequest("Jade", "jade@gmail.com", 
				"1234", "089.190.109-43");
		
		when(serviceDoador.salvar(any(ClienteDoadorRequest.class)))
		.thenReturn(new ClienteDoadorResponse(1L, "Jade", "jade@gmail.com", "1234", "089.190.109-43"));
		
		ClienteDoador doadorCadastrado = new ClienteDoador(1L, "Jade", "jade@gmail.com", 
				"1234", "089.190.109-43", emptyList());

		when(repositoryDoador.save(any(ClienteDoador.class))).thenReturn(doadorCadastrado);
		
		
		ClienteDoadorResponse doadorSalvo = serviceDoador.salvar(requestDoador);
						
		assertThat(doadorSalvo.getId()).isEqualTo(1L);
		verify(repositoryDoador).findById(212L);
	}

}
