package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Categoria;

public class CategoriaControle implements DAO<Categoria> {
	@Override
	public boolean inserir(Categoria categoria) throws Exception {
		try {
			if (categoria.getNome() != null) {
				ConexaoDB.manager.getTransaction().begin();
				ConexaoDB.manager.persist(categoria);
				ConexaoDB.manager.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erro ao persistir categoria: "+ e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean alterar(int id, Categoria objeto) throws Exception {
		Categoria cBusca = buscar(id);
		cBusca.setNome(objeto.getNome());
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.merge(cBusca);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public Categoria excluir(int id) throws Exception {
		Categoria cBusca = buscar(id);
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(cBusca);
		ConexaoDB.manager.getTransaction().commit();
		return cBusca;
	}

	@Override
	public Categoria buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Categoria.class, id);
	}

	@Override
	public Categoria buscar(String info) throws Exception {
		TypedQuery<Categoria> query = ConexaoDB.manager.createQuery(
				"Select new Categoria(cd_categoria, nm_categoria) "
						+ "from Categoria n where n.cd_categoria = :cd_categoria",
						Categoria.class);
		query.setParameter("cd_categoria", info);

		return query.getResultList().get(0);
	}

	@Override
	public List<Categoria> listar() throws Exception {
		TypedQuery<Categoria> query = ConexaoDB.manager.createQuery(
				"Select new Categoria(cd_categoria, nm_categoria) "
						+ "from Categoria n",
						Categoria.class);
		return query.getResultList();
	}

	@Override
	public List<Categoria> listarDezPrimeiros() throws Exception {
		TypedQuery<Categoria> query = ConexaoDB.manager.createQuery(
				"Select new Categoria(cd_categoria, nm_categoria) "
						+ "from Categoria n",
						Categoria.class);

		return query.setMaxResults(10).getResultList();
	}
}
