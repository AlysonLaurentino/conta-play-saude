package br.com.cartao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plano {

	// Pensar direito

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePlano;
	private String descrição;
	private int duracao;
	@Enumerated(EnumType.STRING)
	private StatusPlano statusPlano = StatusPlano.ATIVO;
	private Long valorPlano;
	private Long valorAdesao;
	private int qtdPet;
	private int qtdDependente;

	public Plano() {

	}

	public Plano(String nomePlano, String descrição, int duracao, Long valorPlano, Long valorAdesao, int qtdPet,
			int qtdDependente) {
		super();
		this.nomePlano = nomePlano;
		this.descrição = descrição;
		this.duracao = duracao;
		this.valorPlano = valorPlano;
		this.valorAdesao = valorAdesao;
		this.qtdPet = qtdPet;
		this.qtdDependente = qtdDependente;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public StatusPlano getStatusPlano() {
		return statusPlano;
	}

	public void setStatusPlano(StatusPlano statusPlano) {
		this.statusPlano = statusPlano;
	}

	public Long getValorPlano() {
		return valorPlano;
	}

	public void setValorPlano(Long valorPlano) {
		this.valorPlano = valorPlano;
	}

	public Long getValorAdesao() {
		return valorAdesao;
	}

	public void setValorAdesao(Long valorAdesao) {
		this.valorAdesao = valorAdesao;
	}

	public Long getId() {
		return id;
	}

	public int getQtdPet() {
		return qtdPet;
	}

	public void setQtdPet(int qtdPet) {
		this.qtdPet = qtdPet;
	}

	public int getQtdDependente() {
		return qtdDependente;
	}

	public void setQtdDependente(int qtdDependente) {
		this.qtdDependente = qtdDependente;
	}

}
