package br.com.cartao.model;

import java.util.ArrayList;

import java.util.Collection;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.cartao.repository.LoginRepository;

@Entity
public class Login implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String senha;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Perfil> perfils = new ArrayList<Perfil>();

	// add RASH

	public Login() {

	}

	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public Login(String email, String senha, List<Perfil> perfils) {
		super();
		this.email = email;
		this.senha = senha;
		this.perfils = perfils;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfils;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Long getId() {
		return id;
	}

	public Login atualizar(Long id2, LoginRepository loginRepository, Login Login) {
		Login login1 = loginRepository.getById(id2);

		login1.setEmail(email);
		login1.setSenha(senha);
		login1.setPerfils(perfils);

		return login1;
	}
	
	public UsernamePasswordAuthenticationToken converterLogin() {

		return new UsernamePasswordAuthenticationToken(email, senha);
	}


}
