package com.tw.spring.controller;

import com.tw.spring.service.ClienteBeneficiarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteBeneficiarioController {

    private final ClienteBeneficiarioService service = new ClienteBeneficiarioService();

    @GetMapping("/beneficiario/listar")
    public ResponseEntity<List<ClienteBeneficiarioResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/beneficiario/salvar")
    public ResponseEntity<ClienteBeneficiarioResponse> salvar(@RequestBody ClienteBeneficiarioRequest request){
        return ResponseEntity.ok(service.salvar(request));
    }

    @DeleteMapping("/beneficiario/deletar")
    public void deletar(){
        System.out.println("deletou");
    }

    @PutMapping("/beneficiario/atualizar")
    public void atualizar(){
        System.out.println("editado");
    }
}
