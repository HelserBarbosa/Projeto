package com.projeto.negocios.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.negocios.exception.NenhumaPizzaException;
import com.projeto.negocios.exception.PizzaInvalidaException;
import com.projeto.negocios.models.Pizza;
import com.projeto.negocios.repository.PizzaRepository;

public class PizzaService {

	@Autowired
	PizzaRepository pr;

	/**
	 * 
	 * metodo para chamar um metodo do repositorio que salva uma pizza no banco de
	 * dacos
	 * 
	 * @param pizza
	 * @throws PizzaInvalidaException
	 * 
	 */

	public void addPizza(Pizza pizza) throws PizzaInvalidaException {

		if (pr.existsByName(pizza.getNome())) {
			throw new PizzaInvalidaException();
		} else {
			pr.save(pizza);
		}
	}

	/**
	 * metodo que chamar um buscador de todas as pizzas
	 * 
	 * @param
	 * @throws NenhumaPizzaException
	 * @return pizzas
	 */
	public Iterable<Pizza> listPizza() throws NenhumaPizzaException {

		Iterable<Pizza> pizzas;
		if (pr.findAll() == null) {
			throw new NenhumaPizzaException();
		} else {
			pizzas = pr.findAll();
		}
		return pizzas;
	}

	/**
	 * Metodo que chama um buscador de pizza por nome
	 * 
	 * @param nome
	 * @throws PizzaInvalidaException
	 * @return pizza
	 * 
	 */
	public Pizza getPizza(String nome) throws PizzaInvalidaException {

		Pizza pizza;
		if (!pr.existsByName(nome)) {
			throw new PizzaInvalidaException();
		} else {
			pizza = pr.findByName(nome);
		}
		return pizza;
	}

	/**
	 * Chama um meotodo para deletar por nome
	 * @param nome
	 * @throws PizzaInvalidaException
	 * 
	 * 
	 */
	public void deletePizza(String nome) throws PizzaInvalidaException {
		
		if (!pr.existsByName(nome)) {
			throw new PizzaInvalidaException();
		} else {
			pr.deleteByName(nome);
		}
	}

}
