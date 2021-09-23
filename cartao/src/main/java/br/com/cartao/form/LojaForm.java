package br.com.cartao.form;

import java.util.ArrayList;

import java.util.List;

import br.com.cartao.model.Categoria;
import br.com.cartao.model.Endereco;
import br.com.cartao.model.Loja;
import br.com.cartao.model.Telefone;
import br.com.cartao.repository.LojaRepository;

public class LojaForm {

	private String nomeFantasia;
	private String descricaoPromocao;
	private String funcionamento;
	private Endereco endereco;
	private List<Categoria> categorias;
	private List<TelefoneForm> telefonesForm;

	public Loja converter() {

		List<Telefone> telefones = new ArrayList<Telefone>();
		for (TelefoneForm telefoneForm : telefonesForm) {
			telefones.add(telefoneForm.converteTels());

		}

		return new Loja(nomeFantasia, descricaoPromocao, funcionamento, endereco, categorias, telefones);
	}

	public Loja atualizar(Long id, LojaRepository lojaRepository, LojaForm form) {
		Loja loja = lojaRepository.getById(id);

		loja.setNomeFantasia(form.nomeFantasia);
		loja.setDescricaoPromocao(form.descricaoPromocao);
		loja.setFuncionamento(form.funcionamento);
		loja.setEndereco(form.endereco);
		loja.setCategorias(form.categorias);
		// loja.setTelefones(form.telefones);

		return loja;
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

	public List<TelefoneForm> getTelefonesForm() {
		return telefonesForm;
	}

	public void setTelefonesForm(List<TelefoneForm> telefonesForm) {
		this.telefonesForm = telefonesForm;
	}

}
