package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import controle.ClienteControle;
import model.Cliente;

@Path("/clientes2")
public class ClienteServiceBD {

	private ClienteControle controle = new ClienteControle();
	
	@GET
	@Produces({"application/json"})
	public List<Cliente> getClientes() throws Exception {
		List<Cliente> clientes = controle.listar();
		System.out.println(clientes.size());
		return new ArrayList<Cliente>(clientes);
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Cliente getPessoa(@PathParam("id") int id) throws Exception {
		return controle.buscar(id);
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addPessoa(Cliente cliente) throws Exception {
		controle.inserir(cliente);
		return cliente.getNome() + " adicionado.";
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaPessoa(Cliente cliente, @PathParam("id") int id) throws Exception {
		controle.alterar(id, cliente);
		return cliente.getNome() + " atualizado.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeCliente(@PathParam("id") int id) throws Exception {
		controle.excluir(id);
		return "Cliente removido.";
	}
}
