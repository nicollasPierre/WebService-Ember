package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Noticia;
import model.Usuario;

public class NoticiaControle implements DAO<Noticia> {
	@Override
	public boolean inserir(Noticia noticia) throws Exception {
		try {
			if(noticia.getAutor() != null && 
			   noticia.getConteudo() != null && 
			   noticia.getTitulo() != null && 
			   noticia.getId() != -1 && 
			   noticia.getCategorias() != null){
			ConexaoDB.manager.getTransaction().begin();
			ConexaoDB.manager.persist(noticia);
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
	public boolean alterar(int id, Noticia objeto) throws Exception {
		Noticia nBusca = buscar(id); 
		nBusca.setAutor(objeto.getAutor());
		nBusca.setConteudo(objeto.getConteudo());
		nBusca.setTitulo(objeto.getTitulo());
		nBusca.setCategorias(objeto.getCategorias());
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.merge(nBusca);
		ConexaoDB.manager.getTransaction().commit();
		return true;
	}

	@Override
	public Noticia excluir(int id) throws Exception {
		Noticia nBusca = buscar(id);
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(nBusca);
		ConexaoDB.manager.getTransaction().commit();
		return nBusca;
	}

	@Override
	public Noticia buscar(int id) throws Exception {
		return ConexaoDB.manager.find(Noticia.class, id);
	}

	@Override
	public Noticia buscar(String info) throws Exception {
		TypedQuery<Noticia> query = ConexaoDB.manager.createQuery(
				"Select new Noticia(id, cd_autor_fk_usuario, cd_categoria_fk_categoria, nm_noticia, ds_noticia) "
				+ "from Noticia n where n.cd_noticia = :cd_noticia", 
				Noticia.class);
		query.setParameter("cd_noticia", info);
		
		return query.getResultList().get(0);
	}

	@Override
	public List<Noticia> listar() throws Exception {
		TypedQuery<Noticia> query = ConexaoDB.manager.createQuery(
				"Select new Noticia(id, cd_autor_fk_usuario, cd_categoria_fk_categoria, nm_noticia, ds_noticia) "
				+ "from Noticia n", 
				Noticia.class);
		return query.getResultList();
	}

	@Override
	public List<Noticia> listarDezPrimeiros() throws Exception {
		TypedQuery<Noticia> query = ConexaoDB.manager.createQuery(
				"Select new Noticia(id, cd_autor_fk_usuario, cd_categoria_fk_categoria, nm_noticia, ds_noticia) "
				+ "from Noticia n", 
				Noticia.class);
		
		return query.setMaxResults(10).getResultList();
	}
}
