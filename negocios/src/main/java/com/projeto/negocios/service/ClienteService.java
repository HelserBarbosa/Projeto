package com.projeto.negocios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.negocios.exception.ClienteExistenteException;
import com.projeto.negocios.exception.NenhumClienteCadastradoException;
import com.projeto.negocios.exception.NomeInvalidoException;
import com.projeto.negocios.models.Cliente;
import com.projeto.negocios.repository.ClienteRepository;

/**
 * Classe de neogicos do obejto Cliente
 * 
 * @author HelderBarbosa
 * 
 */

@Service
public class ClienteService {
	@Autowired
	ClienteRepository cr;

	/**
	 * metodo para adicionar novos clientes no banco de dados
	 * 
	 * @throws ClienteExistenteException
	 */
	public void addCliente(Cliente cliente) throws ClienteExistenteException {

		if (cr.existsByName(cliente.getNome())) {
			throw new ClienteExistenteException();
		} else {
			cr.save(cliente);
		}
	}

	/**
	 * metodo de busca de todos os clientes cadastrados
	 * 
	 * @return cleintes
	 * @throws NenhumClienteCadastradoException
	 */
	public Iterable<Cliente> listCliente() throws NenhumClienteCadastradoException {

		if (cr.findAll() == null) {
			throw new NenhumClienteCadastradoException();
		} else {
			Iterable<Cliente> clientes = cr.findAll();
			return clientes;
		}
	}

	/**
	 * metodo que retorna um cliente pelo nome
	 * 
	 * @param nome
	 * @throws NomeInvalidoException
	 * @return cliente
	 */
	public Cliente getCliente(String nome) throws NomeInvalidoException {
		Cliente cliente;
		if (cr.findByName(nome) == null) {
			throw new NomeInvalidoException();
		} else {
			cliente = cr.findByName(nome);
		}
		return cliente;
	}
	/**
	 * metodo que deleta um cliente pelo nome
	 * 
	 * @param nome
	 * @throws NomeInvalidoException
	 * @return cliente
	 */
	public void deleteCliente(String nome) throws NomeInvalidoException {
		Cliente cliente;
		if (cr.findByName(nome) == null) {
			throw new NomeInvalidoException();
		} else {
			cr.deleteByName(nome);
		}

	}
}
