package com.tw.spring.service;

import com.tw.spring.controller.ClienteBeneficiarioRequest;
import com.tw.spring.controller.ClienteBeneficiarioResponse;
import com.tw.spring.model.ClienteBeneficiario;
import com.tw.spring.repository.ClienteBeneficiarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteBeneficiarioService {

    private final ClienteBeneficiarioRepository repository;

    public ClienteBeneficiarioResponse salvar(ClienteBeneficiarioRequest request){
        ClienteBeneficiario beneficiarioSalvo = repository.saveAndFlush(request.convertToModel());
        return beneficiarioSalvo.convertToResponse();
    }

    public List<ClienteBeneficiarioResponse> listar(){
        List<ClienteBeneficiario> beneficiarios = repository.findAll();
        return beneficiarios.stream()
                .map(ClienteBeneficiario::convertToResponse)
                .collect(Collectors.toList());
    }

    public ClienteBeneficiarioResponse atualizar(ClienteBeneficiarioRequest request){
        ClienteBeneficiario beneficiarioAtualizado = repository.saveAndFlush(request.convertToModel());
        return beneficiarioAtualizado.convertToResponse();
    }
}
