package br.com.cartao.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@CrossOrigin
@RestController
@RequestMapping("/dawlond")
public class Imagem {

	@GetMapping(value = "/{someID}", produces = MediaType.IMAGE_JPEG_VALUE)
	public HttpEntity<byte[]> download(@PathVariable(value = "someID") String imagemNome) throws IOException {

		byte[] arquivo = Files.readAllBytes(Paths.get("/home/alaurentino/Desktop/Playfoto/" + imagemNome));

		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();

		// httpHeaders.add("Content-Disposition",
		// "attachment;filename=\"minha-imagem.jpg\"");
		httpHeaders.add("Content-Type", "image/jpeg");

		HttpEntity<byte[]> entity = new HttpEntity<byte[]>(arquivo, httpHeaders);

		return entity;
	}

}
