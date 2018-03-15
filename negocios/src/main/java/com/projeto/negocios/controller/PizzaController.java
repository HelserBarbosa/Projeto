package com.projeto.negocios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.negocios.exception.NenhumaPizzaException;
import com.projeto.negocios.exception.PizzaInvalidaException;
import com.projeto.negocios.models.Pizza;
import com.projeto.negocios.service.PizzaService;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaService ps;
	
	@RequestMapping(value = "/novapizza", method = RequestMethod.POST)
	public String addPizza(Pizza pizza) throws PizzaInvalidaException 
	{
		ps.addPizza(pizza);
		return "/novapizza";
	}
	
	@RequestMapping (value = "/litspizza" , method = RequestMethod.GET)
	public Iterable<Pizza> listPizza() throws NenhumaPizzaException
	{
		return ps.listPizza();
	}
	
	@RequestMapping (value = "/{nome}", method = RequestMethod.GET )
	public Pizza getPizza(@PathVariable("nome") String nome) throws PizzaInvalidaException 
	{
		return ps.getPizza(nome);
	}
	@RequestMapping(value = "/{nome}", method = RequestMethod.DELETE)
	public String deletePizza(@PathVariable("nome") String nome) throws PizzaInvalidaException 
	{
		ps.deletePizza(nome);
		return "/{nome}";
	}
}
