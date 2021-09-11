package br.com.cartao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cartao.dto.LojaDto;
import br.com.cartao.form.LojaForm;
import br.com.cartao.model.Loja;
import br.com.cartao.model.UploadArquivo;
import br.com.cartao.repository.GerenciadorLojaRepository;
import br.com.cartao.repository.LojaRepository;

@CrossOrigin
@RestController
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	GerenciadorLojaRepository gerenciadorLojaRepository;

	@Autowired
	LojaRepository lojaRepository;

	@Autowired
	UploadArquivo uploadArquivo;

	@GetMapping
	public List<LojaDto> listarLojas() {

		List<Loja> lojas = lojaRepository.findAll();

		List<LojaDto> lojasDto = new ArrayList<LojaDto>();

		for (Loja loja : lojas) {
			LojaDto lojaDto = new LojaDto(loja);

			lojasDto.add(lojaDto);
		}

		return lojasDto;

	}

	@GetMapping("/{id}")
	public ResponseEntity<Loja> detalhar(@PathVariable Long id) {
		Optional<Loja> loja = lojaRepository.findById(id);
		if (loja.isPresent()) {
			return ResponseEntity.ok(loja.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<String> Cadastar(String lojaForm, MultipartFile foto, UriComponentsBuilder uribuilBuilder)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		LojaForm lojaMapper = mapper.readValue(lojaForm, LojaForm.class);
		Loja lojaOficial = lojaMapper.converter();
		lojaOficial.setNomeFotoLogo(foto.getOriginalFilename());
		lojaRepository.save(lojaOficial);
		uploadArquivo.salvar(foto);

//		try {
//			LojaForm lojaForm = mapper.readValue(loja, LojaForm.class);
//			Loja lojaOficial = lojaForm.converter();
//			lojaRepository.save(lojaOficial);
//			uploadArquivo.saveFoto(foto);
//		} catch (IOException e) {
//			return ResponseEntity.badRequest().body("Não foi possível ler o json");
//		}

		return ResponseEntity.ok("Deu certo!");

		// uploadArquivo.saveFoto(arquivo.getFoto());
		// Loja loja = arquivo.getLoja().converter();
		/*
		 * lojaRepository.save(loja);
		 * 
		 * URI uri =
		 * uribuilBuilder.path("/loja/{id}").buildAndExpand(loja.getId()).toUri();
		 * return ResponseEntity.created(uri).body(loja);
		 */

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LojaDto> atualizar(@PathVariable Long id, @RequestBody LojaForm form) {
		Optional<Loja> lojaOptional = lojaRepository.findById(id);
		if (lojaOptional.isPresent()) {
			Loja loja = form.atualizar(id, lojaRepository, form);
			return ResponseEntity.ok(new LojaDto(loja));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Loja> loja = lojaRepository.findById(id);
		if (loja.isPresent()) {
			lojaRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
