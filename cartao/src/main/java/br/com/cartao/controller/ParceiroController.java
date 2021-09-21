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

import br.com.cartao.dto.ParceriaDto;
import br.com.cartao.form.ParceriaForm;
import br.com.cartao.model.Parceria;
import br.com.cartao.model.UploadArquivo;
import br.com.cartao.repository.ParceriaRepository;

@CrossOrigin
@RestController
@RequestMapping("/parceria")
public class ParceiroController {

	@Autowired
	UploadArquivo uploadArquivo;

	@Autowired
	ParceriaRepository parceriaRepository;

	@GetMapping
	public List<ParceriaDto> listarLojas() {

		List<Parceria> parcerias = parceriaRepository.findAll();

		List<ParceriaDto> parceriasDto = new ArrayList<ParceriaDto>();

		for (Parceria parceria : parcerias) {
			ParceriaDto parceriaDto = new ParceriaDto(parceria);

			parceriasDto.add(parceriaDto);
		}

		return parceriasDto;

	}

	@GetMapping("/{id}")
	public ResponseEntity<Parceria> detalhar(@PathVariable Long id) {
		Optional<Parceria> parceria = parceriaRepository.findById(id);
		if (parceria.isPresent()) {
			return ResponseEntity.ok(parceria.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<String> Cadastar(String parceriaForm, MultipartFile foto, UriComponentsBuilder uribuilBuilder)
			throws JsonMappingException, JsonProcessingException {
		// precisa melhorar o codigo para armazenar a foto, ex garantir que não vai ter foto duplicada, uma pasta por loja
		//
		ObjectMapper mapper = new ObjectMapper();
		ParceriaForm lojaMapper = mapper.readValue(parceriaForm, ParceriaForm.class);
		Parceria parceriaOficial = lojaMapper.converter();
		if(foto!=null) {
		parceriaOficial.setNomeFotoLogo(foto.getOriginalFilename());
		uploadArquivo.salvar(foto);
		}
		parceriaRepository.save(parceriaOficial);

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
	public ResponseEntity<ParceriaDto> atualizar(@PathVariable Long id, @RequestBody ParceriaForm form) {
		Optional<Parceria> parceriaOptional = parceriaRepository.findById(id);
		if (parceriaOptional.isPresent()) {
			Parceria parceria = form.atualizar(id, parceriaRepository, form);
			return ResponseEntity.ok(new ParceriaDto(parceria));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Parceria> loja = parceriaRepository.findById(id);
		if (loja.isPresent()) {
			parceriaRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
