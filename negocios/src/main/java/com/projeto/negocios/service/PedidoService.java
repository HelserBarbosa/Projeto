package com.projeto.negocios.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.negocios.exception.NenhumPedidoException;
import com.projeto.negocios.exception.PedidoInvalidoException;
import com.projeto.negocios.models.Pedido;
import com.projeto.negocios.repository.PedidoRepository;

public class PedidoService {

	@Autowired
	PedidoRepository pr;
	/**
	 * Chama o metodo do repository para salvar o pedido no banco
	 * 
	 * @param pedido
	 * @throws PedidoInvalidoException
	 * 
	 * 
	 * */
	public void addPedido(Pedido pedido) throws PedidoInvalidoException {

		if (pr.existsByNumero(pedido.getNumero())) {
			throw new PedidoInvalidoException();
		} else {
			pr.save(pedido);
		}
	}
/**
 * metodo para chamar um metodo que busca pela Data do pedido
 * @param data
 * @throws NenhumPedidoException
 * @return pedidos
 * */
	public Iterable<Pedido> listaPedidoData(String data) throws NenhumPedidoException {

		Iterable<Pedido> pedidos;
		if (pr.findAll() == null) {
			throw new NenhumPedidoException();
		} else {
			pedidos = pr.findbyData(data);
		}
		return pedidos;
	}
/**
 * Metodo para chamar o buscador de pedidos por numero
 * @param numero
 * @throws NenhumPedidoException
 * @return pedido
 * */
	public Pedido getPedido(String numero) throws NenhumPedidoException {
		
		Pedido pedido;
		if(!pr.existsByNumero(numero)) 
		{
			throw new NenhumPedidoException();
		}
		else 
		{
			pedido = pr.findByNumero(numero);
		}
		return pedido;
	}
	/**
	 * Metodo para chamar um metodo q deleta o pedido pelo numero
	 * @param numero
	 * @throws NenhumPedidoException
	 * */
	public void deletePedido(String numero) throws NenhumPedidoException 
	{
		if(!pr.existsByNumero(numero)) 
		{
			throw new NenhumPedidoException();
		}
		else 
		{
			pr.deleteByNumero(numero);
		}
		
	}
	
	public Iterable<Pedido> listPedidoNome(String nome) throws PedidoInvalidoException
	{	Iterable<Pedido> pedidos;
		if(pr.findbyName(nome) == null) 
		{
			throw new PedidoInvalidoException();
		}
		else 
		{
			pedidos = pr.findbyName(nome);
		}
		return pedidos;
	}

}
