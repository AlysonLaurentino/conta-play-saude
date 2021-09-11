package br.com.cartao.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


public class PlanoLoja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	@OneToOne
	 Plano plano;

	

}
