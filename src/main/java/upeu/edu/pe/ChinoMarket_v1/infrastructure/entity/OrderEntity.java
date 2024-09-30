
package upeu.edu.pe.ChinoMarket_v1.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fechaCreado;
    private String status;
    
    @ManyToOne //no mapeo a la bd
    private UserEntity user;
    
    @Transient
    private List<OrderProductEntity> orderProducts;  
    
    
    /*agregar productos al arreglo*/
     public void addOrdersProduct(List<OrderProductEntity> orderProducts){
        this.setOrderProducts(orderProducts);
    }
    
    public BigDecimal getTotalOrderPrice(){
        return getOrderProducts().stream().map(
                p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}