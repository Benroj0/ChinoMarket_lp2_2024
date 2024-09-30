
package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.OrderProductRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderProductEntity;

@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository orderCrudRepository;

    public OrderProductRepositoryImpl(OrderProductCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }
    

    @Override
    public OrderProductEntity create(OrderProductEntity orderProduct) {
        return orderCrudRepository.save(orderProduct);
    }

    @Override
    public Iterable<OrderProductEntity> getOrderProducts() {
        return orderCrudRepository.findAll();
    }

    @Override
    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity) {
        return orderCrudRepository.findByOrderEntity(orderEntity);
    }
}