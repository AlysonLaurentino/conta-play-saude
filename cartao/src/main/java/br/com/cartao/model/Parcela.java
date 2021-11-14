package br.com.cartao.model;

public class Parcela {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	int numeroParcela;
	double valor;
	StatusPagamento statusParcela = StatusPagamento.EMABERTO;

	// status
	public Parcela() {

	}

	public Parcela(int numeroParcela, double valor) {
		super();
		this.numeroParcela = numeroParcela;
		this.valor = valor;
	}

	public double pagarParcela(double pgParcela) {
		double novoValor = this.valor -= pgParcela;
		if (novoValor == 0) {
			statusParcela = StatusPagamento.PAGO;
		}
		return valor;
	}

}
