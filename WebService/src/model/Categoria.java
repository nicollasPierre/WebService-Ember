package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@SequenceGenerator(name = "cd_categoria")
	@Column(name = "cd_categoria", columnDefinition = "int(10) unsigned", nullable = false)
	private int id;
	@Column(name = "nm_categoria", columnDefinition = "varchar(20)", nullable = false)
	private String nome;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
