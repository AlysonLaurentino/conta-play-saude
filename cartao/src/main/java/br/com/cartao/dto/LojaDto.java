package br.com.cartao.dto;

import java.util.List;

import br.com.cartao.model.Categoria;
import br.com.cartao.model.Endereco;
import br.com.cartao.model.Loja;
import br.com.cartao.model.Telefone;

public class LojaDto {

	private String nomeFantasia;
	private String descricaoPromocao;
	private String funcionamento;
	private String nomeFotoLogo;
	private Endereco endereco;
	private List<Categoria> categorias;
	private List<Telefone> telefones;

	public LojaDto(Loja loja) {
		this.nomeFantasia = loja.getNomeFantasia();
		this.descricaoPromocao = loja.getDescricaoPromocao();
		this.funcionamento = loja.getFuncionamento();
		this.nomeFotoLogo = loja.getNomeFotoLogo();
		this.endereco = loja.getEndereco();
		this.telefones = loja.getTelefones();
		this.categorias = loja.getCategorias();
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	
	

}
