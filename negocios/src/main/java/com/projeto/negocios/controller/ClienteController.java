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

import com.projeto.negocios.exception.ClienteExistenteException;
import com.projeto.negocios.exception.NenhumClienteCadastradoException;
import com.projeto.negocios.exception.NomeInvalidoException;
import com.projeto.negocios.exception.PedidoInvalidoException;
import com.projeto.negocios.exception.QuantidadeDeDigitosException;
import com.projeto.negocios.models.Cliente;
import com.projeto.negocios.models.Pedido;
import com.projeto.negocios.service.ClienteService;

/**
 * Classe de controle de cliente
 * 
 * @author HelderBarbosa
 * 
 */

@Controller
public class ClienteController {

	@Autowired
	ClienteService cs;
	
	@Autowired
	PedidoController pc;

	@PostMapping(value = "/novocadastro")
	public ResponseEntity<Cliente> addCliente(Cliente cliente) throws ClienteExistenteException, QuantidadeDeDigitosException {
		cs.addCliente(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}

	@GetMapping(value = "/listaclientes")
	public ResponseEntity<ArrayList<Cliente>> listClientes() throws NenhumClienteCadastradoException {
		
		return new ResponseEntity<ArrayList<Cliente>>((ArrayList)cs.listCliente(),HttpStatus.OK);
	}
	@GetMapping(value = "/{nome}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("nome") String nome) throws NomeInvalidoException 
	{
		return new ResponseEntity<Cliente>(cs.getCliente(nome),HttpStatus.OK);
	}
	@DeleteMapping(value = "/{nome}deletado")
	public ResponseEntity<String> deleteCliente(@PathVariable("nome") String nome) throws NomeInvalidoException 
	{
		cs.deleteCliente(nome);
		return new ResponseEntity<String>(nome,HttpStatus.OK);
	}
	
	public ArrayList<Pedido> listPedido(Cliente cliente) throws PedidoInvalidoException
	{
		return pc.ListaPedidoName(cliente.getNome());
	}
	
	public Cliente getClient(String nome) throws NomeInvalidoException 
	{
		return cs.getCliente(nome);
	}
}
