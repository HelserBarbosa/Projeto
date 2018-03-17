package com.projeto.negocios.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping(value = "/novopedido")
	public ResponseEntity<Pedido> addPedido(Pedido pedido) throws PedidoInvalidoException, NomeInvalidoException 
	{	Cliente cliente = cc.getClient(pedido.getNome());
		pedido.setCliente(cliente);
		cliente.setPedidos(pedido);
		ps.addPedido(pedido);
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscapedido/{data}")
	public ResponseEntity<ArrayList<Pedido>> listaPedidoData(@PathVariable("data") String data) throws NenhumPedidoException 
	{
		return new ResponseEntity<ArrayList<Pedido>>((ArrayList)ps.listaPedidoData(data),HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscapedido/{numero}")
	public ResponseEntity<Pedido> getPedido(@PathVariable("numero") String numero) throws NenhumPedidoException 
	{
		return new ResponseEntity<Pedido>(ps.getPedido(numero),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/buscapedido/{numero}")
	public ResponseEntity<Pedido> deletePedido(@PathVariable("numero") String numero) throws NenhumPedidoException 
	{
		return new ResponseEntity<Pedido>(ps.deletePedido(numero),HttpStatus.OK);
	}
	@GetMapping(value = "/buscapedido/{nome}")
	public ResponseEntity<ArrayList<Pedido>> listPedidoNome(@PathVariable("nome")String nome) throws PedidoInvalidoException
	{
		return new ResponseEntity<ArrayList<Pedido>>((ArrayList)ps.listPedidoNome(nome),HttpStatus.OK);
	}
	public ArrayList<Pedido> ListaPedidoName(String nome) throws PedidoInvalidoException
	{
		return (ArrayList<Pedido>)ps.listPedidoNome(nome);
	}

}
