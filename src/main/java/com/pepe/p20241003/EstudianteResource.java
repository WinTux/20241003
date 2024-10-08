package com.pepe.p20241003;

import java.util.LinkedList;
import java.util.List;

import com.pepe.p20241003.Modelos.Cliente;
import com.pepe.p20241003.Modelos.Estudiante;
import com.pepe.p20241003.herramientas.EstudianteConector;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estudiante")
public class EstudianteResource {
	EstudianteConector conector = new EstudianteConector();
	@GET // http://localhost:8080/p20241003/webapi/estudiante [GET]
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantes() {
		return conector.getEstudiantes();
	}
	@GET // http://localhost:8080/p20241003/webapi/estudiante/{matricula} [GET]
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{matricula}")
	public Estudiante getEstudiante(@PathParam("matricula") int m) {
		return conector.getEstudiante(m);
	}
	@POST // http://localhost:8080/p20241003/webapi/estudiante [POST]
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setEstudiante(Estudiante es) {
		conector.crearEstudiante(es);
		return "Creado";
	}
	@PUT // http://localhost:8080/p20241003/webapi/estudiante/{matricula} [PUT]
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{matricula}")
	public String putEstudiante(@PathParam("matricula") int m, Estudiante es) {
		es.setMatricula(m);
		conector.actualizarEstudiante(es);
		return "Modificado";
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{matricula}")
	public String deleteEstudiante(@PathParam("matricula") int m) {
		conector.eliminarEstudiante(m);
		return "Eliminado";
	}
}
