package br.com.cartao.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.cartao.model.Login;
import br.com.cartao.repository.LoginRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private LoginRepository Loginrepository;

	public AutenticacaoViaTokenFilter(TokenService tokenService, LoginRepository Loginrepository) {
		this.tokenService = tokenService;
		this.Loginrepository = Loginrepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			autenticador(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticador(String token) {
		Long idLongSistema = tokenService.getIdLong(token);
		Login login = Loginrepository.findById(idLongSistema).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, null,
				null);//login.getAuthorities() colocar no lugar do ultimo null

		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {

			return null;
		}
		return token.substring(7, token.length());
	}
}
