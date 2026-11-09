package igrejaorganizacao.service;

// Trabalhar com valores monetários
import java.math.BigDecimal;

// Trabalhar com datas
import java.time.LocalDate;
import java.time.YearMonth;

// Criar um conjunto de informações para devolver no relatório
import java.util.Map;

// Importar as entidades
import igrejaorganizacao.entity.Entradas;
import igrejaorganizacao.entity.Despesas;

// Importar os repositories
import igrejaorganizacao.repository.EntradaRepository;
import igrejaorganizacao.repository.DespesasRepository;

// Anotação do Spring
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    // Repositories utilizados para consultar o banco
    private final EntradaRepository entradaRepository;
    private final DespesasRepository despesasRepository;

    // Construtor: recebe os repositories automaticamente
    public RelatorioService(EntradaRepository entradaRepository,
                            DespesasRepository despesasRepository) {

        this.entradaRepository = entradaRepository;
        this.despesasRepository = despesasRepository;
    }

    // Método que gera o relatório de um mês específico
    public Map<String, Object> gerarRelatorio(int mes, int ano) {

        // Verifica se o mês e o ano são válidos
        if (mes < 1 || mes > 12 || ano < 1) {
            throw new IllegalArgumentException("Mês ou ano inválido!");
        }

        // Cria uma referência para o mês e ano informados
        YearMonth periodo = YearMonth.of(ano, mes);

        // Descobre o primeiro dia do mês
        LocalDate inicio = periodo.atDay(1);

        // Descobre o último dia do mês
        LocalDate fim = periodo.atEndOfMonth();

        // Inicializa o total de entradas com zero
        BigDecimal totalEntradas = BigDecimal.ZERO;

        // Percorre todas as entradas cadastradas
        for (Entradas entrada : entradaRepository.findAll()) {

            // Verifica se a data da entrada existe
            if (entrada.getData() != null) {

                // Verifica se a entrada pertence ao mês consultado
                if (!entrada.getData().isBefore(inicio)
                        && !entrada.getData().isAfter(fim)) {

                    // Verifica se o valor existe
                    if (entrada.getValor() != null) {

                        // Soma o valor ao total de entradas
                        totalEntradas = totalEntradas.add(entrada.getValor());
                    }
                }
            }
        }

        // Inicializa o total de despesas com zero
        BigDecimal totalDespesas = BigDecimal.ZERO;

        // Percorre todas as despesas cadastradas
        for (Despesas despesa : despesasRepository.findAll()) {

            // Verifica se a data da despesa existe
            if (despesa.getData_saida() != null) {

                // Verifica se a despesa pertence ao mês consultado
                if (!despesa.getData_saida().isBefore(inicio)
                        && !despesa.getData_saida().isAfter(fim)) {

                    // Verifica se o valor existe
                    if (despesa.getValor() != null) {

                        // Soma o valor ao total de despesas
                        totalDespesas = totalDespesas.add(despesa.getValor());
                    }
                }
            }
        }

        // Calcula o resultado do mês
        BigDecimal saldo = totalEntradas.subtract(totalDespesas);

        // Devolve as informações do relatório
        return Map.of(
            "mes", mes,
            "ano", ano,
            "totalEntradas", totalEntradas,
            "totalDespesas", totalDespesas,
            "saldo", saldo
        );
    }
}