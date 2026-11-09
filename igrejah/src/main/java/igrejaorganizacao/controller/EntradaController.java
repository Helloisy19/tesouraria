package igrejaorganizacao.controller;

import java.util.List;


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

import igrejaorganizacao.entity.Entradas;
import igrejaorganizacao.repository.EntradaRepository;




@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("tesouraria/entradas")
public class EntradaController {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@PostMapping
	public Entradas criarEntradas(@RequestBody Entradas entrada) {
		return entradaRepository.save(entrada);
	}
	
	@GetMapping
	public List<Entradas> listarEntradas(){
		return entradaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Entradas buscarEntradas(@PathVariable Long id) {
		return entradaRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarEntradas(@PathVariable Long id, @RequestBody String entradaAtualizadaJson){
		System.out.println("Atualizando o ID" + id + "com os dados: " + entradaAtualizadaJson);
		return ResponseEntity.ok("Entrada atualizada com sucesso!");}
	
	@DeleteMapping("/{id}")
	public void excluirEntrada(@PathVariable Long id) {
		entradaRepository.deleteById(id);
	}

}
