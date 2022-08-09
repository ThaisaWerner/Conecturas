package com.tw.spring.service;

import com.tw.spring.controller.ClienteDoadorRequest;
import com.tw.spring.controller.ClienteDoadorResponse;
import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
@Component
@AllArgsConstructor
public class ClienteDoadorService {
	private final ClienteDoadorRepository doadorRepository;
	
	
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
	
	public ClienteDoador buscarPorIdOuFalhar(Long Id){
		return doadorRepository.findById(Id)
				.orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Este usuário não existe"));
		
	}
	
	public Optional<ClienteDoador> autenticarDoadorOuFalhar(String email){
        var loginDoador = doadorRepository.findByEmail(email);

        //Rever aqui, tem que pedir a senha dai e salvar//
        if(loginDoador.isPresent()){
        	return doadorRepository.findByEmail(email);
        }else {
            throw new DefaultException(HttpStatus.BAD_REQUEST, "Este e-mail não está cadastrado");
        }
    }


	private void orElseThrow(DefaultException defaultException) {
		// TODO Auto-generated method stub
		
	}
}
