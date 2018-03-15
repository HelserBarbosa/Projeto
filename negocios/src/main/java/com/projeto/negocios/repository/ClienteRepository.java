package com.projeto.negocios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.negocios.models.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
	Cliente findByName(String nome);
	void deleteByName(String nome);
	boolean existsByName(String nome);

}
