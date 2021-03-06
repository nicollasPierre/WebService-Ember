package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cd_usuario", columnDefinition = "int(10) unsigned")
	private int id;
	@Column(name = "nm_usuario", columnDefinition = "varchar(50)", nullable = false)
	private String username;
	@Column(name = "ds_senha", columnDefinition = "varchar(50)", nullable = false)
	private String senha;
	@Column(name = "ds_email", columnDefinition = "varchar(50)", unique = true, nullable = false)
	private String email;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_tipo_usuario_fk_tipo_usuario")
	private Tipo_usuario tp_usuario;
	@OneToMany(mappedBy = "autor", targetEntity = Noticia.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Noticia> noticias;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Usuario(String username, String senha, String email, Tipo_usuario tp_usuario) {
		setUsername(username);
		setSenha(senha);
		setEmail(email);
		setTp_usuario(tp_usuario);
	}



	public Usuario(int id, String username, String senha, String email, Tipo_usuario tp_usuario) {
		setId(id);
		setUsername(username);
		setSenha(senha);
		setEmail(email);
		setTp_usuario(tp_usuario);
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tipo_usuario getTp_usuario() {
		return tp_usuario;
	}

	public void setTp_usuario(Tipo_usuario tp_usuario) {
		this.tp_usuario = tp_usuario;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", senha=" + senha + ", email=" + email
				+ ", tp_usuario=" + tp_usuario.toString() + "]";
	}

}
