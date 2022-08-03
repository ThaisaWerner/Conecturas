package com.tw.spring.service;

import com.tw.spring.controller.ClienteDoadorRequest;
import com.tw.spring.controller.ClienteDoadorResponse;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteDoadorService {
	private ClienteDoadorRepository doadorRepository = null;
	
		public List<ClienteDoadorResponse> listar(){
		List<ClienteDoador> doadores = doadorRepository.findAll();
		return doadores.stream()
				.map(ClienteDoador::convertToResponse)
				.collect(Collectors.toList());
	}
	
	public ClienteDoadorResponse salvar (ClienteDoadorRequest requestDoador) {
		ClienteDoador doadorSalvo = doadorRepository.saveAndFlush(requestDoador.convertToModel());
		return doadorSalvo.convertToResponse();
	}
	
	public ClienteDoadorResponse atualizar (ClienteDoadorRequest requestDoador) {
		ClienteDoador doadorAtualizado = doadorRepository.saveAndFlush(requestDoador.convertToModel());
		return doadorAtualizado.convertToResponse();
	}
}
