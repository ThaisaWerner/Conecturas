package com.tw.spring.service;

import com.tw.spring.controller.doador.ClienteDoadorRequest;
import com.tw.spring.controller.doador.ClienteDoadorResponse;
import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.model.ClienteDoador;
import com.tw.spring.repository.ClienteDoadorRepository;
import lombok.AllArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public ClienteDoadorResponse salvar (ClienteDoadorRequest requestDoador) {
		ClienteDoador doadorSalvo = doadorRepository.saveAndFlush(requestDoador.convertToModel());
		return doadorSalvo.convertToResponse();
	}
	
	public List<ClienteDoadorResponse> listar(){
		List<ClienteDoador> doadores = doadorRepository.findAll();
		return doadores.stream()
				.map(ClienteDoador::convertToResponse)
				.collect(Collectors.toList());
	}
	
	public ClienteDoadorResponse atualizar (Long id, ClienteDoadorRequest requestDoador) {
		ClienteDoadorResponse atualizarDoador = buscarPorIdOuFalhar(id);
		ClienteDoador doadorAtualizado = requestDoador.convertToModel();
		doadorAtualizado.setId(atualizarDoador.getId());
		return doadorRepository.saveAndFlush(doadorAtualizado).convertToResponse();
		
	}
	
	public ClienteDoadorResponse buscarPorIdOuFalhar(Long id) {
        Optional<ClienteDoador> doador = doadorRepository.findById(id);
        return doador
                .orElseThrow(() -> new DefaultException(HttpStatus.NOT_FOUND, "Usuário não encontrado."))
                .convertToResponse();
	}

	
	public void deletarPorId(Long id) {
		  try {
	            doadorRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            throw new DefaultException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
	     }
		
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
