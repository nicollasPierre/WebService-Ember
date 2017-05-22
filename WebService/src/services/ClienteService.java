package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Cliente;

@Path("/clientes")
public class ClienteService {

	static private Map<Integer, Cliente> clientes;

	static {
		clientes = new HashMap();

		Cliente c1 = new Cliente();
		c1.setId(1);
		c1.setNome("Maria");

		clientes.put(c1.getId(), c1);

		Cliente c2 = new Cliente();
		c2.setId(2);
		c2.setNome("Antônio");

		clientes.put(c2.getId(), c2);
	}

	@GET
	@Produces({"application/json"})
	public List<Cliente> getClientes() {
		return new ArrayList<Cliente>(clientes.values());
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Cliente getPessoa(@PathParam("id") int id) {
		return clientes.get(id);
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addPessoa(Cliente cliente) {
		cliente.setId(clientes.size() + 1);
		clientes.put(cliente.getId(), cliente);
		return cliente.getNome() + " adicionado.";
	}

	@Path("{id}")
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualizaPessoa(Cliente cliente, @PathParam("id") int id) {
		Cliente atual = clientes.get(id);
		atual.setNome(cliente.getNome());
		return cliente.getNome() + " atualizado.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeCliente(@PathParam("id") int id) {
		clientes.remove(id);
		return "Cliente removido.";
	}
}
