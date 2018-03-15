package com.projeto.negocios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.negocios.exception.ClienteExistenteException;
import com.projeto.negocios.exception.NenhumClienteCadastradoException;
import com.projeto.negocios.exception.NomeInvalidoException;
import com.projeto.negocios.exception.PedidoInvalidoException;
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

	@RequestMapping(value = "/novocadastro", method = RequestMethod.POST)
	public String addCliente(Cliente cliente) throws ClienteExistenteException {
		cs.addCliente(cliente);
		return "redirect:/novocadastro";
	}

	@RequestMapping(value = "/listaclientes", method = RequestMethod.GET)
	public Iterable<Cliente> listClientes() throws NenhumClienteCadastradoException {

		return cs.listCliente();
	}
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public Cliente getCliente(@PathVariable("nome") String nome) throws NomeInvalidoException 
	{
		return cs.getCliente(nome);
	}
	@RequestMapping(value = "/{nome}deletado", method = RequestMethod.DELETE)
	public String deleteCliente(@PathVariable("nome") String nome) throws NomeInvalidoException 
	{
		cs.deleteCliente(nome);
		return "/{nome}deletado";
	}
	
	public Iterable<Pedido> listPedido(Cliente cliente) throws PedidoInvalidoException
	{
		return pc.listPedidoNome(cliente.getNome());
	}
}
