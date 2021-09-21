package br.com.cartao.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PlanoPaciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Plano plano;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	@Enumerated(EnumType.STRING)
	private StatusPlanoPaciente statusPlano;

	public PlanoPaciente() {
		super();
	}

	public PlanoPaciente(Pedido pedido) {
		if (pedido.getStatusPagamento().toString() == "PAGO") {
			this.plano = pedido.getPlano();
			setStatusPlano(StatusPlanoPaciente.ATIVO);
		} else {
			setStatusPlano(StatusPlanoPaciente.DESATIVADO);

		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public StatusPlanoPaciente getStatusPlano() {
		return statusPlano;
	}

	public void setStatusPlano(StatusPlanoPaciente statusPlanoNovo) {
		this.statusPlano = statusPlanoNovo;
		if (this.statusPlano == StatusPlanoPaciente.ATIVO) {
			dataInicio = LocalDateTime.now();
			CalculaDateFim();
		}

	}
	private void CalculaDateFim() {
		this.dataFim = dataInicio.plusMonths(plano.getDuracao());
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

}
