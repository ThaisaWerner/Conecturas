package com.tw.spring.controller.livro;

import java.util.List;

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

import com.tw.spring.service.LivroService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "livro")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponse> salvar(@RequestBody @Valid LivroRequest livroRequest) {
        LivroResponse response = livroService.salvar(livroRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> buscarTodos() {
        List<LivroResponse> livros = livroService.buscarTodos();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable Long id) {
        LivroResponse response = livroService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<LivroResponse> atualizarlivro(@PathVariable Long id, @RequestBody @Valid LivroRequest livroRequest) {
        LivroResponse response = livroService.atualizarLivro(id, livroRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
