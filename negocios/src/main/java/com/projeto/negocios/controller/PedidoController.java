package com.projeto.negocios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.negocios.exception.NenhumPedidoException;
import com.projeto.negocios.exception.NomeInvalidoException;
import com.projeto.negocios.exception.PedidoInvalidoException;
import com.projeto.negocios.models.Cliente;
import com.projeto.negocios.models.Pedido;
import com.projeto.negocios.service.PedidoService;
/**
 * Classe Responsavel por controlar as operações do objeto Pedido
 * */
@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoService ps;
	
	ClienteController cc;
	
	@RequestMapping(value = "/novopedido",method = RequestMethod.POST)
	public String addPedido(Pedido pedido) throws PedidoInvalidoException, NomeInvalidoException 
	{	Cliente cliente = cc.getCliente(pedido.getNome());
		pedido.setCliente(cliente);
		ps.addPedido(pedido);
		return "/novopedido";
	}
	
	@RequestMapping(value = "/buscapedido/{data}",method = RequestMethod.GET)
	public Iterable<Pedido> listaPedidoData(@PathVariable("data") String data) throws NenhumPedidoException 
	{
		return ps.listaPedidoData(data);
	}
	
	@RequestMapping(value = "/buscapedido/{numero}",method = RequestMethod.GET)
	public Pedido getPedido(@PathVariable("numero") String numero) throws NenhumPedidoException 
	{
		return ps.getPedido(numero);
	}
	
	@RequestMapping(value = "/buscapedido/{numero}",method = RequestMethod.DELETE)
	public String deletePedido(@PathVariable("numero") String numero) 
	{
		return "/pedido";
	}
	@RequestMapping(value = "/buscapedido/{nome}")
	public Iterable<Pedido> listPedidoNome(@PathVariable("nome")String nome) throws PedidoInvalidoException
	{
		return ps.listPedidoNome(nome);
	}

}
