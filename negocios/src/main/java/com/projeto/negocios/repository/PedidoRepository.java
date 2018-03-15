package com.projeto.negocios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.negocios.models.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, String> {
	boolean existsByNumero(String numero);
	Pedido findByNumero(String numero);
	void deleteByNumero(String numero);
	Iterable<Pedido> findbyData(String data);
	Iterable<Pedido> findbyName(String nome);
}
