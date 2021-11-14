package br.com.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
