package br.com.cartao.model;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private EwhatsApp eWhatsApp;
	private String codPais;
	private String dd;
	private String numero;

	public Telefone() {

	}

	public Telefone(String numero,EwhatsApp ewhatsApp) {
		this.dd = "81";
		this.numero = numero;
		this.codPais = "+55";
		this.eWhatsApp = ewhatsApp;
	}


	public void seteWhatsApp(EwhatsApp eWhatsApp) {
		this.eWhatsApp = eWhatsApp;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

}
