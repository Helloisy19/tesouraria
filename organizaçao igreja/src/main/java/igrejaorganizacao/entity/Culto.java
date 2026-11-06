package igrejaorganizacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cultos")
public class Culto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dia;
	
	private String deQue;
	
	public Culto() {
		
	}

	public Culto(Long id, String dia, String deQue) {
		super();
		this.id = id;
		this.dia = dia;
		this.deQue = deQue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getDeQue() {
		return deQue;
	}

	public void setDeQue(String deQue) {
		this.deQue = deQue;
	}
	
	

}
