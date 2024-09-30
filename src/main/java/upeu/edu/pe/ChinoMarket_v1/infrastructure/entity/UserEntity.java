
package upeu.edu.pe.ChinoMarket_v1.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String telefono;
    private String contraseña;
    private LocalDateTime fechaCreado;
    
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    public UserEntity() {
    }

    public UserEntity(Integer id, String nombreUsuario, String nombre, String apellido, String email, String direccion, String telefono, String contraseña, LocalDateTime fechaCreado, TypeUser typeUser) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.fechaCreado = fechaCreado;
        this.typeUser = typeUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDateTime getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDateTime fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

}

    