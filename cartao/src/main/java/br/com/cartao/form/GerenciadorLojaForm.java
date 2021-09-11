package br.com.cartao.form;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.cartao.model.GerenciadorLoja;
import br.com.cartao.model.Login;
import br.com.cartao.model.Loja;
import br.com.cartao.model.Proprietario;
import br.com.cartao.repository.GerenciadorLojaRepository;

public class GerenciadorLojaForm {

	private Loja loja;
	private List<Proprietario> proprietarios;
	private Login login;

	public GerenciadorLoja converter() {
		login.setSenha(new BCryptPasswordEncoder().encode(login.getSenha()));
		return new GerenciadorLoja(loja, proprietarios, login);
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
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

	public GerenciadorLoja atualizar(Long id, GerenciadorLojaRepository gerenciadorLojaRepository,
			GerenciadorLojaForm form) {
		GerenciadorLoja grupoLoja = gerenciadorLojaRepository.getById(id);
		// String senhaCrypt =new
		// BCryptPasswordEncoder().encode(form.getLogin().getSenha());

		// colocar os set
		return grupoLoja;
	}

}
