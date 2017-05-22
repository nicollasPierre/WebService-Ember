package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Endereco;

public class EnderecoControle implements DAO<Endereco> {

	@Override
	public boolean inserir(Endereco endereco) throws Exception {
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.persist(endereco);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean alterar(int id, Endereco endereco) throws Exception {
		Endereco e = buscar(id);
		//e.setClientes(endereco.getClientes());
		
		return true;
	}

	@Override
	public Endereco excluir(int id) throws Exception {
		return null;
	}

	@Override
	public Endereco buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Endereco.class, id);
	}

	@Override
	public Endereco buscar(String info) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listar() throws Exception {
		TypedQuery<Endereco> query = ConexaoDB.manager.createQuery(
				"select new Endereco(e.id, e.rua) from Endereco e", Endereco.class);
		return query.getResultList();
	}

	@Override
	public List<Endereco> listarDezPrimeiros() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
