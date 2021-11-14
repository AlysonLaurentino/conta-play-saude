package br.com.cartao.controller;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cartao.form.LoginForm;
import br.com.cartao.model.Login;
import br.com.cartao.repository.LoginRepository;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	@GetMapping
	public List<Login> listarLojas() {

		List<Login> login = loginRepository.findAll();

		return login;

	}
	/*
	 * @PostMapping
	 * 
	 * @Transactional public ResponseEntity<Login> Cadastar(@RequestBody ListaForm
	 * form, UriComponentsBuilder uribuilBuilder) {
	 * 
	 * Login login = form.converter();
	 * 
	 * loginRepository.save(login);
	 * 
	 * URI uri =
	 * uribuilBuilder.path("/loja/{id}").buildAndExpand(login.getId()).toUri();
	 * return ResponseEntity.created(uri).body(login); }
	 */

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Login> atualizar(@PathVariable Long id, @RequestBody LoginForm form) {
		Login login = form.converter();
		Optional<Login> loginOptional = loginRepository.findById(id);
		if (loginOptional.isPresent()) {
			Login login2 = login.atualizar(id, loginRepository, login);
			return ResponseEntity.ok(login2);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Login> login = loginRepository.findById(id);
		if (login.isPresent()) {
			loginRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
