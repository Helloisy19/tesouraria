package igrejaorganizacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import igrejaorganizacao.entity.Culto;
import igrejaorganizacao.repository.CultoRepository;



@RestController
@RequestMapping("diaconal/culto")
public class CultoController {
	
	@Autowired
	private CultoRepository cultoRepository;
	
	@PostMapping
	public Culto criarCultos(@RequestBody Culto culto) {
		return cultoRepository.save(culto);
	}
	
	@GetMapping
	public List<Culto> listarcultos(){
		return cultoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Culto buscarCulto(@PathVariable Long id) {
		return cultoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void excluirDespesas(@PathVariable Long id) {
		cultoRepository.deleteById(id);
	}

}
