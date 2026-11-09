package igrejaorganizacao.controller;

// Importa o tipo Map
import java.util.Map;

// Importa as anotações do Spring
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Importa o Service
import igrejaorganizacao.service.RelatorioService;

@RestController
@RequestMapping("/tesouraria/relatorio")
public class RelatorioController {

    // Declara o Service
    private final RelatorioService service;

    // Construtor
    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    // Endpoint para gerar o relatório mensal
    @GetMapping("/mensal")
    public Map<String, Object> gerarRelatorio(
            @RequestParam int mes,
            @RequestParam int ano) {

        // Envia o mês e o ano para o Service
        return service.gerarRelatorio(mes, ano);
    }
}

//?mes=10&ano=2026