package br.com.cartao.model;

import java.util.List;

public class FinanceiroDoCliente {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// @OneToMany(cascade = CascadeType.PERSIST)
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
