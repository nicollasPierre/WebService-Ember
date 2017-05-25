package model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class Tipo_usuario {
	@Id
	@SequenceGenerator(name = "cd_tipo")
	@Column(name = "cd_tipo", columnDefinition = "int(10) unsigned")
	private int id;
	@Column(name = "nm_tipo", columnDefinition = "varchar(20)", nullable = false)
	private String nome;
	@OneToMany(mappedBy = "tp_usuario", targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Usuario> usuarios;
	
	
	static final int admin = 1;
	static final int post = 2;
	static final int comum = 3;
	
	public Tipo_usuario() {
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
	@Override
	public String toString() {
		return "Tipo_usuario [id=" + id + ", nome=" + nome + "]";
	}

}
