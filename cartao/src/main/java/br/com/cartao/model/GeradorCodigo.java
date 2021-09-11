package br.com.cartao.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeradorCodigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoGerado;

	public GeradorCodigo() {
	}

	public void gerador(Long id, String nome) {
		Random random = new Random();
		int numero = random.nextInt(1000);
		String codigoG = nome.trim() + (id + numero);
		this.codigoGerado = codigoG.trim().toUpperCase();
	}

	public String getCodigogGerado() {
		return codigoGerado;
	}

}
