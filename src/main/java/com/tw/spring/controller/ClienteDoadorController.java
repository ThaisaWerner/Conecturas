package com.tw.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
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
import com.tw.spring.repository.ClienteDoadorRepository;
import com.tw.spring.service.ClienteDoadorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/doador")

public class ClienteDoadorController {
	
	private final ClienteDoadorService serviceDoador;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteDoadorResponse>> listar(){
		return ResponseEntity.ok(serviceDoador.listar());
	}
	
	@GetMapping("/id/{id}")
	public ClienteDoador buscarPorId(@PathVariable Long Id){
		return ClienteDoadorService.buscarPorIdOuFalhar(Id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Optional<ClienteDoador>> logar(@RequestBody ClienteDoadorRequest requestDoador, String email){
		return ResponseEntity.ok(serviceDoador.autenticarDoadorOuFalhar(email));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<ClienteDoadorResponse> salvar (@RequestBody ClienteDoadorRequest requestDoador){
		return ResponseEntity.ok(serviceDoador.salvar(requestDoador));
	}
		
	@DeleteMapping("/doador/deletar")
	public void deletar() {
		System.out.println("deletado");
	}
	
	@PutMapping("/doador/atualizar")
	public void atualizar() {
		System.out.println("atualizado");
	}
}