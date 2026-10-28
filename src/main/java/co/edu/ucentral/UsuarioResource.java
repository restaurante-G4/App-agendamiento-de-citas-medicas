package co.edu.ucentral;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @POST
    @Path("/registro")
    @Transactional
    public Response registrarUsuario(Usuario usuario) {
        // Validaciones Criterios de Aceptación
        if (usuario.correo == null || !usuario.correo.contains("@")) {
            return Response.status(Response.Status.BAD_REQUEST)
                   .entity("{\"error\": \"El correo electrónico no tiene un formato válido.\"}").build();
        }

        if (Usuario.existeCorreo(usuario.correo)) {
            return Response.status(Response.Status.BAD_REQUEST)
                   .entity("{\"error\": \"El correo ya se encuentra registrado.\"}").build();
        }

        if (Usuario.existeDocumento(usuario.documento)) {
            return Response.status(Response.Status.BAD_REQUEST)
                   .entity("{\"error\": \"El número de documento ya está asociado a otra cuenta.\"}").build();
        }

        if (usuario.contrasena == null || usuario.contrasena.length() < 6) {
            return Response.status(Response.Status.BAD_REQUEST)
                   .entity("{\"error\": \"La contraseña debe tener al menos 6 caracteres.\"}").build();
        }

        usuario.persist();
        return Response.status(Response.Status.CREATED)
               .entity("{\"mensaje\": \"Registro exitoso\"}").build();
    }

    // --- AGREGAR DESDE AQUÍ ---
    @GET
    public List<Usuario> listarUsuarios() {
        return Usuario.listAll();
    }
    // --- HASTA AQUÍ ---
}