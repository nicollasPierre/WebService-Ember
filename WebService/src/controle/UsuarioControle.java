package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Tipo_usuario;
import model.Usuario;


public class UsuarioControle  implements DAO<Usuario>{
	@Override
	public boolean inserir(Usuario usuario) throws Exception {
		try {
			if(usuario.getEmail() != null && usuario.getSenha() != null && usuario.getUsername() != null){
			ConexaoDB.manager.getTransaction().begin();
			ConexaoDB.manager.persist(usuario);
			ConexaoDB.manager.getTransaction().commit();
			return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterar(int id, Usuario objeto) throws Exception {
		Usuario uBusca = buscar(id); 
		uBusca.setUsername(objeto.getUsername());
		uBusca.setEmail(objeto.getEmail());
		uBusca.setSenha(objeto.getSenha());
		uBusca.setTp_usuario(objeto.getTp_usuario());
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.merge(uBusca);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public Usuario excluir(int id) throws Exception {
		Usuario uBusca = buscar(id);
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(uBusca);
		ConexaoDB.manager.getTransaction().commit();
		return uBusca;
	}

	@Override
	public Usuario buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Usuario.class, id);
	}

	@Override
	public Usuario buscar(String info) throws Exception {
		TypedQuery<Usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, username, senha, email, tp_usuario) "
				+ "from Usuario c where c.email = :email", 
				Usuario.class);
		query.setParameter("email", info);
		
		return query.getResultList().get(0);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		TypedQuery<Usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, username, senha, email, tp_usuario) "
				+ "from Usuario u", 
				Usuario.class);
		return query.getResultList();
	}

	@Override
	public List<Usuario> listarDezPrimeiros() throws Exception {
		TypedQuery<Usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, nome, endereco) "
				+ "from Usuario c", 
				Usuario.class);
		
		return query.setMaxResults(10).getResultList();
	}
}
