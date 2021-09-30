package br.com.cartao.model;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadArquivo {
	

	//@Value("${raiz}")
	private String raiz = "/home/alysonsobrinho40";
	
	//@Value("${diretorio}")
	private String diretorio = "/PlaySaude";
	

	public void salvar(MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		System.out.println("chegou");
		System.out.println(diretorioPath.getFileName());
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			System.out.println("finalizou");
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}		
	}
	


}
