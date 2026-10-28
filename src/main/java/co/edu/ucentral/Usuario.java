package co.edu.ucentral;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class Usuario extends PanacheEntity {
    
    @Column(unique = true, nullable = false)
    public String documento;

    public String nombre;

    @Column(unique = true, nullable = false)
    public String correo;

    public String contrasena;
    public String tipoUsuario;

    public static boolean existeCorreo(String correo) {
        return find("correo", correo).firstResult() != null;
    }

    public static boolean existeDocumento(String documento) {
        return find("documento", documento).firstResult() != null;
    }
}