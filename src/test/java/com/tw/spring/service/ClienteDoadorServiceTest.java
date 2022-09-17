package com.tw.spring.service;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tw.spring.controller.doador.ClienteDoadorRequest;
import com.tw.spring.controller.doador.ClienteDoadorResponse;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;

@ExtendWith(MockitoExtension.class)
class ClienteDoadorServiceTest {
	
	@Mock
	private ClienteDoadorRepository doadorRepository;
	private ClienteDoadorService serviceDoador;

	@BeforeEach
	void setUp() {
		serviceDoador = new ClienteDoadorService(doadorRepository);
	}
	
	@Test
	void testSalvarClienteDoador() {
		
		//ClienteDoador doador = new ClienteDoador(null, "Jade", "jade@gmail.com", 
			//	"1234", "089.190.109-43");
		
		ClienteDoador doadorSalvo = new ClienteDoador(1L, "Jade", "jade@gmail.com", 
				"1234", "089.190.109-43", emptyList());

		when(doadorRepository.save(any(ClienteDoador.class))).thenReturn(doadorSalvo);
		
		ClienteDoadorRequest requestDoador = new ClienteDoadorRequest("Jade", "jade@gmail.com", 
				"1234", "089.190.109-43");
		
		ClienteDoadorResponse doadorCadastrado = serviceDoador.salvar(requestDoador);
		ClienteDoadorResponse doadorEsperado = new ClienteDoadorResponse(1L, "Jade",
				"jade@gmail.com", "1234", "089.190.109-43");
		
		assertThat(doadorCadastrado).isEqualTo(doadorEsperado);
		verify(doadorRepository).save(any(ClienteDoador.class));
	}
	
	/*@Test
	void testListar() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarPorIdOuFalhar() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletarPorId() {
		fail("Not yet implemented");
	}

	@Test
	void testAutenticarDoadorOuFalhar() {
		fail("Not yet implemented");
	}

	@Test
	void testClienteDoadorService() {
		fail("Not yet implemented");
	}*/

}
