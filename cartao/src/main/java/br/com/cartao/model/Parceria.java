package br.com.cartao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Parceria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFantasia;
	private String descricaoPromocao;
	private String funcionamento;
	private String nomeFotoLogo;
	@Enumerated(EnumType.STRING)
	private StatusLoja statusLoja;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<CategoriaParceiro> categorias;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Telefone> telefones;

	public Parceria() {

	}

	public Parceria(String nomeFantasia, String descricaoPromocao, String funcionamento,
			Endereco endereco, List<CategoriaParceiro> categorias, List<Telefone> telefones) {

		this.nomeFantasia = nomeFantasia;
		this.descricaoPromocao = descricaoPromocao;
		this.funcionamento = funcionamento;
		this.endereco = endereco;
		this.categorias = categorias;
		this.telefones = telefones;
		this.statusLoja = StatusLoja.ATIVO;

	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDescricaoPromocao() {
		return descricaoPromocao;
	}

	public void setDescricaoPromocao(String descricaoPromocao) {
		this.descricaoPromocao = descricaoPromocao;
	}

	public String getFuncionamento() {
		return funcionamento;
	}

	public void setFuncionamento(String funcionamento) {
		this.funcionamento = funcionamento;
	}

	public String getNomeFotoLogo() {
		return nomeFotoLogo;
	}

	public void setNomeFotoLogo(String nomeFotoLogo) {
		this.nomeFotoLogo = nomeFotoLogo;
	}

	public StatusLoja getStatusLoja() {
		return statusLoja;
	}

	public void setStatusLoja(StatusLoja statusLoja) {
		this.statusLoja = statusLoja;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<CategoriaParceiro> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaParceiro> categorias) {
		this.categorias = categorias;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Long getId() {
		return id;
	}

}
