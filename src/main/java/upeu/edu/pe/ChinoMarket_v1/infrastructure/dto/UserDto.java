
package upeu.edu.pe.ChinoMarket_v1.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.TypeUser;

public class UserDto {
     private String nombreUsuario;
    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank (message = "Apellido es requerido")
    private String apellido;
    @Email(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank (message = "Dirección es requerido")
    private String direccion;
    @NotBlank (message = "Celular es requerido")
    private String telefono;
    @NotBlank (message = "Clave es requerido")
    private String contraseña;


 
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
     public UserEntity userDtoToUser(){
        return new UserEntity(null, this.getNombreUsuario(), this.getNombre(), this.getApellido(), this.getEmail(),
               this.getDireccion(), this.getTelefono(), this.getContraseña(), LocalDateTime.now(), TypeUser.USER);
    }
}
   
