package br.com.cartao.dto;

import org.springframework.web.multipart.MultipartFile;


public class ArquivoDTO {
	
	//private LojaForm loja;
	private MultipartFile foto;
	

	
	public MultipartFile getFoto() {
		return foto;
	}
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}
	
	

}
