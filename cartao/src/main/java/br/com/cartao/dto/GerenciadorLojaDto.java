package br.com.cartao.dto;

import java.util.List;

import br.com.cartao.model.GerenciadorLoja;
import br.com.cartao.model.Loja;

public class GerenciadorLojaDto {

	private String nome;
	private List<Loja> lojas;

	public GerenciadorLojaDto(GerenciadorLoja grupoLoja) {
		this.nome = grupoLoja.getNome();
		this.lojas = grupoLoja.getLojas();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

}
