package br.com.cartao.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cartao.form.UsuarioForm;
import br.com.cartao.model.Usuario;
import br.com.cartao.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Usuario> CadastarFuncionario(@RequestBody UsuarioForm form,
			UriComponentsBuilder uribuilBuilder) {

		Usuario usuario = form.converte();

		usuarioRepository.save(usuario);

		URI uri = uribuilBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}

}
