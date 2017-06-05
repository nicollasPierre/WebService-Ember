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
		System.out.println("Solicita��o de get feita");
		try {
			NoticiaControle un = new NoticiaControle();
			List<Noticia> lista = un.listar();
			return lista;
		} catch (Exception e) {
			System.out.println("Erro Ao buscar not�cias do bd: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Noticia getNoticia(@PathParam("id") int id) {
		System.out.println("Solicita��o de get feita");
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			return noticiaController.buscar(id);
		} catch (Exception e) {
			System.out.println("Erro ao buscar not�cia " + id + " do bd: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addNoticia(Noticia noticia) {
		
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			if (noticiaController.inserir(noticia))
				return "Not�cia " + noticia.getTitulo() + "(" + noticia.getId() + ") adicionada.";
			else
				return "Erro ao persistir noticia";
		} catch (Exception e) {
			System.out.println("Erro ao inserir not�cia " + noticia.getTitulo() + " no bd: " + e.getMessage());
			e.printStackTrace();
			return "Erro no servidor ao inserir noticia: " + e.getMessage();
		}
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaNoticia(Noticia noticia, @PathParam("id") int id) {
		System.out.println("Solicita��o de put feita");
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			noticiaController.alterar(id, noticia);
			return "Not�cia " + noticia.getTitulo() + "(" + noticia.getId() + ") alterada.";
		} catch (Exception e) {
			System.out.println("Erro ao alterar not�cia " + noticia.getTitulo() + "(" + noticia.getId() + ") no bd: "
					+ e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeNoticia(@PathParam("id") int id) {
		System.out.println("Solicita��o de delete feita");
		try {
			NoticiaControle noticiaController = new NoticiaControle();
			noticiaController.excluir(id);
			return "Not�cia " + id + " exclu�da.";
		} catch (Exception e) {
			System.out.println("Erro ao excluir not�cia " + id + " no bd: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
