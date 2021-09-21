package br.com.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartao.model.Parceria;

public interface ParceriaRepository extends JpaRepository<Parceria, Long> {

}
