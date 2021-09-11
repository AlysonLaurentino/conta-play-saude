package br.com.cartao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class GerenciadorLoja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Loja> lojas = new ArrayList<Loja>();
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Proprietario> proprietarios;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Login login;
	
	public GerenciadorLoja() {
		
	}
	
	

	public GerenciadorLoja(Loja loja,List<Proprietario> proprietarios, Login login) {
		adicionaLoja(loja);
		this.proprietarios = proprietarios;
		this.login = login;
	}

	public void adicionaLoja(Loja loja) {
		lojas.add(loja);

	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
