package br.com.cartao.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
	private Plano plano;
	private StatusPagamento statusPagamento = StatusPagamento.EMABERTO;
	private String CodClinica;
	public  String CodVendedor;
	@ManyToOne(cascade = CascadeType.PERSIST)
	public ClienteFinal cliente;

	public Pedido() {
		
	}
	
	public Pedido(Plano plano, String codClinica, String codVendedor,
			ClienteFinal cliente) {
		this.plano = plano;
		CodClinica = codClinica;
		CodVendedor = codVendedor;
		this.cliente = cliente;
		//cliente.getFinanceiro().adicionaPedido(this);
	}


	public Plano getPlano() {
		return plano;
	}


	public void setPlano(Plano plano) {
		this.plano = plano;
	}


	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}


	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
		if(this.statusPagamento==StatusPagamento.PAGO) {
			PlanoPaciente planoAtual= new PlanoPaciente(this);
			cliente.setPlanoAtual(planoAtual);
	
			
		}
	}


	public String getCodClinica() {
		return CodClinica;
	}


	public void setCodClinica(String codClinica) {
		CodClinica = codClinica;
	}


	public String getCodVendedor() {
		return CodVendedor;
	}


	public void setCodVendedor(String codVendedor) {
		CodVendedor = codVendedor;
	}
		
	

}
