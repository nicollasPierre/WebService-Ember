package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "clientes")
@XmlRootElement
public class Cliente {

	@Id
	@SequenceGenerator(name = "idcliente")
	@Column(name = "idcliente", columnDefinition = "int(10) unsigned", nullable = false)
	private int id;

	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@ManyToOne
	@JoinTable(name = "clientesenderecos", joinColumns = {
			@JoinColumn(name = "idcliente", referencedColumnName = "idcliente") }, inverseJoinColumns = {
					@JoinColumn(name = "idendereco", referencedColumnName = "idendereco") })
	private Endereco endereco;

	public Cliente() {
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(int id, String nome, Endereco endereco) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
