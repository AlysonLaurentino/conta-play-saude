package br.com.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartao.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{

}
