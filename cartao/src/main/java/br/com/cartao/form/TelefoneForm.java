package br.com.cartao.form;

import br.com.cartao.model.EwhatsApp;
import br.com.cartao.model.Telefone;

public class TelefoneForm {

	private String telefone;
	private String eWhatsApp;

	@SuppressWarnings("static-access")
	public Telefone converteTels() {

		EwhatsApp whats=null;

		return new Telefone(telefone, whats.valueOf(eWhatsApp));
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String geteWhatsApp() {
		return eWhatsApp;
	}

	public void seteWhatsApp(String eWhatsApp) {
		this.eWhatsApp = eWhatsApp;
	}

}
