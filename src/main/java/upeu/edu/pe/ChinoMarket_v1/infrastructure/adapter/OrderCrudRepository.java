package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

    public Iterable<OrderEntity> findByUser(UserEntity user);

}
