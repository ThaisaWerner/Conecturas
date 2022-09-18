package com.tw.spring.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.tw.spring.controller.doador.ClienteDoadorController;
import com.tw.spring.controller.doador.ClienteDoadorRequest;
import com.tw.spring.controller.doador.ClienteDoadorResponse;
import com.tw.spring.service.ClienteDoadorService;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
public class ClienteDoadorControllerTest {
	
	private ClienteDoadorController controllerDoador;
	
	@Mock
	private ClienteDoadorService serviceDoador;
	
	@BeforeEach
	void setUp() {
		controllerDoador = new ClienteDoadorController(serviceDoador);
	}
	
	@Test
	void shoulSaveClienteDoador() {
		ClienteDoadorRequest requestDoador = new ClienteDoadorRequest("Jade", "jade@gmail.com", 
				"1234", "089.190.109-43");
		
		when(serviceDoador.salvar(any(ClienteDoadorRequest.class)))
				.thenReturn(new ClienteDoadorResponse(1L, "Jade", "jade@gmail.com", "1234", "089.190.109-43"));
		
		ResponseEntity<ClienteDoadorResponse> doadorSalvo = controllerDoador.salvar(requestDoador);
		ResponseEntity<ClienteDoadorResponse> doadorEsperado = new ResponseEntity<>
							(new ClienteDoadorResponse(1L, "Jade", "jade@gmail.com", "1234", "089.190.109-43"), OK);
		
		assertThat(doadorSalvo).isEqualTo(doadorEsperado);
		verify(serviceDoador).salvar(requestDoador);
	}

}
