package igrejaorganizacao.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "tb_entradas")
public class Entradas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contribuinte;
	
	private String tipo;
	
	private BigDecimal valor;
	
	private LocalDate data;
	
	public Entradas() {
		
	}

	public Entradas(Long id, String contribuinte, String tipo, BigDecimal valor, LocalDate data) {
		super();
		this.id = id;
		this.contribuinte = contribuinte;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContribuinte() {
		return contribuinte;
	}

	public void setContribuinte(String contribuinte) {
		this.contribuinte = contribuinte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

}
