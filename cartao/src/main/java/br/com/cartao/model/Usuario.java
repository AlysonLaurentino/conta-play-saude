package br.com.cartao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	Pessoa Pessoa;
	@OneToOne(cascade = CascadeType.PERSIST)
	private FinanceiroDoCliente financeiroCliente;
	@OneToOne(cascade = CascadeType.PERSIST)
	private PlanoPaciente planoAtual;

	public Usuario() {

	}

	public Usuario(Pessoa pessoa) {
		Pessoa = pessoa;
		this.financeiroCliente = new FinanceiroDoCliente();
		// this.planoAtual = planoAtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return Pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		Pessoa = pessoa;
	}

	public FinanceiroDoCliente getFinnceiroCliente() {
		return financeiroCliente;
	}

	public void setFinnceiroCliente(FinanceiroDoCliente finnceiroCliente) {
		this.financeiroCliente = finnceiroCliente;
	}

	public PlanoPaciente getPlanoAtual() {
		return planoAtual;
	}

	public void setPlanoAtual(PlanoPaciente planoAtual) {
		this.planoAtual = planoAtual;
	}

}
