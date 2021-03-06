package br.com.cartao.dto;

import java.util.List;

import br.com.cartao.model.CategoriaParceiro;
import br.com.cartao.model.Endereco;
import br.com.cartao.model.Parceria;
import br.com.cartao.model.Telefone;

public class ParceriaDto {

	private String nomeFantasia;
	private String descricaoPromocao;
	private String funcionamento;
	private String nomeFotoLogo;
	private Endereco endereco;
	private List<CategoriaParceiro> categorias;
	private List<Telefone> telefones;

	public ParceriaDto(Parceria parceria) {

		this.nomeFantasia = parceria.getNomeFantasia();
		this.descricaoPromocao = parceria.getDescricaoPromocao();
		this.funcionamento = parceria.getFuncionamento();
		this.nomeFotoLogo = parceria.getNomeFotoLogo();
		this.endereco = parceria.getEndereco();
		this.telefones = parceria.getTelefones();
		this.categorias = parceria.getCategorias();

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

}
