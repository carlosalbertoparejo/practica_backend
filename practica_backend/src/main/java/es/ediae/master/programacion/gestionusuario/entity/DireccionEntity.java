package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_calle", nullable = false)
    private String nombreCalle;

    @Column(name = "numero_calle")
    private Integer numeroCalle;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "direccion_principal", nullable = false)
    private Boolean direccionPrincipal = false;

    public DireccionEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreCalle() { return nombreCalle; }
    public void setNombreCalle(String nombreCalle) { this.nombreCalle = nombreCalle; }

    public Integer getNumeroCalle() { return numeroCalle; }
    public void setNumeroCalle(Integer numeroCalle) { this.numeroCalle = numeroCalle; }

    public UsuarioEntity getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntity usuario) { this.usuario = usuario; }

    public Boolean getDireccionPrincipal() { return direccionPrincipal; }
    public void setDireccionPrincipal(Boolean direccionPrincipal) { this.direccionPrincipal = direccionPrincipal; }
}
