
package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderProductEntity;

public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer>{
     public List<OrderProductEntity> findByOrderEntity(OrderEntity orderEntity); 
   
}
