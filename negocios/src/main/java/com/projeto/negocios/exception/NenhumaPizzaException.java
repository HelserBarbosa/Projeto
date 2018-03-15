package com.projeto.negocios.exception;

public class NenhumaPizzaException extends Exception {
	public NenhumaPizzaException() 
	{
		super("Nenhuma pizza encontrada");
	}
}
