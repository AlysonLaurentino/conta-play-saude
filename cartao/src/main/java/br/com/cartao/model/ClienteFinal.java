package br.com.cartao.model;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ClienteFinal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Date dataNascomento;
	private String Cpf;
	private String rg;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Telefone> telefones;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Login login;
	@OneToOne(cascade = CascadeType.PERSIST)
	private FinanceiroDoCliente financeiro;
	@OneToOne(cascade = CascadeType.PERSIST)
	private PlanoPaciente planoAtual;

	// private List<DependentePet> dependentePet;
	// private List<DependentePessoa> dependentePessoa;
	// fotoPerfil;
	// perfilAcesso de esta na entidade maior ex funcionario, proprietario;
	// financeiroCliente;
	// List<ContratoCartao> ContratoCartaos;

	public ClienteFinal() {

	}

	public ClienteFinal(String nome) {
		super();
		this.nome = nome;
	}

	public ClienteFinal(String nome, Date dataNascomento, String cpf) {
		super();
		this.nome = nome;
		this.dataNascomento = dataNascomento;
		this.Cpf = cpf;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascomento() {
		return dataNascomento;
	}

	public void setDataNascomento(Date dataNascomento) {
		this.dataNascomento = dataNascomento;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public PlanoPaciente getPlanoAtual() {
		return planoAtual;
	}

	public Long getId() {
		return id;
	}

	public FinanceiroDoCliente getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(FinanceiroDoCliente financeiro) {
		this.financeiro = financeiro;
	}

	public void setPlanoAtual(PlanoPaciente planoAtual) {
		this.planoAtual = planoAtual;
	}

}
