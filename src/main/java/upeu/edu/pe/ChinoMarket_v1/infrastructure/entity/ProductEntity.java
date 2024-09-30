
package upeu.edu.pe.ChinoMarket_v1.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos") //IMPORTANTE//
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
   
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String imagen;
    private BigDecimal precio;
    
    private LocalDateTime fechaCreado;
    private LocalDateTime fechaActualizado;
    
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private UserEntity userEntity;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String codigo, String nombre, String descripcion, String imagen, BigDecimal precio, LocalDateTime fechaCreado, LocalDateTime fechaActualizado, UserEntity userEntity) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.fechaCreado = fechaCreado;
        this.fechaActualizado = fechaActualizado;
        this.userEntity = userEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDateTime fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public LocalDateTime getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(LocalDateTime fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}
