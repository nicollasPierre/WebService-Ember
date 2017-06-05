package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Tipo_usuario;

public class Tipo_usuarioControle implements DAO<Tipo_usuario> {
	@Override
	public boolean inserir(Tipo_usuario tipo) throws Exception {

			ConexaoDB.manager.getTransaction().begin();
			try {
				ConexaoDB.manager.persist(tipo);
				ConexaoDB.manager.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Erro ao persist usuario no banco: " + e.getMessage());
				e.printStackTrace();
				return false;
			}

	}

	@Override
	public boolean alterar(int id, Tipo_usuario objeto) throws Exception {
		Tipo_usuario uBusca = buscar(id);
		/*uBusca.setUsername(objeto.getUsername());
		uBusca.setEmail(objeto.getEmail());
		uBusca.setSenha(objeto.getSenha());
		uBusca.setTp_usuario(objeto.getTp_usuario());*/
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.merge(uBusca);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public Tipo_usuario excluir(int id) throws Exception {
		Tipo_usuario uBusca = buscar(id);
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(uBusca);
		ConexaoDB.manager.getTransaction().commit();
		return uBusca;
	}

	@Override
	public Tipo_usuario buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Tipo_usuario.class, id);
	}

	@Override//alterar select
	public Tipo_usuario buscar(String info) throws Exception {
		TypedQuery<Tipo_usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, username, senha, email, tp_usuario) " + "from Usuario c where c.email = :email",
				Tipo_usuario.class);
		query.setParameter("email", info);

		return query.getResultList().get(0);
	}

	@Override//alterar select
	public List<Tipo_usuario> listar() throws Exception {
		TypedQuery<Tipo_usuario> query = ConexaoDB.manager.createQuery(
				"Select new Usuario(id, username, senha, email, tp_usuario) " + "from Usuario u", Tipo_usuario.class);
		return query.getResultList();
	}
	
	@Override//alterar select
	public List<Tipo_usuario> listarDezPrimeiros() throws Exception {
		TypedQuery<Tipo_usuario> query = ConexaoDB.manager
				.createQuery("Select new Tipo_usuario(id, nome, endereco) " + "from Usuario c", Tipo_usuario.class);

		return query.setMaxResults(10).getResultList();
	}
}
