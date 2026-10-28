package co.edu.ucentral;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/citas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitaResource {

    @GET
    @Path("/usuario/{idUsuario}")
    public Response obtenerCitasPorUsuario(@PathParam("idUsuario") Long idUsuario) {
        List<Cita> citas = Cita.listByUsuario(idUsuario);
        if (citas.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("No se encontraron citas para el usuario.")
                           .build();
        }
        return Response.ok(citas).build();
    }
}