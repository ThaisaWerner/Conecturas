package com.tw.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tw.spring.model.ItemVenda;
import com.tw.spring.model.Livro;



@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{
	
	
	

}
