package br.com.cartao.form;

import java.util.Date;
import java.util.List;

import br.com.cartao.model.Endereco;
import br.com.cartao.model.Login;
import br.com.cartao.model.Pessoa;
import br.com.cartao.model.Telefone;
import br.com.cartao.model.Usuario;

public class UsuarioForm {

	private String nome;
	private Date dataNascomento;
	private String cpf;
	private String rg;
	private List<Telefone> telefones;
	private Endereco endereco;
	private String email;
	private String senha;

	public Usuario converte() {
		Login login = new Login(email, senha);
		Pessoa pessoa = new Pessoa(nome, dataNascomento, cpf, rg, telefones, endereco, login);

		return new Usuario(pessoa);
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
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
