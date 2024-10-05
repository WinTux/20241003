package com.pepe.p20241003;

import java.util.Collections;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/algo")
public class UnRecurso {
	@GET // http://localhost:8080/p20241003/webapi/algo [GET]
	@Produces(MediaType.TEXT_PLAIN)
	public String saludar() {
		return "Hola a todos! :D";
	}
	@GET // http://localhost:8080/p20241003/webapi/algo/{nombre}?ci=123 [GET]
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{nomb}")
	public String hacerAlgo(@PathParam("nomb") String nom, @QueryParam("ci") int carnet) {
		return "El usuario "+nom + " tiene el ci: " + carnet;
	}
	@GET // http://localhost:8080/p20241003/webapi/algo/{nombre}/{apellido} [GET]
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{nombre}/{apellido}")
	public String hacerAlgo2(@PathParam("nombre") String nom, @PathParam("apellido") String ap) {
		return "El usuario se llama "+nom + " " + ap;
	}
	
	@GET // http://localhost:8080/p20241003/webapi/algo/verificar/{numero} [GET]
	@Path("/verificar/{num}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verificarPrimo(@PathParam("num") int n) {
		int contador = 0;
		for(int i=1; i<=n;i++)
			if(n%i == 0) contador++;
		if(contador==2)
			return Response.ok("El numero es primo.").build();
		else
			return Response.notAcceptable(Collections.emptyList()).build();
	}
}
