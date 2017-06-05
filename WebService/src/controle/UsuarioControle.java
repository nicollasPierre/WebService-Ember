package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Tipo_usuario;
import model.Usuario;

public class UsuarioControle implements DAO<Usuario> {
	@Override
	public boolean inserir(Usuario usuario) throws Exception {

		if (usuario.getEmail() != null && usuario.getSenha() != null && usuario.getUsername() != null && buscar(usuario.getEmail()) == null) {
			ConexaoDB.manager.getTransaction().begin();
			try {
				Tipo_usuario tp_usuario =new Tipo_usuarioControle().buscar(usuario.getTp_usuario().getId());
				
				if(tp_usuario == null){
					/*new Tipo_usuarioControle().inserir(usuario.getTp_usuario());
					tp_usuario = new Tipo_usuarioControle().buscar(usuario.getTp_usuario().getId());*/
				}else
					usuario.setTp_usuario(tp_usuario);
				ConexaoDB.manager.persist(usuario);
				ConexaoDB.manager.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Erro ao persist usuario no banco: " + e.getMessage());
				ConexaoDB.manager.getTransaction().rollback();
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public boolean alterar(int id, Usuario objeto) throws Exception {
		Usuario uBusca = buscar(id);
		uBusca.setUsername(objeto.getUsername());
		uBusca.setEmail(objeto.getEmail());
		uBusca.setSenha(objeto.getSenha());
		Tipo_usuario tp_user = new Tipo_usuarioControle().buscar(objeto.getTp_usuario().getId());
		if(objeto.getTp_usuario() != null){
			objeto.setTp_usuario(tp_user);
		}
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
				"Select new Usuario(id, username, senha, email, tp_usuario) " + "from Usuario c where c.email = :email",
				Usuario.class);
		query.setParameter("email", info);
		try{
			return query.getResultList().get(0);
		}catch (Exception e){
			//pode retornanr nenhum resultado na query
			return null;
		}
	}

	@Override
	public List<Usuario> listar() throws Exception {
		TypedQuery<Usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, username, senha, email, tp_usuario) " + "from Usuario u", Usuario.class);
		return query.getResultList();
	}

	@Override
	public List<Usuario> listarDezPrimeiros() throws Exception {
		TypedQuery<Usuario> query = ConexaoDB.manager
				.createQuery("Select new Usuario(id, nome, endereco) " + "from Usuario c", Usuario.class);

		return query.setMaxResults(10).getResultList();
	}
}
