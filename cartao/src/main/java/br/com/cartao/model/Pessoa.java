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
public class Pessoa {

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

	public Pessoa() {

	}

	public Pessoa(String nome, Date dataNascomento, String cpf, String rg, List<Telefone> telefones, Endereco endereco,
			Login login) {
		super();
		this.nome = nome;
		this.dataNascomento = dataNascomento;
		Cpf = cpf;
		this.rg = rg;
		this.telefones = telefones;
		this.endereco = endereco;
		this.login = login;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Long getId() {
		return id;
	}

}
