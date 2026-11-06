package igrejaorganizacao.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import igrejaorganizacao.entity.Comprovante;
import igrejaorganizacao.service.ComprovanteService;


@RestController
@RequestMapping("/tesouraria/comprovante")
public class ComprovanteController {
	
	private final ComprovanteService service;

	public ComprovanteController(ComprovanteService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Comprovante cadastrar(
	        @RequestParam("arquivo") MultipartFile arquivo, 
	        @RequestParam("descriçao") String descriçao) throws IOException { 
	    return service.salvar(arquivo, descriçao);
	}
	
	@GetMapping("/{id}")
	public Comprovante consultar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	

}
