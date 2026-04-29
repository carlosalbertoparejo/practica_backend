package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nick_usuario", nullable = false, unique = true)
    private String nickUsuario;

    @Column(nullable = false)
    private String contrasena;

    @Column(name = "fecha_hora_creacion", nullable = false)
    private LocalDateTime fechaHoraCreacion;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "hora_desayuno")
    private LocalTime horaDesayuno;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private GeneroEntity genero;

    @ManyToOne
    @JoinColumn(name = "puesto_trabajo_id")
    private PuestoDeTrabajoEntity puestoDeTrabajo;

    @Column(name = "es_admin", nullable = false)
    private boolean esAdmin = false;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionEntity> direcciones = new ArrayList<>();

    public UsuarioEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNickUsuario() { return nickUsuario; }
    public void setNickUsuario(String nickUsuario) { this.nickUsuario = nickUsuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public LocalDateTime getFechaHoraCreacion() { return fechaHoraCreacion; }
    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) { this.fechaHoraCreacion = fechaHoraCreacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public LocalTime getHoraDesayuno() { return horaDesayuno; }
    public void setHoraDesayuno(LocalTime horaDesayuno) { this.horaDesayuno = horaDesayuno; }

    public GeneroEntity getGenero() { return genero; }
    public void setGenero(GeneroEntity genero) { this.genero = genero; }

    public PuestoDeTrabajoEntity getPuestoDeTrabajo() { return puestoDeTrabajo; }
    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) { this.puestoDeTrabajo = puestoDeTrabajo; }

    public boolean isEsAdmin() { return esAdmin; }
    public void setEsAdmin(boolean esAdmin) { this.esAdmin = esAdmin; }

    public List<DireccionEntity> getDirecciones() { return direcciones; }
    public void setDirecciones(List<DireccionEntity> direcciones) { this.direcciones = direcciones; }
}
