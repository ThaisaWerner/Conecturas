package com.tw.spring.controller;

 
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tw.spring.exception.DefaultException;
import com.tw.spring.model.Livro;
import com.tw.spring.repository.LivrosRepository;
import com.tw.spring.service.LivroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "salvar")
@AllArgsConstructor
public class LivroController {
 
	 private final LivroService livroService;
	 
	// private final LivrosRepository livrosRepository;
	 
	    @PostMapping
	    public Livro salvar(@RequestBody  @Valid LivroRequest livroRequest){
	    	
	          return livroService.salvar(livroRequest);
	    }
	    
	       
	    @GetMapping(value = "buscarTodos")
	     public List<Livro> buscarTodos(){
	    	 	       	
	    	return livroService.buscarTodos();
	          	    	
	      }
	    
	    
	       
	  @GetMapping(value = "buscarPorIdOuFalhar")
		     public Livro  buscarPorIdOuFalhar(Long id){
		    	 	       	
		    	return livroService.buscarPorIdOuFalhar(id);
		          	    	
		      }
		    
		
	    @PutMapping(path = "{id}")
	     public Livro atualizarlivro(@PathVariable Long id, @RequestBody @Valid LivroRequest livroRequest){
	    	 	       
	     	    	return livroService.atualizarLivro(id, livroRequest);
	          	    	
	      }
	
	  
	      
	    
	    
	    
	    @DeleteMapping(path= {"id"})
	    public void deletar(@PathVariable Long id){
	    	
	    	 livroService.deletar(id);
	    }
	    
	    
	    
	    
	

	    
	    
	    
	    

}
