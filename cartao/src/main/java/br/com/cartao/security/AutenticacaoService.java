package br.com.cartao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cartao.model.Login;
import br.com.cartao.repository.LoginRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> loginOp = loginRepository.findByEmail(username);
		if (loginOp.isPresent()) {
			return loginOp.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
