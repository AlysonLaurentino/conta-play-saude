package br.com.cartao.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartao.dto.TokenDTO;
import br.com.cartao.form.LoginForm;
import br.com.cartao.security.TokenService;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody LoginForm loginForm) {
	
		UsernamePasswordAuthenticationToken dadosLongin = loginForm.converterLogin();
			
		Authentication authentication = authenticationManager.authenticate(dadosLongin);
				
		String token = tokenService.gerarToken(authentication);
		
		return ResponseEntity.ok(new TokenDTO(token, "Bearer"));

	}

}
