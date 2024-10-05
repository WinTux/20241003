package com.pepe.p20241003;

import java.util.LinkedList;
import java.util.List;

import com.pepe.p20241003.Modelos.Cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cliente")
public class ClienteResource {
	@GET // http://localhost:8080/p20241003/webapi/cliente [GET]
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getCliente() {
		List<Cliente> lista = new LinkedList<Cliente>();
		
		Cliente cli = new Cliente();
		cli.setNombre("Pepe");
		cli.setEdad(22);
		
		lista.add(cli);
		lista.add(cli);
		lista.add(cli);
		
		return lista;
	}
	@POST // http://localhost:8080/p20241003/webapi/cliente [POST]
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setCliente(Cliente c) {
		return "Recibido: "+c.getNombre();
	}
	
	
}
