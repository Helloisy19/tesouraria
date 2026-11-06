package igrejaorganizacao.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import igrejaorganizacao.service.SaldoService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class SaldoController {

	private final SaldoService service;

	public SaldoController(SaldoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/tesouraria/saldo")
	public BigDecimal consultarSaldo() {
		return service.calcularSaldo();
	}

}
