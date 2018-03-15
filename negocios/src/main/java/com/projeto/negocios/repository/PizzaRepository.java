package com.projeto.negocios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.negocios.models.Pizza;
@Repository
public interface PizzaRepository extends CrudRepository<Pizza,String> {
	boolean existsByName(String nome);
	Pizza findByName(String nome);
	void deleteByName(String nome);

}
