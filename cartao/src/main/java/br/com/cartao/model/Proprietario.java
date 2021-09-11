package br.com.cartao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proprietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ClienteFinal clienteFinal;
	
	
	//erfil
	// se já tiver um cadastro pega as informações do cadastro dele se não preenche.

	public Proprietario() {

	}

	public Proprietario(ClienteFinal clienteFinal) {
		this.clienteFinal = clienteFinal;
	}

	public ClienteFinal getClienteFinal() {
		return clienteFinal;
	}

	public void setClienteFinal(ClienteFinal clienteFinal) {
		this.clienteFinal = clienteFinal;
	}

	public Long getId() {
		return id;
	}

}
