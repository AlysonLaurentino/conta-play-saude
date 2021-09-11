package br.com.cartao.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// plano ver essas questões se faço para cada um ou se colo uma interface;
	// private Date inicio;
	// private Date fim;
	// private Vendedor vendedor;
	// private AdmContrato admContrato ;
	// private StatusContrato statusContrato;
	// (ativo, renovar, cancelado, falta primeiro pagamento);
	// private FormaPagemaneto formaPagamento;
	// private Date melhorDiaPagamento;

}
