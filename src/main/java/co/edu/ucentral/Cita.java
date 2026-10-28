package co.edu.ucentral;

import java.time.LocalDateTime;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Cita extends PanacheEntity {

    @Column(name = "id_usuario", nullable = false)
    public Long idUsuario;

    @Column(nullable = false)
    public String medico;

    @Column(nullable = false)
    public String especialidad;

    @Column(name = "fecha_hora", nullable = false)
    public LocalDateTime fechaHora;

    @Column(nullable = false)
    public String estado;

    public static List<Cita> listByUsuario(Long idUsuario) {
        return list("idUsuario", idUsuario);
    }
}