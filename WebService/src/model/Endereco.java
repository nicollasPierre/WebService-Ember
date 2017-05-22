package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "enderecos")
@XmlRootElement
public class Endereco {

	@Id
	@SequenceGenerator(name = "idendereco")
	@Column(name = "idendereco", columnDefinition = "int(10) unsigned", nullable = false)
	private int id;

	@Column(name = "ds_rua", nullable = false)
	private String rua;

//	@OneToMany
//	@JoinTable(name = "clientesenderecos", joinColumns = {
//			@JoinColumn(name = "idendereco", referencedColumnName = "idendereco") }, inverseJoinColumns = {
//					@JoinColumn(name = "idcliente", referencedColumnName = "idcliente") })
//	@XmlElementWrapper
//	private List<Cliente> clientes;

	public Endereco() {
	}

	public Endereco(int id, String rua) {
		super();
		this.id = id;
		this.rua = rua;
	}

//	public void addCliente(Cliente c) {
//		clientes.add(c);
//	}
	
//	public List<Cliente> getClientes() {
//		return clientes;
//	}

//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
