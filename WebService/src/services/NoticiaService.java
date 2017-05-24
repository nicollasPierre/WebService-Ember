package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controle.NoticiaControle;
import model.Noticia;

@Path("/noticia")
public class NoticiaService {
	@GET
	@Produces({ "application/json" })
	public List<Noticia> getNoticias() {
		try {
			NoticiaControle un = new NoticiaControle();
			List<Noticia> lista = un.listar();
			return lista;
		} catch (Exception e) {
			System.out.println("Erro Ao buscar notícias do bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Noticia getNoticia(@PathParam("id") int id) {
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			return noticiaController.buscar(id);
		} catch (Exception e) {
			System.out.println("Erro ao buscar notícia " + id + " do bd: " + e.getMessage());
			return null;
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addNoticia(Noticia noticia) {
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			noticiaController.inserir(noticia);
			return "Notícia " + noticia.getTitulo() + "(" + noticia.getId() +") adicionada.";
		} catch (Exception e) {
			System.out.println("Erro ao inserir notícia " + noticia.getTitulo() + " no bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaNoticia(Noticia noticia, @PathParam("id") int id) {
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			noticiaController.alterar(id, noticia);
			return "Notícia " + noticia.getTitulo() + "(" + noticia.getId() +") alterada.";
		} catch (Exception e) {
			System.out.println("Erro ao alterar notícia " + noticia.getTitulo() + "(" + noticia.getId() +") no bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeNoticia(@PathParam("id") int id) {
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			noticiaController.excluir(id);
			return "Notícia "+id + " excluída.";
		} catch (Exception e) {
			System.out.println("Erro ao excluir notícia " + id + " no bd: " + e.getMessage());
			return null;
		}
	}

}
