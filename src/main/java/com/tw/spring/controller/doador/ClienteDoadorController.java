package com.tw.spring.controller.doador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.spring.model.ClienteDoador;
import com.tw.spring.service.ClienteDoadorService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/doador")

public class ClienteDoadorController {
	
	private final ClienteDoadorService serviceDoador;
	
	@PostMapping("/salvar")
	public ResponseEntity<ClienteDoadorResponse> salvar (@RequestBody @Valid ClienteDoadorRequest requestDoador){
		return ResponseEntity.ok(serviceDoador.salvar(requestDoador));
	}
	
	@PostMapping("/login")
	public ResponseEntity<Optional<ClienteDoador>> logar(@RequestBody @Valid ClienteDoadorRequest requestDoador, String email){
		return ResponseEntity.ok(serviceDoador.autenticarDoadorOuFalhar(email));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteDoadorResponse>> listar(){
		return ResponseEntity.ok(serviceDoador.listar());
	}
	
	@GetMapping("/id/{id}")
    public ResponseEntity<ClienteDoadorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceDoador.buscarPorIdOuFalhar(id));
		 
	}
	
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDoadorResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDoadorRequest requestDoador){
      return ResponseEntity.ok(serviceDoador.atualizar(id, requestDoador));
    }
	
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        serviceDoador.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
    	
}