package br.com.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartao.model.GerenciadorLoja;

public interface GerenciadorLojaRepository extends JpaRepository<GerenciadorLoja, Long>{

	GerenciadorLoja findByid(Long idLojaGerenciador);

}
