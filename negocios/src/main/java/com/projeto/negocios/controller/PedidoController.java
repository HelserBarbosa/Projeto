package com.projeto.negocios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.negocios.exception.NenhumPedidoException;
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
	
	@RequestMapping(value = "/novopedido",method = RequestMethod.POST)
	public String addPedido(Pedido pedido) 
	{
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

}
