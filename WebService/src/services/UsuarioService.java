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
import controle.UsuarioControle;
import model.Usuario;

@Path("/usuarios")
public class UsuarioService {

	@GET
	@Produces({ "application/json" })
	public List<Usuario> getClientes() {
		try {
			UsuarioControle uc = new UsuarioControle();
			List<Usuario> lista = uc.listar();
			return lista;
		} catch (Exception e) {
			System.out.println("Erro Ao buscar usuarios do bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Usuario getPessoa(@PathParam("id") int id) {
		try {
			UsuarioControle usuarioController = new UsuarioControle();
			return usuarioController.buscar(id);
		} catch (Exception e) {
			System.out.println("Erro ao buscar usuario " + id + " do bd: " + e.getMessage());
			return null;
		}
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addPessoa(Usuario usuario) {
		try {
			System.out.println(usuario.toString());
			UsuarioControle usuarioController = new UsuarioControle();
			if (usuarioController.inserir(usuario))
				return usuario.getEmail() + " adicionado.";
			else
				return "Falha ao adicionar usuario";
		} catch (Exception e) {
			System.out.println("Erro ao inserir usuario " + usuario.getEmail() + " no bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaPessoa(Usuario usuario, @PathParam("id") int id) {
		System.out.println("Entrou no put");
		try {
			UsuarioControle usuarioController = new UsuarioControle();
			usuarioController.alterar(id, usuario);
			return usuario.getId() + " alterado.";
		} catch (Exception e) {
			System.out.println("Erro ao alterar usuario " + usuario.getId() + " no bd: " + e.getMessage());
			return null;
		}
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeCliente(@PathParam("id") int id) {
		try {
			UsuarioControle usuarioController = new UsuarioControle();
			usuarioController.excluir(id);
			return "Usuario " + id + " excluido.";
		} catch (Exception e) {
			System.out.println("Erro ao excluir usuario " + id + " no bd: " + e.getMessage());
			return null;
		}
	}

}
