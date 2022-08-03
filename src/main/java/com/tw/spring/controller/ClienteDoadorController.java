package com.tw.spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.spring.service.ClienteDoadorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class ClienteDoadorController {
	
	private final ClienteDoadorService serviceDoador = new ClienteDoadorService();
	
	@GetMapping("/doador/listar")
	public ResponseEntity<List<ClienteDoadorResponse>> listar(){
		return ResponseEntity.ok(serviceDoador.listar());
	}
	
	@PostMapping("/doador/salvar")
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