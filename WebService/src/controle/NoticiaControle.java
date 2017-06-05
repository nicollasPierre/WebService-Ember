package controle;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Categoria;
import model.Noticia;
import model.Usuario;

public class NoticiaControle implements DAO<Noticia> {
	@Override
	public boolean inserir(Noticia noticia) throws Exception {
		try {
			if (noticia.getAutor() != null && noticia.getConteudo() != null && noticia.getTitulo() != null
					&& noticia.getCategorias() != null) {
				noticia.setAutor(new UsuarioControle().buscar(noticia.getAutor().getId()));
				System.out.println("categoria id: " + noticia.getCategorias().getId());
				Categoria categoria = new CategoriaControle().buscar(noticia.getCategorias().getId());
				if (categoria != null)
					noticia.setCategorias(categoria);
				ConexaoDB.manager.getTransaction().begin();
				ConexaoDB.manager.persist(noticia);
				ConexaoDB.manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Tinha algum campo vazio em noticia");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean alterar(int id, Noticia objeto) throws Exception {
		Noticia nBusca = buscar(id);
		Usuario novo_autor = new UsuarioControle().buscar(objeto.getAutor().getId());
		nBusca.setAutor(novo_autor);
		nBusca.setConteudo(objeto.getConteudo());
		nBusca.setTitulo(objeto.getTitulo());
		Categoria nova_categoria = new CategoriaControle().buscar(objeto.getCategorias().getId());
		nBusca.setCategorias(nova_categoria);
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
				"Select new Noticia(cd_noticia, cd_autor_fk_usuario, cd_categoria_fk_categoria, nm_noticia, ds_noticia) "
						+ "from Noticia n where n.cd_noticia = :cd_noticia",
				Noticia.class);
		query.setParameter("cd_noticia", info);
		try {
			return query.getResultList().get(0);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			// A query retornou nenhum resultado
			return null;
		}
	}

	@Override
	public List<Noticia> listar() throws Exception {
		System.out.println("entrou aqui");
		TypedQuery<Noticia> query = ConexaoDB.manager.createQuery(
				"Select new Noticia(n.id, n.autor, n.categorias, n.titulo, n.conteudo) from Noticia n order by n.id desc", Noticia.class);
		System.out.println("vai sair aqui");
		return query.getResultList();
	}

	@Override
	public List<Noticia> listarDezPrimeiros() throws Exception {
		TypedQuery<Noticia> query = ConexaoDB.manager.createQuery(
				"Select new Noticia(id, autor, categorias, titulo, conteudo) " + "from Noticia n", Noticia.class);

		return query.setMaxResults(10).getResultList();
	}
}
