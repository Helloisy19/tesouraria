package igrejaorganizacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import igrejaorganizacao.entity.Despesas;
import igrejaorganizacao.repository.DespesasRepository;





@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("tesouraria/despesas")
public class DespesasController {
	
	@Autowired
	private DespesasRepository despesasRepository;
	
	@PostMapping
	public Despesas criarDespesas(@RequestBody Despesas despesas) {
		return despesasRepository.save(despesas);
	}
	
	@GetMapping
	public List<Despesas> listarDespesas(){
		return despesasRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Despesas buscarDespesas(@PathVariable Long id) {
		return despesasRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void excluirDespesas(@PathVariable Long id) {
		despesasRepository.deleteById(id);
	}
	

}
