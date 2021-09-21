package br.com.cartao.form;

import java.util.ArrayList;
import java.util.List;

import br.com.cartao.model.CategoriaParceiro;
import br.com.cartao.model.Endereco;
import br.com.cartao.model.Parceria;
import br.com.cartao.model.Telefone;
import br.com.cartao.repository.ParceriaRepository;

public class ParceriaForm {

	private String nomeFantasia;
	private String descricaoPromocao;
	private String funcionamento;
	private Endereco endereco;
	private List<CategoriaParceiro> categorias;
	private List<TelefoneForm> telefonesForm;

	public Parceria converter() {

		List<Telefone> telefones = new ArrayList<Telefone>();
		for (TelefoneForm telefoneForm : telefonesForm) {
			telefones.add(telefoneForm.converteTels());

		}

		return new Parceria(nomeFantasia, descricaoPromocao, funcionamento, endereco, categorias,
				telefones);
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

	public List<CategoriaParceiro> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaParceiro> categorias) {
		this.categorias = categorias;
	}

	public List<TelefoneForm> getTelefonesForm() {
		return telefonesForm;
	}

	public void setTelefonesForm(List<TelefoneForm> telefonesForm) {
		this.telefonesForm = telefonesForm;
	}

	public Parceria atualizar(Long id, ParceriaRepository parceriaRepository, ParceriaForm form) {

		Parceria p = parceriaRepository.getById(id);

		p.setNomeFantasia(form.getNomeFantasia());
		p.setDescricaoPromocao(form.getDescricaoPromocao());
		p.setFuncionamento(form.funcionamento);
		p.setEndereco(form.endereco);
		p.setCategorias(form.categorias);
		// p.setTelefones(form.telefonesForm);

		return null;
	}

}
