package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "noticia")
@XmlRootElement
public class Noticia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cd_noticia", columnDefinition = "int(10) unsigned", nullable = false)
	private int id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_autor_fk_usuario")
	private Usuario autor;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_categoria_fk_categoria")
	private Categoria categorias;
	@Column(name = "nm_noticia",columnDefinition="varchar(100)", nullable = false)
	private String titulo;
	@Column(name = "ds_noticia",columnDefinition="text", nullable = false)
	private String conteudo;

	public Noticia() {
	}

	public Noticia(int id, Usuario autor, Categoria categorias, String titulo, String conteudo) {
		setId(id);
		setAutor(autor);
		setCategorias(categorias);
		setConteudo(conteudo);
		setTitulo(titulo);
	}

	public Usuario getAutor() {
		return autor;
	}

	public int getId() {
		return id;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", autor=" + autor + ", categorias=" + categorias.toString() + ", titulo=" + titulo
				+ ", conteudo=" + conteudo + "]";
	}
	
	
}
