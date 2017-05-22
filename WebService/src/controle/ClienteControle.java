package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Cliente;

public class ClienteControle implements DAO<Cliente> {

	@Override
	public boolean inserir(Cliente cliente) throws Exception {
		try {
			// Validar se o cliente não é nulo
			// Se os sets estão corretos
			// ...
			//
			ConexaoDB.manager.getTransaction().begin();
			ConexaoDB.manager.persist(cliente);
			ConexaoDB.manager.getTransaction().commit();
			return true;
			// else - return false
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterar(int id, Cliente objeto) throws Exception {
		Cliente cBusca = buscar(id); 
		cBusca.setNome(objeto.getNome());
		cBusca.setEndereco(objeto.getEndereco());
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.merge(cBusca);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public Cliente excluir(int id) throws Exception {
		Cliente cBusca = buscar(id);
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(cBusca);
		ConexaoDB.manager.getTransaction().commit();
		return cBusca;
	}

	@Override
	public Cliente buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Cliente.class, id);
	}

	@Override
	public Cliente buscar(String info) throws Exception {
		TypedQuery<Cliente> query = ConexaoDB.manager.createQuery(
				"Select new Cliente(id, nome, endereco) "
				+ "from Cliente c where c.nome = :nome", 
				Cliente.class);
		query.setParameter("nome", info);
		
		return query.getResultList().get(0);
	}

	@Override
	public List<Cliente> listar() throws Exception {
		TypedQuery<Cliente> query = ConexaoDB.manager.createQuery(
				"Select new Cliente(id, nome, endereco) "
				+ "from Cliente c", 
				Cliente.class);
		
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarDezPrimeiros() throws Exception {
		TypedQuery<Cliente> query = ConexaoDB.manager.createQuery(
				"Select new Cliente(id, nome, endereco) "
				+ "from Cliente c", 
				Cliente.class);
		
		return query.setMaxResults(10).getResultList();
	}

}
