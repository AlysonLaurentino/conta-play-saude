package br.com.cartao.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class FinanceiroDoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<VendaPlano> vendas;

	public FinanceiroDoCliente() {

	}

	public List<VendaPlano> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaPlano> vendas) {
		this.vendas = vendas;
	}

	public Long getId() {
		return id;
	}

}
