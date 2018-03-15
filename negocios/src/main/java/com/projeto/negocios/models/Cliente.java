package com.projeto.negocios.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe com dados dos clientes
 * 
 * @author HelderBarbosa
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String nome;

	@Column
	private String cidade;

	@Column
	private String regiao;

	@Column
	private String telefone;

	@Column
	private String cnpf;

	/**
	 * @param nome
	 * @param cidade
	 * @param regiao
	 * @param telefone
	 * @param cnpf
	 */
	public Cliente(int id, String nome, String cidade, String regiao, String telefone, String cnpf) {
		this.nome = nome;
		this.cidade = cidade;
		this.regiao = regiao;
		this.telefone = telefone;
		this.cnpf = cnpf;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the regiao
	 */
	public String getRegiao() {
		return regiao;
	}

	/**
	 * @param regiao
	 *            the regiao to set
	 */
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cnpf
	 */
	public String getCnpf() {
		return cnpf;
	}

	/**
	 * @param cnpf
	 *            the cnpf to set
	 */
	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
	}

}
