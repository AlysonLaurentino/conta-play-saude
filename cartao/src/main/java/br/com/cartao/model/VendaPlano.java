package br.com.cartao.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class VendaPlano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Plano plano;
	private String CodClinica;
	public String CodVendedor;
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	public Usuario usuario;
	private double total;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Parcela> parcelas;
	private StatusPagamento statusPagamento = StatusPagamento.EMABERTO;

	public VendaPlano() {

	}

	public VendaPlano(Long id, Plano plano, String codVendedor) {
		super();
		this.id = id;
		this.plano = plano;
		CodVendedor = codVendedor;
		//this.usuario = usuario;
	}

//	public VendaPlano(Plano plano,Usuario usuario) {
//		this.plano = plano;
//		calculaTotal();
//		GeraParcelamento(plano);
//
//	}

	public void pagarParcela(int parcela, double pgParcela) {
		for (Parcela parcela1 : parcelas) {
			if (parcela1.numeroParcela == parcela) {
				double valorPgPago = parcela1.pagarParcela(pgParcela);
				if (valorPgPago == 0) {
					this.total -= pgParcela;
					System.out.println("Deu certo - Status da Parcela = " + total);
				}
			}
			if (total == 0) {
				// podemos fazer uma segunda validação com o status da parcela
				statusPagamento = StatusPagamento.PAGO;
				System.out.println("Deu certo - Status da VendaPlano = " + statusPagamento);

			}

		}

	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
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

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Long getId() {
		return id;
	}

//	public void GeraParcelamento(Plano plano) {
//		for (int i = 1; i <= plano.qtaParcela; i++) {
//			Parcela p = new Parcela(i, plano.preco);
//			parcelas.add(p);
//
//		}
//
//	}
//
//	public void calculaTotal() {
//		total = (plano.qtaParcela * plano.preco);
//	}

}
