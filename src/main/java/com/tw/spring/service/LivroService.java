package com.tw.spring.service;

import java.util.List;

import com.tw.spring.controller.livro.LivroResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.tw.spring.controller.livro.LivroRequest;
import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.Livro;
import com.tw.spring.repository.LivrosRepository;

import lombok.AllArgsConstructor;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
@AllArgsConstructor
public class LivroService {
    private final LivrosRepository livrosRepository;

    public LivroResponse salvar(LivroRequest livroRequest) {
        Livro livroSalvo = livrosRepository.save(livroRequest.converterParModel());
        return livroSalvo.converterParaResponse();
    }

    public List<LivroResponse> buscarTodos() {
        return livrosRepository.findAll().stream()
                .map(Livro::converterParaResponse)
                .collect(toList());
    }

    public LivroResponse buscarPorId(Long id) {
        return buscarPorIdOuFalhar(id)
                .converterParaResponse();
    }

    public LivroResponse atualizarLivro(Long id, LivroRequest livroRequest) {
        Livro livro = buscarPorIdOuFalhar(id);

        BeanUtils.copyProperties(livroRequest, livro, "id");

        Livro livroAtualizado = livrosRepository.save(livro);

        return livroAtualizado.converterParaResponse();
    }


    public void deletar(Long id) {
        Livro livro = buscarPorIdOuFalhar(id);
        livrosRepository.deleteById(livro.getId());
    }

    private Livro buscarPorIdOuFalhar(Long id) {
        return livrosRepository.findById(id)
                .orElseThrow(() -> new DefaultException(BAD_REQUEST, "id nao encontrado"));
    }
}




