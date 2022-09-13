package com.tw.spring.controller.doador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974

import com.tw.spring.model.ClienteDoador;
import com.tw.spring.service.ClienteDoadorService;
import lombok.AllArgsConstructor;

<<<<<<< HEAD
@Controller
=======
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
@RestController
@AllArgsConstructor
@RequestMapping("/doador")

<<<<<<< HEAD
public class ClienteDoadorController implements WebMvcConfigurer {
=======
public class ClienteDoadorController {
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
	
	private final ClienteDoadorService serviceDoador;
	
	@PostMapping("/salvar")
<<<<<<< HEAD
	public ResponseEntity<ClienteDoadorResponse> salvar (@Valid @RequestBody ClienteDoadorRequest requestDoador){
=======
	public ResponseEntity<ClienteDoadorResponse> salvar (@RequestBody @Valid ClienteDoadorRequest requestDoador){
>>>>>>> 02db64a65df36bfbe59c0db6b636d5483eb09974
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